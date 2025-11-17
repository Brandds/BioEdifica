package com.edifica.bioedifica.dto.usuario;

import com.edifica.bioedifica.enums.usuario.RoleUsuario;

public record UsuarioCadastroDTO (
    String nome,
    String email,
    String senha,
    RoleUsuario perfil
) {
  
}
