package com.edifica.bioedifica.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.edifica.bioedifica.dto.camada.CamadaResponseDTO;
import com.edifica.bioedifica.dto.camada.CriarCamadaComCalculoDTO;
import com.edifica.bioedifica.service.ICamadaService;

/**
 * Controller para gerenciamento de Camadas
 * 
 * Endpoints:
 * - POST /api/camadas - Criar camada com cálculo térmico
 * - GET /api/camadas/projeto/{projetoId} - Listar camadas de um projeto
 * - GET /api/camadas/{camadaId} - Buscar camada por ID
 * - DELETE /api/camadas/{camadaId} - Excluir camada e seus materiais
 */
@RestController
@RequestMapping("/api/camadas")
public class CamadaController {

    private final ICamadaService camadaService;

    public CamadaController(ICamadaService camadaService) {
        this.camadaService = camadaService;
    }

    /**
     * Cria uma nova camada com cálculo térmico
     * 
     * Requisição exemplo:
     * {
     *   "nome": "Parede Externa Principal",
     *   "tipoCamada": "PAREDE",
     *   "projetoId": 1,
     *   "materiais": [
     *     {"idMaterialMock": 123, "espessura": 0.15, "ordem": 1},
     *     {"idMaterialMock": 2073, "espessura": 0.035, "ordem": 2},
     *     {"idMaterialMock": 456, "espessura": 0.02, "ordem": 3}
     *   ]
     * }
     * 
     * @param dto Dados da camada e materiais
     * @return Camada criada com cálculo térmico
     */
    @PostMapping
    public ResponseEntity<CamadaResponseDTO> criarCamadaComCalculo(
            @RequestBody CriarCamadaComCalculoDTO dto) {
        
        CamadaResponseDTO response = camadaService.criarCamadaComCalculo(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    /**
     * Lista todas as camadas de um projeto
     * 
     * Endpoint: GET /api/camadas/projeto/{projetoId}
     * 
     * @param projetoId ID do projeto
     * @return Lista de camadas com materiais e cálculos
     */
    @GetMapping("/projeto/{projetoId}")
    public ResponseEntity<List<CamadaResponseDTO>> listarCamadasPorProjeto(
            @PathVariable Long projetoId) {
        
        List<CamadaResponseDTO> camadas = camadaService.listarCamadasPorProjeto(projetoId);
        return ResponseEntity.ok(camadas);
    }

    /**
     * Busca uma camada específica por ID
     * 
     * Endpoint: GET /api/camadas/{camadaId}
     * 
     * @param camadaId ID da camada
     * @return Dados da camada
     */
    @GetMapping("/{camadaId}")
    public ResponseEntity<CamadaResponseDTO> buscarCamadaPorId(
            @PathVariable Long camadaId) {
        
        CamadaResponseDTO camada = camadaService.buscarCamadaPorId(camadaId);
        return ResponseEntity.ok(camada);
    }

    /**
     * Exclui uma camada e todos os materiais vinculados
     * 
     * Endpoint: DELETE /api/camadas/{camadaId}
     * 
     * Remove a camada, suas composições (cascade) e os MaterialProjeto associados
     * 
     * @param camadaId ID da camada a ser excluída
     * @return 204 No Content
     */
    @DeleteMapping("/{camadaId}")
    public ResponseEntity<Void> excluirCamada(@PathVariable Long camadaId) {
        camadaService.excluirCamada(camadaId);
        return ResponseEntity.noContent().build();
    }
}
