package com.edifica.bioedifica.service;

import java.util.List;
import java.util.Optional;

import com.edifica.bioedifica.dto.cidade.CidadeDTO;
import com.edifica.bioedifica.dto.cidade.CidadeUsuarioDTO;

public interface ICidadeService {
    CidadeDTO salvar(CidadeDTO cidadeDTO);
    List<CidadeDTO> listarTodos();
    List<CidadeDTO> listarPorTipo(com.edifica.bioedifica.enums.cidade.TipoCidade tipo);
    Optional<CidadeDTO> buscarPorId(Long id);
    List<CidadeDTO> buscarPorUf(String uf);
    List<CidadeDTO> buscarPorUfETipo(String uf, com.edifica.bioedifica.enums.cidade.TipoCidade tipo);
    Optional<CidadeDTO> buscarPorNomeEUf(String nome, String uf);
    List<CidadeDTO> buscarPorNome(String nome);
    List<CidadeDTO> buscarPorNomeETipo(String nome, com.edifica.bioedifica.enums.cidade.TipoCidade tipo);
    List<CidadeDTO> buscarPorUfENome(String uf, String nome);
    List<CidadeDTO> buscarPorUfENomeETipo(String uf, String nome, com.edifica.bioedifica.enums.cidade.TipoCidade tipo);
    void deletar(Long id);
    CidadeDTO atualizar(Long id, CidadeDTO cidadeAtualizada);
    boolean existePorNomeEUf(String nome, String uf);
    
    // Métodos para cidades de usuário
    CidadeDTO criarCidadeUsuario(Long usuarioId, CidadeUsuarioDTO cidadeUsuarioDTO);
    List<CidadeDTO> buscarPorUsuarioCriador(Long usuarioId);
}