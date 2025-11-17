package com.edifica.bioedifica.service;

import java.util.List;
import java.util.Optional;

import com.edifica.bioedifica.dto.cidade.EstadoDTO;

public interface IEstadoService {
    EstadoDTO salvar(EstadoDTO estadoDTO);
    List<EstadoDTO> listarTodos();
    Optional<EstadoDTO> buscarPorId(Long id);
    Optional<EstadoDTO> buscarPorUf(String uf);
    List<EstadoDTO> buscarPorNome(String nome);
    void deletar(Long id);
    EstadoDTO atualizar(Long id, EstadoDTO estadoAtualizado);
    boolean existePorUf(String uf);
}