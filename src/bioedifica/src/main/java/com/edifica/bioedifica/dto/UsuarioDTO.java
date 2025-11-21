package com.edifica.bioedifica.dto;

import com.edifica.bioedifica.enums.usuario.RoleUsuario;

public record UsuarioDTO(
    Long id,
    String nome,
    String email,
    RoleUsuario perfil,
    String senha
) {}
