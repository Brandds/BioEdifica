package com.edifica.bioedifica.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.edifica.bioedifica.dto.cidade.EstadoDTO;
import com.edifica.bioedifica.service.IEstadoService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/api/estados")
@CrossOrigin(origins = "*")
@Tag(name = "Estado", description = "API para gerenciamento de estados brasileiros")
public class EstadoController {
    
    @Autowired
    private IEstadoService estadoService;

    @PostMapping
    @Operation(summary = "Criar novo estado", description = "Cria um novo estado no sistema")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "201", description = "Estado criado com sucesso"),
        @ApiResponse(responseCode = "400", description = "Dados inválidos")
    })
    public ResponseEntity<EstadoDTO> criarEstado(
            @RequestBody @Parameter(description = "Dados do estado a ser criado") EstadoDTO estadoDTO) {
        var estadoCriado = estadoService.salvar(estadoDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(estadoCriado);
    }

    @GetMapping
    @Operation(summary = "Listar todos os estados", description = "Retorna todos os estados cadastrados")
    @ApiResponse(responseCode = "200", description = "Lista de estados retornada com sucesso")
    public ResponseEntity<List<EstadoDTO>> listarTodos() {
        var estados = estadoService.listarTodos();
        return ResponseEntity.ok(estados);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Buscar estado por ID", description = "Retorna um estado específico pelo ID")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Estado encontrado"),
        @ApiResponse(responseCode = "404", description = "Estado não encontrado")
    })
    public ResponseEntity<EstadoDTO> buscarPorId(
            @PathVariable @Parameter(description = "ID do estado") Long id) {
        return estadoService.buscarPorId(id)
                .map(estado -> ResponseEntity.ok(estado))
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/uf/{uf}")
    @Operation(summary = "Buscar estado por UF", description = "Retorna um estado específico pela sigla UF")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Estado encontrado"),
        @ApiResponse(responseCode = "404", description = "Estado não encontrado")
    })
    public ResponseEntity<EstadoDTO> buscarPorUf(
            @PathVariable @Parameter(description = "Sigla UF do estado") String uf) {
        return estadoService.buscarPorUf(uf)
                .map(estado -> ResponseEntity.ok(estado))
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/buscar")
    @Operation(summary = "Buscar estados por nome", description = "Retorna estados que contenham o nome informado")
    @ApiResponse(responseCode = "200", description = "Lista de estados retornada com sucesso")
    public ResponseEntity<List<EstadoDTO>> buscarPorNome(
            @RequestParam @Parameter(description = "Nome ou parte do nome do estado") String nome) {
        var estados = estadoService.buscarPorNome(nome);
        return ResponseEntity.ok(estados);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Atualizar estado", description = "Atualiza os dados de um estado existente")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Estado atualizado com sucesso"),
        @ApiResponse(responseCode = "404", description = "Estado não encontrado"),
        @ApiResponse(responseCode = "400", description = "Dados inválidos")
    })
    public ResponseEntity<EstadoDTO> atualizarEstado(
            @PathVariable @Parameter(description = "ID do estado") Long id,
            @RequestBody @Parameter(description = "Novos dados do estado") EstadoDTO estadoDTO) {
        var estadoAtualizado = estadoService.atualizar(id, estadoDTO);
        return ResponseEntity.ok(estadoAtualizado);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Deletar estado", description = "Remove um estado do sistema")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "204", description = "Estado deletado com sucesso"),
        @ApiResponse(responseCode = "404", description = "Estado não encontrado")
    })
    public ResponseEntity<Void> deletarEstado(
            @PathVariable @Parameter(description = "ID do estado") Long id) {
        estadoService.deletar(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/existe-uf/{uf}")
    @Operation(summary = "Verificar se UF existe", description = "Verifica se já existe um estado com a UF informada")
    @ApiResponse(responseCode = "200", description = "Resultado da verificação retornado")
    public ResponseEntity<Boolean> existePorUf(
            @PathVariable @Parameter(description = "Sigla UF para verificar") String uf) {
        boolean existe = estadoService.existePorUf(uf);
        return ResponseEntity.ok(existe);
    }
}