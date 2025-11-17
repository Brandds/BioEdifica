package com.edifica.bioedifica.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.edifica.bioedifica.dto.projeto.ProjetoDTO;
import com.edifica.bioedifica.dto.projeto.ProjetoDetalhadoDTO;
import com.edifica.bioedifica.service.serviceImpl.ProjetoService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;



@RestController
@RequestMapping("/api/projeto")
public class ProjetoController {
  
  public ProjetoController(ProjetoService projetoService) {
    this.projetoService = projetoService;
  }

  private ProjetoService projetoService;

  @Operation(summary = "Obter projeto pelo ID", description = "Retorna um projeto específico com base no ID fornecido.")
  @ApiResponses({
      @ApiResponse(responseCode = "200", description = "Projeto retornado com sucesso."),
      @ApiResponse(responseCode = "404", description = "Projeto não encontrado.")
  })
  @GetMapping("/{id}")
  public ProjetoDetalhadoDTO getProjetoById(@PathVariable Long id) {
    return projetoService.getProjetoById(id);
  }

  @Operation(summary = "Obter projetos ativos do usuário", description = "Retorna todos os projetos ativos associados a um usuário específico.")
  @GetMapping("/getProjetoByUsuario/{idUsuario}")
  public List<ProjetoDTO> getProjetoByUsuario(@PathVariable Long idUsuario) {
    return  projetoService.getProjetoByUsuario(idUsuario);
  }

  @Operation(summary = "Criar projeto", description = "Cria um novo projeto no sistema.")
  @ApiResponses({
      @ApiResponse(responseCode = "201", description = "Projeto criado com sucesso."),
      @ApiResponse(responseCode = "400", description = "Dados inválidos.")
  })
  @PostMapping()
  public ResponseEntity<ProjetoDetalhadoDTO> criarProjeto(@RequestBody ProjetoDTO projetoDTO) {
    var projetoDetalhado = projetoService.criarProjeto(projetoDTO);
    return ResponseEntity.status(201).body(projetoDetalhado);
  }

  @Operation(summary = "Atualizar projeto", description = "Atualiza somente os detalhes de um projeto existente.(não atualiza os materiais associados)")
  @PutMapping("/atualizarProjeto/{idUsuario}")
  public ResponseEntity<ProjetoDetalhadoDTO> atualizarProjeto(@PathVariable Long idUsuario, @RequestBody ProjetoDetalhadoDTO projetoDTO) {
    var projetoAtualizado = projetoService.atualizarProjeto(projetoDTO, idUsuario);
    return ResponseEntity.ok(projetoAtualizado);
  }


  @Operation(summary = "Deletar projeto", description = "Deleta um projeto existente (torna o projeto inativo).")
  @PutMapping("/deletarProjeto/{idProjeto}/{idUsuario}")
  public ResponseEntity<Void> deletarProjeto(@PathVariable Long idProjeto, @PathVariable Long idUsuario) {
    projetoService.deletarProjeto(idProjeto, idUsuario);
    return ResponseEntity.noContent().build();
  }

}
