package com.edifica.bioedifica.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * DTO de resposta para cálculo de carbono incorporado
 * Retorna o carbono total do projeto em kgCO₂eq/m²
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CarbonoIncorporadoResponseDTO {
    
    /**
     * Carbono incorporado total por área [kgCO₂eq/m²]
     */
    private Double carbonoTotalPorArea;
    
    /**
     * Carbono incorporado total absoluto [kgCO₂eq]
     */
    private Double carbonoTotalAbsoluto;
    
    /**
     * Área total do projeto [m²]
     */
    private Double areaTotalProjeto;
    
    /**
     * Nome do projeto
     */
    private String nomeProjeto;
    
    /**
     * Quantidade de materiais considerados no cálculo
     */
    private Integer quantidadeMateriais;
    
    /**
     * Detalhamento do carbono por material
     */
    private List<CarbonoMaterialDTO> materiaisDetalhados;
}
