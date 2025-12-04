package com.edifica.bioedifica.controller;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
import com.edifica.bioedifica.mapper.UsuarioMapper;
import com.edifica.bioedifica.service.IUsuarioService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {
    private static final Logger logger = LoggerFactory.getLogger(UsuarioController.class);
    
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
    @PostMapping("/criaUsuario")
    public ResponseEntity<UsuarioDTO> criarUsuario(@RequestBody UsuarioCadastroDTO usuarioDTO) {
        try {
            logger.info("========== INÍCIO CRIAÇÃO DE USUÁRIO ==========");
            logger.info("Endpoint acessado: POST /api/usuarios/criaUsuario");
            logger.info("Dados recebidos: email={}, nome={}", 
                usuarioDTO != null ? usuarioDTO.email() : "null", 
                usuarioDTO != null ? usuarioDTO.nome() : "null");
            
            if (usuarioDTO == null) {
                logger.error("ERRO: UsuarioCadastroDTO é null");
                return ResponseEntity.badRequest().build();
            }
            
            UsuarioDTO salvo = usuarioService.salvar(usuarioDTO);
            logger.info("Usuário criado com sucesso: id={}, email={}", salvo.id(), salvo.email());
            logger.info("========== FIM CRIAÇÃO DE USUÁRIO ==========");
            return ResponseEntity.ok(salvo);
            
        } catch (Exception e) {
            logger.error("========== ERRO NA CRIAÇÃO DE USUÁRIO ==========");
            logger.error("Tipo de erro: {}", e.getClass().getName());
            logger.error("Mensagem: {}", e.getMessage());
            logger.error("Stack trace completo:", e);
            throw e;
        }
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
        if (usuarioOpt.isPresent() && usuarioOpt.get().senha().equals(senha)) {
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
