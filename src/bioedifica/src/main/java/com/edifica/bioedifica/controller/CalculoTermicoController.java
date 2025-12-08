package com.edifica.bioedifica.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.edifica.bioedifica.dto.CalculoTermicoRequestDTO;
import com.edifica.bioedifica.dto.CalculoTermicoResponseDTO;
import com.edifica.bioedifica.dto.CarbonoIncorporadoResponseDTO;
import com.edifica.bioedifica.service.ICalculoTermicoService;

import lombok.RequiredArgsConstructor;

/**
 * Controller responsável pelos cálculos térmicos e de carbono incorporado
 * Recebe lista de materiais do mock e retorna valores calculados
 */
@RestController
@RequestMapping("/api/calculo-termico")
@RequiredArgsConstructor
public class CalculoTermicoController {

    @Autowired
    private  ICalculoTermicoService calculoTermicoService;

    /**
     * Calcula propriedades térmicas com base em materiais do mock
     * 
     * Requisição exemplo:
     * {
     *   "tipoCamada": "PAREDE",
     *   "materiais": [
     *     {"idMaterialMock": 123, "espessura": 0.15, "ordem": 1},
     *     {"idMaterialMock": 456, "espessura": 0.02, "ordem": 2}
     *   ]
     * }
     * 
     * @param request Dados dos materiais (ID do mock, espessura, ordem)
     * @return Valores calculados: transmitância, capacidade térmica, atraso térmico, resistência
     */
    @PostMapping("/calcular")
    public ResponseEntity<CalculoTermicoResponseDTO> calcularPropriedadesTermicas(
            @RequestBody CalculoTermicoRequestDTO request) {
        
        CalculoTermicoResponseDTO response = calculoTermicoService.calcularPropriedadesTermicas(request);
        return ResponseEntity.ok(response);
    }
    
    /**
     * Calcula carbono incorporado total do projeto [kgCO₂eq/m²]
     * 
     * Endpoint: GET /api/calculo-termico/carbono/{projetoId}
     * 
     * Busca os materiais do projeto no banco usando MaterialProjeto.idMaterialExterno,
     * obtém valores de carbono do mock_generic_materials.json (campos: total_co2e_kg_mf, 
     * carbon_a1a3, carbon_c1c4, total_biogenic_co2e), calcula a massa de cada material
     * (densidade × espessura × área) e retorna o carbono total por área do projeto.
     * 
     * Fórmula:
     * - Massa por m² = densidade [kg/m³] × espessura [m]
     * - Carbono por material = massa_por_m² × área_total [m²] × total_co2e_kg_mf [kgCO₂eq/kg]
     * - Carbono total por área = Σ(carbono_materiais) / área_total [kgCO₂eq/m²]
     * 
     * @param projetoId ID do projeto para buscar área e materiais
     * @return DTO com carbono total por área [kgCO₂eq/m²] e detalhamento por material
     * @throws RuntimeException se o projeto não for encontrado ou não possuir área/materiais
     */
    @GetMapping("/carbono/{projetoId}")
    public ResponseEntity<CarbonoIncorporadoResponseDTO> calcularCarbonoIncorporado(
            @PathVariable Long projetoId) {
        
        CarbonoIncorporadoResponseDTO response = calculoTermicoService.calcularCarbonoIncorporado(projetoId);
        return ResponseEntity.ok(response);
    }
}
