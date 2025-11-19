package com.edifica.bioedifica.mapper;

import java.util.stream.Collectors;

import com.edifica.bioedifica.dto.UsuarioDTO;
import com.edifica.bioedifica.dto.UsuarioPerfilDTO;
import com.edifica.bioedifica.dto.projeto.ProjetoDTO;
import com.edifica.bioedifica.dto.usuario.LoginResponse;
import com.edifica.bioedifica.dto.usuario.UsuarioCadastroDTO;
import com.edifica.bioedifica.dto.usuario.UsuarioLoginResponse;
import com.edifica.bioedifica.model.Usuario;

public class UsuarioMapper {
    public static UsuarioDTO toDTO(Usuario usuario) {
        if (usuario == null) return null;
        return new UsuarioDTO(
            usuario.getId(),
            usuario.getNome(),
            usuario.getEmail(),
            usuario.getPerfil()
        );
    }

    public static void updateEntityFromDTO(Usuario usuario, UsuarioDTO dto) {
        if (usuario == null || dto == null) return;
        usuario.setNome(dto.nome());
        usuario.setEmail(dto.email());
    }

    public static Usuario toEntity(UsuarioDTO dto) {
        if (dto == null) return null;
        var usuario = new Usuario();
        usuario.setId(dto.id());
        usuario.setNome(dto.nome());
        usuario.setEmail(dto.email());
        usuario.setPerfil(dto.perfil());
        return usuario;
    }

    public static UsuarioPerfilDTO exibirUsuarioPerfil(Usuario usuario) {
        if (usuario == null) return null;
        var projetosDTO = usuario.getProjetos() == null ? null : usuario.getProjetos().stream()
            .map(projeto -> new ProjetoDTO(projeto.getId(), projeto.getNome(), projeto.getDescricao(), usuario.getId(), null))
            .collect(Collectors.toList());
        return new UsuarioPerfilDTO(
            usuario.getNome(),
            usuario.getPerfil(),
            projetosDTO
        );
    }

    public static LoginResponse toLoginResponse(UsuarioDTO usuario, String token) {
        if (usuario == null) return null;
        return new LoginResponse(
            token,
            new UsuarioLoginResponse(
                usuario.id(),
                usuario.nome(),
                usuario.email()
            )
        );
    }

      public static Usuario toEntity(UsuarioCadastroDTO dto) {
        if (dto == null) return null;
        var usuario = new Usuario();
        usuario.setNome(dto.nome());
        usuario.setEmail(dto.email());
        usuario.setPerfil(dto.perfil());
        usuario.setSenha(dto.senha());
        return usuario;
    }
}
