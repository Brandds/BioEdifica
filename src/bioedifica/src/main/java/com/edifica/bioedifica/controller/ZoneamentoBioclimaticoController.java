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

import com.edifica.bioedifica.dto.cidade.ZoneamentoBioclimaticoDTO;
import com.edifica.bioedifica.service.IZoneamentoBioclimaticoService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/api/zoneamento-bioclimatico")
@CrossOrigin(origins = "*")
@Tag(name = "Zoneamento Bioclimático", description = "API para gerenciamento de dados de zoneamento bioclimático brasileiro")
public class ZoneamentoBioclimaticoController {
    
    @Autowired
    private IZoneamentoBioclimaticoService zoneamentoBioclimaticoService;

    @PostMapping
    @Operation(summary = "Criar novo zoneamento", description = "Cria um novo registro de zoneamento bioclimático")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "201", description = "Zoneamento criado com sucesso"),
        @ApiResponse(responseCode = "400", description = "Dados inválidos")
    })
    public ResponseEntity<ZoneamentoBioclimaticoDTO> criarZoneamento(
            @RequestBody @Parameter(description = "Dados do zoneamento a ser criado") ZoneamentoBioclimaticoDTO zoneamentoDTO) {
        var zoneamentoCriado = zoneamentoBioclimaticoService.salvar(zoneamentoDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(zoneamentoCriado);
    }

    @GetMapping
    @Operation(summary = "Listar todos os zoneamentos", description = "Retorna todos os zoneamentos bioclimáticos cadastrados")
    @ApiResponse(responseCode = "200", description = "Lista de zoneamentos retornada com sucesso")
    public ResponseEntity<List<ZoneamentoBioclimaticoDTO>> listarTodos() {
        var zoneamentos = zoneamentoBioclimaticoService.listarTodos();
        return ResponseEntity.ok(zoneamentos);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Buscar zoneamento por ID", description = "Retorna um zoneamento específico pelo ID")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Zoneamento encontrado"),
        @ApiResponse(responseCode = "404", description = "Zoneamento não encontrado")
    })
    public ResponseEntity<ZoneamentoBioclimaticoDTO> buscarPorId(
            @PathVariable @Parameter(description = "ID do zoneamento") Long id) {
        return zoneamentoBioclimaticoService.buscarPorId(id)
                .map(zoneamento -> ResponseEntity.ok(zoneamento))
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/uf/{uf}")
    @Operation(summary = "Buscar zoneamentos por UF", description = "Retorna todos os zoneamentos de um estado específico")
    @ApiResponse(responseCode = "200", description = "Lista de zoneamentos retornada com sucesso")
    public ResponseEntity<List<ZoneamentoBioclimaticoDTO>> buscarPorUf(
            @PathVariable @Parameter(description = "Sigla UF do estado") String uf) {
        var zoneamentos = zoneamentoBioclimaticoService.buscarPorUf(uf);
        return ResponseEntity.ok(zoneamentos);
    }

    @GetMapping("/cidade")
    @Operation(summary = "Buscar zoneamento por cidade", description = "Retorna o zoneamento de uma cidade específica")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Zoneamento encontrado"),
        @ApiResponse(responseCode = "404", description = "Zoneamento não encontrado")
    })
    public ResponseEntity<ZoneamentoBioclimaticoDTO> buscarPorCidade(
            @RequestParam @Parameter(description = "Nome da cidade") String cidade,
            @RequestParam @Parameter(description = "Sigla UF do estado") String uf) {
        return zoneamentoBioclimaticoService.buscarPorNomeCidadeEUf(cidade, uf)
                .map(zoneamento -> ResponseEntity.ok(zoneamento))
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/zona/{zona}")
    @Operation(summary = "Buscar por zona bioclimática", description = "Retorna todos os zoneamentos de uma zona bioclimática específica")
    @ApiResponse(responseCode = "200", description = "Lista de zoneamentos retornada com sucesso")
    public ResponseEntity<List<ZoneamentoBioclimaticoDTO>> buscarPorZonaBioclimatica(
            @PathVariable @Parameter(description = "Zona bioclimática (ex: 3B, 4A)") String zona) {
        var zoneamentos = zoneamentoBioclimaticoService.buscarPorZonaBioclimatica(zona);
        return ResponseEntity.ok(zoneamentos);
    }

    @GetMapping("/buscar-cidade")
    @Operation(summary = "Buscar por nome da cidade", description = "Retorna zoneamentos de cidades que contenham o nome informado")
    @ApiResponse(responseCode = "200", description = "Lista de zoneamentos retornada com sucesso")
    public ResponseEntity<List<ZoneamentoBioclimaticoDTO>> buscarPorNomeCidade(
            @RequestParam @Parameter(description = "Nome ou parte do nome da cidade") String nome) {
        var zoneamentos = zoneamentoBioclimaticoService.buscarPorNomeCidade(nome);
        return ResponseEntity.ok(zoneamentos);
    }

    @GetMapping("/cidade-id/{cidadeId}")
    @Operation(summary = "Buscar zoneamento por ID da cidade", description = "Retorna o zoneamento de uma cidade pelo seu ID")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Zoneamento encontrado"),
        @ApiResponse(responseCode = "404", description = "Zoneamento não encontrado")
    })
    public ResponseEntity<ZoneamentoBioclimaticoDTO> buscarPorCidadeId(
            @PathVariable @Parameter(description = "ID da cidade") Long cidadeId) {
        return zoneamentoBioclimaticoService.buscarPorCidadeId(cidadeId)
                .map(zoneamento -> ResponseEntity.ok(zoneamento))
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    @Operation(summary = "Atualizar zoneamento", description = "Atualiza os dados de um zoneamento existente")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Zoneamento atualizado com sucesso"),
        @ApiResponse(responseCode = "404", description = "Zoneamento não encontrado"),
        @ApiResponse(responseCode = "400", description = "Dados inválidos")
    })
    public ResponseEntity<ZoneamentoBioclimaticoDTO> atualizarZoneamento(
            @PathVariable @Parameter(description = "ID do zoneamento") Long id,
            @RequestBody @Parameter(description = "Novos dados do zoneamento") ZoneamentoBioclimaticoDTO zoneamentoDTO) {
        var zoneamentoAtualizado = zoneamentoBioclimaticoService.atualizar(id, zoneamentoDTO);
        return ResponseEntity.ok(zoneamentoAtualizado);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Deletar zoneamento", description = "Remove um zoneamento do sistema")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "204", description = "Zoneamento deletado com sucesso"),
        @ApiResponse(responseCode = "404", description = "Zoneamento não encontrado")
    })
    public ResponseEntity<Void> deletarZoneamento(
            @PathVariable @Parameter(description = "ID do zoneamento") Long id) {
        zoneamentoBioclimaticoService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}