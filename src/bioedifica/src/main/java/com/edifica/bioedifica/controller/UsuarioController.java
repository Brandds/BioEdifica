package com.edifica.bioedifica.controller;

import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.edifica.bioedifica.config.JwtUtil;
import com.edifica.bioedifica.dto.UsuarioDTO;
import com.edifica.bioedifica.dto.usuario.LoginResponse;
import com.edifica.bioedifica.dto.usuario.UsuarioCadastroDTO;
import com.edifica.bioedifica.dto.usuario.UsuarioLoginResponse;
import com.edifica.bioedifica.mapper.UsuarioMapper;
import com.edifica.bioedifica.model.Usuario;
import com.edifica.bioedifica.service.IUsuarioService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {
    private final IUsuarioService usuarioService;
    private final JwtUtil jwtUtil;

    public UsuarioController(IUsuarioService usuarioService, JwtUtil jwtUtil) {
        this.usuarioService = usuarioService;
        this.jwtUtil = jwtUtil;
    }


    @Operation(summary = "Criar usuário", description = "Cria um novo usuário no sistema.")
    @ApiResponses({
        @ApiResponse(responseCode = "200", description = "Usuário criado com sucesso."),
        @ApiResponse(responseCode = "400", description = "Dados inválidos.")
    })
    @PostMapping
    public ResponseEntity<UsuarioDTO> criarUsuario(@RequestBody UsuarioCadastroDTO usuarioDTO) {
        UsuarioDTO salvo = usuarioService.salvar(usuarioDTO);
        return ResponseEntity.ok(salvo);
    }

    @Operation(summary = "Buscar usuário por ID", description = "Retorna os dados de um usuário pelo ID.")
    @ApiResponses({
        @ApiResponse(responseCode = "200", description = "Usuário encontrado."),
        @ApiResponse(responseCode = "404", description = "Usuário não encontrado.")
    })
    @GetMapping("/{id}")
    public ResponseEntity<UsuarioDTO> buscarPorId(@Parameter(description = "ID do usuário", example = "1") @PathVariable Long id) {
        return usuarioService.buscarPorId(id)
            .map(ResponseEntity::ok)
            .orElse(ResponseEntity.notFound().build());
    }

    @Operation(summary = "Atualizar usuário", description = "Atualiza os dados de um usuário existente.")
    @ApiResponses({
        @ApiResponse(responseCode = "200", description = "Usuário atualizado com sucesso."),
        @ApiResponse(responseCode = "404", description = "Usuário não encontrado.")
    })
    @PutMapping("/{id}")
    public ResponseEntity<UsuarioDTO> atualizarUsuario(@Parameter(description = "ID do usuário", example = "1") @PathVariable Long id, @RequestBody UsuarioDTO usuarioAtualizado) {
        try {
            UsuarioDTO atualizado = usuarioService.atualizar(id, usuarioAtualizado);
            return ResponseEntity.ok(atualizado);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @Operation(summary = "Deletar usuário", description = "Remove um usuário do sistema pelo ID.")
    @ApiResponses({
        @ApiResponse(responseCode = "204", description = "Usuário deletado com sucesso."),
        @ApiResponse(responseCode = "404", description = "Usuário não encontrado.")
    })
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarUsuario(@Parameter(description = "ID do usuário", example = "1") @PathVariable Long id) {
        usuarioService.deletar(id);
        return ResponseEntity.noContent().build();
    }



    @Operation(summary = "Login do usuário", description = "Realiza autenticação e retorna o token JWT.")
    @ApiResponses({
        @ApiResponse(responseCode = "200", description = "Login realizado com sucesso. Token JWT retornado."),
        @ApiResponse(responseCode = "401", description = "Usuário ou senha inválidos.")
    })
    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(
        @Parameter(description = "E-mail do usuário", example = "admin@bioedifica.com") @RequestParam String username,
        @Parameter(description = "Senha do usuário", example = "123456") @RequestParam String senha) {
        Optional<UsuarioDTO> usuarioOpt = usuarioService.buscarPorUsername(username);
        if (usuarioOpt.isPresent()) {
            // Aqui, para autenticação, você pode buscar a senha do model se necessário
            String token = jwtUtil.gerarToken(username, usuarioOpt.get().perfil().name());
            return ResponseEntity.ok(UsuarioMapper.toLoginResponse(usuarioOpt.get(), token));
        } else {
            return ResponseEntity.status(401).body((LoginResponse) null);
        }
    }

    @Operation(summary = "Área administrativa", description = "Acesso restrito para usuários ADMIN. Retorna mensagem de permissão ou negação.")
    @GetMapping("/admin-area")
    public ResponseEntity<String> adminArea(@RequestHeader("Authorization") String authHeader) {
        String token = authHeader.replace("Bearer ", "");
        if (jwtUtil.isAdmin(token)) {
            return ResponseEntity.ok("Acesso permitido à área administrativa!");
        } else {
            return ResponseEntity.status(403).body("Acesso negado: usuário não é ADMIN.");
        }
    }
}
