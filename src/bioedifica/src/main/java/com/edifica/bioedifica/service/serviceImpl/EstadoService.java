package com.edifica.bioedifica.service.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edifica.bioedifica.dto.cidade.EstadoDTO;
import com.edifica.bioedifica.exception.EntityNotFoundException;
import com.edifica.bioedifica.mapper.EstadoMapper;
import com.edifica.bioedifica.repository.EstadoRepository;
import com.edifica.bioedifica.service.IEstadoService;

@Service("estadoServiceImpl")
public class EstadoService implements IEstadoService {
    
    @Autowired
    private EstadoRepository estadoRepository;

    @Override
    public EstadoDTO salvar(EstadoDTO estadoDTO) {
        var estado = EstadoMapper.toEntity(estadoDTO);
        var salvo = estadoRepository.save(estado);
        return EstadoMapper.toDTO(salvo);
    }

    @Override
    public List<EstadoDTO> listarTodos() {
        return estadoRepository.findAll().stream()
            .map(EstadoMapper::toDTO)
            .toList();
    }

    @Override
    public Optional<EstadoDTO> buscarPorId(Long id) {
        return estadoRepository.findById(id)
            .map(EstadoMapper::toDTO);
    }

    @Override
    public Optional<EstadoDTO> buscarPorUf(String uf) {
        return estadoRepository.findByUf(uf)
            .map(EstadoMapper::toDTO);
    }

    @Override
    public List<EstadoDTO> buscarPorNome(String nome) {
        return estadoRepository.findByNomeContainingIgnoreCase(nome).stream()
            .map(EstadoMapper::toDTO)
            .toList();
    }

    @Override
    public void deletar(Long id) {
        if (!estadoRepository.existsById(id)) {
            throw new EntityNotFoundException("Estado não encontrado com ID: " + id);
        }
        estadoRepository.deleteById(id);
    }

    @Override
    public EstadoDTO atualizar(Long id, EstadoDTO estadoAtualizado) {
        var estadoExistente = estadoRepository.findById(id)
            .orElseThrow(() -> new EntityNotFoundException("Estado não encontrado com ID: " + id));
        
        EstadoMapper.updateEntityFromDTO(estadoExistente, estadoAtualizado);
        var salvo = estadoRepository.save(estadoExistente);
        return EstadoMapper.toDTO(salvo);
    }

    @Override
    public boolean existePorUf(String uf) {
        return estadoRepository.existsByUf(uf);
    }
}