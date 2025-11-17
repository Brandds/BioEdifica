package com.edifica.bioedifica.service;

import java.util.List;
import java.util.Optional;

import com.edifica.bioedifica.dto.UsuarioDTO;
import com.edifica.bioedifica.dto.usuario.UsuarioCadastroDTO;

public interface IUsuarioService {
    UsuarioDTO salvar(UsuarioCadastroDTO usuarioDTO);
    List<UsuarioDTO> listarTodos();
    Optional<UsuarioDTO> buscarPorId(Long id);
    void deletar(Long id);
    UsuarioDTO atualizar(Long id, UsuarioDTO usuarioAtualizado);
    Optional<UsuarioDTO> buscarPorUsername(String username);
    boolean autenticar(String username, String senha);
}
