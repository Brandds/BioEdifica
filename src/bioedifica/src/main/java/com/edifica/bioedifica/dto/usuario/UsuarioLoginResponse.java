package com.edifica.bioedifica.dto.usuario;

public record UsuarioLoginResponse(
    Long userId,
    String nome,
    String email
) {
  
}
