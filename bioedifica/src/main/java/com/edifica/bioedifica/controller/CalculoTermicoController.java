package com.edifica.bioedifica.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.edifica.bioedifica.dto.CalculoTermicoDTO;
import com.edifica.bioedifica.dto.ResumoCalculosTermicosDTO;
import com.edifica.bioedifica.service.serviceImpl.CalculoTermicoService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/calculos-termicos")
@RequiredArgsConstructor
@Tag(name = "Cálculos Térmicos", description = "Endpoints para cálculos de propriedades térmicas dos materiais de projetos")
@CrossOrigin(origins = "*")
public class CalculoTermicoController {

    private final CalculoTermicoService calculoTermicoService;

    @Operation(
        summary = "Calcular Resistência Térmica Total", 
        description = "Calcula a resistência térmica total (R) em m²K/W para todos os materiais de um projeto"
    )
    @GetMapping("/resistencia-termica/{projetoId}")
    public ResponseEntity<CalculoTermicoDTO> calcularResistenciaTermica(
            @Parameter(description = "ID do projeto", required = true)
            @PathVariable Long projetoId) {
        try {
            CalculoTermicoDTO resultado = calculoTermicoService.calcularResistenciaTermicaTotal(projetoId);
            return ResponseEntity.ok(resultado);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @Operation(
        summary = "Calcular Atraso Térmico", 
        description = "Calcula o atraso térmico φ em horas para todos os materiais de um projeto"
    )
    @GetMapping("/atraso-termico/{projetoId}")
    public ResponseEntity<CalculoTermicoDTO> calcularAtrasoTermico(
            @Parameter(description = "ID do projeto", required = true)
            @PathVariable Long projetoId) {
        try {
            CalculoTermicoDTO resultado = calculoTermicoService.calcularAtrasoTermico(projetoId);
            return ResponseEntity.ok(resultado);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @Operation(
        summary = "Calcular Capacidade Térmica", 
        description = "Calcula a capacidade térmica em kJ/m²K para todos os materiais de um projeto"
    )
    @GetMapping("/capacidade-termica/{projetoId}")
    public ResponseEntity<CalculoTermicoDTO> calcularCapacidadeTermica(
            @Parameter(description = "ID do projeto", required = true)
            @PathVariable Long projetoId) {
        try {
            CalculoTermicoDTO resultado = calculoTermicoService.calcularCapacidadeTermica(projetoId);
            return ResponseEntity.ok(resultado);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @Operation(
        summary = "Calcular Transmitância Térmica", 
        description = "Calcula a transmitância térmica (U) em W/m²K para todos os materiais de um projeto"
    )
    @GetMapping("/transmitancia-termica/{projetoId}")
    public ResponseEntity<CalculoTermicoDTO> calcularTransmitanciaTermica(
            @Parameter(description = "ID do projeto", required = true)
            @PathVariable Long projetoId) {
        try {
            CalculoTermicoDTO resultado = calculoTermicoService.calcularTransmitanciaTermica(projetoId);
            return ResponseEntity.ok(resultado);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @Operation(
        summary = "Resumo Completo dos Cálculos Térmicos", 
        description = "Retorna todos os cálculos térmicos de uma vez para um projeto, incluindo lista de materiais"
    )
    @GetMapping("/resumo-completo/{projetoId}")
    public ResponseEntity<ResumoCalculosTermicosDTO> calcularResumoCompleto(
            @Parameter(description = "ID do projeto", required = true)
            @PathVariable Long projetoId) {
        try {
            ResumoCalculosTermicosDTO resultado = calculoTermicoService.calcularResumoCompleto(projetoId);
            return ResponseEntity.ok(resultado);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }
}