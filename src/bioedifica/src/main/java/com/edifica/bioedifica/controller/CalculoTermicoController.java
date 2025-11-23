package com.edifica.bioedifica.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.edifica.bioedifica.dto.CalculoTermicoRequestDTO;
import com.edifica.bioedifica.dto.CalculoTermicoResponseDTO;
import com.edifica.bioedifica.service.ICalculoTermicoService;

import lombok.RequiredArgsConstructor;

/**
 * Controller responsável pelos cálculos térmicos
 * Recebe lista de materiais do mock e retorna valores calculados
 */
@RestController
@RequestMapping("/api/calculo-termico")
@RequiredArgsConstructor
public class CalculoTermicoController {

    private final ICalculoTermicoService calculoTermicoService;

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
}
