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
import com.edifica.bioedifica.repository.CidadeRepository;
import com.edifica.bioedifica.repository.ProjetoRepository;
import com.edifica.bioedifica.service.IProjetoService;

@Service
public class ProjetoService implements IProjetoService {

  @Autowired
  private MockMaterialService mockMaterialService;

  @Autowired
  private CidadeRepository cidadeRepository;

  
  public ProjetoService(ProjetoRepository projetoRepository) {
    this.projetoRepository = projetoRepository;
  }
  private ProjetoRepository projetoRepository;

  @Override
  public ProjetoDetalhadoDTO criarProjeto(ProjetoDTO projetoDTO) {
    var usuario = new Usuario();
    usuario.setId(projetoDTO.usuarioId());

    var projeto = new Projeto(projetoDTO.nome(), projetoDTO.descricao(), usuario);
    projeto.setAreaTotalConstruida(projetoDTO.areaTotalConstruida());
    
    if(projetoDTO.cidadeId() != null) {
      var cidade = cidadeRepository.findById(projetoDTO.cidadeId())
        .orElseThrow(() -> new org.springframework.web.server.ResponseStatusException(
          org.springframework.http.HttpStatus.NOT_FOUND, 
          "Cidade não encontrada"
        ));
      projeto.setCidade(cidade);
    }
    
    projetoRepository.save(projeto);

    return ProjetoMapper.toDetalhadoDTO(projeto);
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

      var projetoDTO = ProjetoMapper.toDetalhadoDTO(projeto.get());
      return new ProjetoDetalhadoDTO(
        projetoDTO.id(),
        projetoDTO.nome(),
        projetoDTO.descricao(),
        materiaisDoProjeto,
        projetoDTO.cidade(),
        projetoDTO.areaTotalConstruida()
      );
    }
    throw new org.springframework.web.server.ResponseStatusException(org.springframework.http.HttpStatus.NOT_FOUND, "Projeto não encontrado");
  }

  @Override
  public List<ProjetoDTO> getProjetoByUsuario(Long idUsuario) {
    var projetos = projetoRepository.findByUsuarioIdAndAtivo(idUsuario, true);
    if (!projetos.isEmpty()) {
      return projetos.stream()
        .map(projeto -> new ProjetoDTO(
          projeto.getId(), 
          projeto.getNome(), 
          projeto.getDescricao(), 
          projeto.getUsuario().getId(),
          projeto.getCidade() != null ? projeto.getCidade().getId() : null,
          projeto.getAreaTotalConstruida()
        ))
        .collect(Collectors.toList());
    }
    return List.of();
  }

  @Override
  public ProjetoDetalhadoDTO atualizarProjeto(ProjetoDTO projetoDTO, Long idUsuario) {
    var projetoExistente = projetoRepository.findById(projetoDTO.id())
      .orElseThrow(() -> new org.springframework.web.server.ResponseStatusException(
        org.springframework.http.HttpStatus.NOT_FOUND, 
        "Projeto não encontrado"
      ));

    // Atualizar campos
    projetoExistente.setNome(projetoDTO.nome());
    projetoExistente.setDescricao(projetoDTO.descricao());
    projetoExistente.setAreaTotalConstruida(projetoDTO.areaTotalConstruida());

    // Atualizar cidade
    if(projetoDTO.cidadeId() != null) {
      var cidade = cidadeRepository.findById(projetoDTO.cidadeId())
        .orElseThrow(() -> new org.springframework.web.server.ResponseStatusException(
          org.springframework.http.HttpStatus.NOT_FOUND, 
          "Cidade não encontrada"
        ));
      projetoExistente.setCidade(cidade);
    } else {
      projetoExistente.setCidade(null);
    }

    projetoRepository.save(projetoExistente);
    return ProjetoMapper.toDetalhadoDTO(projetoExistente); 
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
