package com.edifica.bioedifica.service.serviceImpl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edifica.bioedifica.dto.projeto.ProjetoDTO;
import com.edifica.bioedifica.dto.projeto.ProjetoDetalhadoDTO;
import com.edifica.bioedifica.mapper.ProjetoMapper;
import com.edifica.bioedifica.model.Projeto;
import com.edifica.bioedifica.model.Usuario;
import com.edifica.bioedifica.repository.ProjetoRepository;
import com.edifica.bioedifica.service.IProjetoService;

@Service
public class ProjetoService implements IProjetoService {

  @Autowired
  private MockMaterialService mockMaterialService;

  
  public ProjetoService(ProjetoRepository projetoRepository) {
    this.projetoRepository = projetoRepository;
  }
  private ProjetoRepository projetoRepository;

  @Override
  public ProjetoDetalhadoDTO criarProjeto(ProjetoDTO projetoDTO) {
    var usuario = new Usuario();
    usuario.setId(projetoDTO.usuarioId());

    var projeto = new Projeto(projetoDTO.nome(), projetoDTO.descricao(), usuario);
    projetoRepository.save(projeto);

    return new ProjetoDetalhadoDTO(projeto.getId(), projeto.getNome(), projeto.getDescricao(), List.of());
  }

  @Override
  public ProjetoDetalhadoDTO getProjetoById(Long id) {
    var projeto = projetoRepository.findById(id);

    if (projeto.isPresent()) {
      var materiais = projeto.get().getMateriais();
      List<Long> idsMateriais =  materiais
        .stream()
        .map(mp -> mp.getIdMaterialExterno())
        .collect(Collectors.toList());
      
      var materiaisDoProjeto = mockMaterialService.getMaterialByProjeto(idsMateriais);

      return new ProjetoDetalhadoDTO(projeto.get().getId(), projeto.get().getNome(), projeto.get().getDescricao(), materiaisDoProjeto);
    }
    throw new org.springframework.web.server.ResponseStatusException(org.springframework.http.HttpStatus.NOT_FOUND, "Projeto não encontrado");
  }

  @Override
  public List<ProjetoDTO> getProjetoByUsuario(Long idUsuario) {
    var projetos = projetoRepository.findByUsuarioIdAndAtivo(idUsuario, true);
    if (!projetos.isEmpty()) {
      return projetos.stream()
        .map(projeto -> new ProjetoDTO(projeto.getId(), projeto.getNome(), projeto.getDescricao(), projeto.getUsuario().getId()))
        .collect(Collectors.toList());
    }
    return List.of();
  }

  @Override
  public ProjetoDetalhadoDTO atualizarProjeto(ProjetoDetalhadoDTO projetoDTO, Long idUsuario) {
    var projeto = ProjetoMapper.toEntity(projetoDTO, new Usuario(idUsuario));

    projetoRepository.save(projeto);
    return ProjetoMapper.toDetalhadoDTO(projeto); 
  }

  @Override
  public void deletarProjeto(Long idProjeto, Long idUsuario) {
    var projeto = projetoRepository.findById(idProjeto);
    if (projeto.isPresent()) {
      projeto.get().setAtivo(false);
      projetoRepository.save(projeto.get());
    } else {
      throw new org.springframework.web.server.ResponseStatusException(org.springframework.http.HttpStatus.NOT_FOUND, "Projeto não encontrado");
    }
  }

}
