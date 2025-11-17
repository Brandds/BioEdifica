package com.edifica.bioedifica.dto.usuario;

public record LoginResponse(
    String token,
    UsuarioLoginResponse user
){}
