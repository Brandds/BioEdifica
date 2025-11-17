package com.edifica.bioedifica.dto;

import java.util.List;

import com.edifica.bioedifica.dto.projeto.ProjetoDTO;
import com.edifica.bioedifica.enums.usuario.RoleUsuario;

public record UsuarioPerfilDTO(
    String nome,
    RoleUsuario perfil,
    List<ProjetoDTO> projetos
) {}
