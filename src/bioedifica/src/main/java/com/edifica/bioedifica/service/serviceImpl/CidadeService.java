package com.edifica.bioedifica.service.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edifica.bioedifica.dto.cidade.CidadeDTO;
import com.edifica.bioedifica.dto.cidade.CidadeUsuarioDTO;
import com.edifica.bioedifica.dto.cidade.ZoneamentoDTO;
import com.edifica.bioedifica.enums.cidade.TipoCidade;
import com.edifica.bioedifica.exception.EntityNotFoundException;
import com.edifica.bioedifica.mapper.CidadeMapper;
import com.edifica.bioedifica.mapper.ZoneamentoBioclimaticoMapper;
import com.edifica.bioedifica.model.Cidade;
import com.edifica.bioedifica.model.Estado;
import com.edifica.bioedifica.model.Usuario;
import com.edifica.bioedifica.repository.CidadeRepository;
import com.edifica.bioedifica.repository.EstadoRepository;
import com.edifica.bioedifica.repository.UsuarioRepository;
import com.edifica.bioedifica.service.ICidadeService;
import com.edifica.bioedifica.service.IZoneamentoBioclimaticoService;

@Service("cidadeServiceImpl")
public class CidadeService implements ICidadeService {
    
    @Autowired
    private CidadeRepository cidadeRepository;
    
    @Autowired
    private EstadoRepository estadoRepository;
    
    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired 
    private IZoneamentoBioclimaticoService zoneamentoBioclimaticoService;

    @Override
    public CidadeDTO salvar(CidadeDTO cidadeDTO) {
        var cidade = CidadeMapper.toEntity(cidadeDTO);
        var salvo = cidadeRepository.save(cidade);
        return CidadeMapper.toDTO(salvo);
    }

    @Override
    public List<CidadeDTO> listarTodos() {
        return cidadeRepository.findAll().stream()
            .map(CidadeMapper::toDTO)
            .toList();
    }

    @Override
    public List<CidadeDTO> listarPorTipo(TipoCidade tipo) {
        return cidadeRepository.findByTipo(tipo).stream()
            .map(CidadeMapper::toDTO)
            .toList();
    }

    @Override
    public Optional<CidadeDTO> buscarPorId(Long id) {
        return cidadeRepository.findById(id)
            .map(CidadeMapper::toDTO);
    }

    @Override
    public List<CidadeDTO> buscarPorUf(String uf) {
        return cidadeRepository.findByEstadoUf(uf).stream()
            .map(CidadeMapper::toDTO)
            .toList();
    }

    @Override
    public List<CidadeDTO> buscarPorUfETipo(String uf, TipoCidade tipo) {
        return cidadeRepository.findByEstadoUfAndTipo(uf, tipo).stream()
            .map(CidadeMapper::toDTO)
            .toList();
    }

    @Override
    public Optional<CidadeDTO> buscarPorNomeEUf(String nome, String uf) {
        return cidadeRepository.findByNomeAndEstadoUf(nome, uf)
            .map(CidadeMapper::toDTO);
    }

    @Override
    public List<CidadeDTO> buscarPorNome(String nome) {
        return cidadeRepository.findByNomeContainingIgnoreCase(nome).stream()
            .map(CidadeMapper::toDTO)
            .toList();
    }

    @Override
    public List<CidadeDTO> buscarPorNomeETipo(String nome, TipoCidade tipo) {
        return cidadeRepository.findByNomeContainingIgnoreCaseAndTipo(nome, tipo).stream()
            .map(CidadeMapper::toDTO)
            .toList();
    }

    @Override
    public List<CidadeDTO> buscarPorUfENome(String uf, String nome) {
        return cidadeRepository.findByUfAndNomeContaining(uf, nome).stream()
            .map(CidadeMapper::toDTO)
            .toList();
    }

    @Override
    public List<CidadeDTO> buscarPorUfENomeETipo(String uf, String nome, TipoCidade tipo) {
        return cidadeRepository.findByEstadoUfAndNomeContainingIgnoreCaseAndTipo(uf, nome, tipo).stream()
            .map(CidadeMapper::toDTO)
            .toList();
    }

    @Override
    public void deletar(Long id) {
        if (!cidadeRepository.existsById(id)) {
            throw new EntityNotFoundException("Cidade não encontrada com ID: " + id);
        }
        cidadeRepository.deleteById(id);
    }

    @Override
    public CidadeDTO atualizar(Long id, CidadeDTO cidadeAtualizada) {
        var cidadeExistente = cidadeRepository.findById(id)
            .orElseThrow(() -> new EntityNotFoundException("Cidade não encontrada com ID: " + id));
        
        CidadeMapper.updateEntityFromDTO(cidadeExistente, cidadeAtualizada);
        var salvo = cidadeRepository.save(cidadeExistente);
        return CidadeMapper.toDTO(salvo);
    }

    @Override
    public boolean existePorNomeEUf(String nome, String uf) {
        return cidadeRepository.existsByNomeAndEstadoUf(nome, uf);
    }

    @Override
    public CidadeDTO criarCidadeUsuario(Long usuarioId, CidadeUsuarioDTO cidadeUsuarioDTO) {
        // Buscar o estado
        Estado estado = estadoRepository.findById(cidadeUsuarioDTO.getEstadoId())
            .orElseThrow(() -> new EntityNotFoundException("Estado não encontrado com ID: " + cidadeUsuarioDTO.getEstadoId()));
        
        // Buscar o usuário criador
        Usuario usuarioCriador = usuarioRepository.findById(usuarioId)
            .orElseThrow(() -> new EntityNotFoundException("Usuário não encontrado com ID: " + usuarioId));
                
        // Criar a nova cidade do usuário
        Cidade cidade = new Cidade();
        cidade.setNome(cidadeUsuarioDTO.getNome());
        cidade.setEstado(estado);
        cidade.setTipo(TipoCidade.USUARIO);
        cidade.setUsuarioCriador(usuarioCriador);
        
        // Salvar a cidade
        Cidade cidadeSalva = cidadeRepository.save(cidade);

        ZoneamentoDTO zoneamentoBioclimaticoDTO = cidadeUsuarioDTO.getZoneamentoBioclimatico();
        if(zoneamentoBioclimaticoDTO != null) {
            var zoneamentoEntity = ZoneamentoBioclimaticoMapper.toZoneamentoUsuario(zoneamentoBioclimaticoDTO, cidadeSalva.getId());
            zoneamentoBioclimaticoService.salvar(zoneamentoEntity);
        }
        return CidadeMapper.toDTO(cidadeSalva);
    }

    @Override
    public List<CidadeDTO> buscarPorUsuarioCriador(Long usuarioId) {
        return cidadeRepository.findByUsuarioCriadorId(usuarioId).stream()
            .map(CidadeMapper::toDTO)
            .toList();
    }
}