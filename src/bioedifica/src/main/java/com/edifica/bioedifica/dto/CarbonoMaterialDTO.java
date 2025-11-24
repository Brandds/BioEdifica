package com.edifica.bioedifica.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * DTO com detalhamento do carbono de cada material
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CarbonoMaterialDTO {
    
    /**
     * ID do material no mock
     */
    private Long idMaterialMock;
    
    /**
     * Nome do material
     */
    private String nomeMaterial;
    
    /**
     * Tipo do material
     */
    private String tipoMaterial;
    
    /**
     * Espessura do material [m]
     */
    private Double espessura;
    
    /**
     * Densidade do material [kg/m³]
     */
    private Double densidade;
    
    /**
     * Massa do material por unidade funcional [kg]
     */
    private Double massaPorUnidade;
    
    /**
     * CO₂ total por kg de material [kgCO₂eq/kg]
     * Campo: total_co2e_kg_mf do mock
     */
    private Double co2PorKg;
    
    /**
     * Carbono A1-A3 (produção) [kgCO₂eq/kg]
     * Campo: carbon_a1a3 do mock
     */
    private Double carbonoA1A3;
    
    /**
     * Carbono C1-C4 (fim de vida) [kgCO₂eq/kg]
     * Campo: carbon_c1c4 do mock
     */
    private Double carbonoC1C4;
    
    /**
     * Carbono biogênico [kgCO₂eq/kg]
     * Campo: total_biogenic_co2e do mock (pode ser negativo)
     */
    private Double carbonoBiogenico;
    
    /**
     * Carbono total do material [kgCO₂eq]
     * Calculado como: massaPorUnidade × co2PorKg
     */
    private Double carbonoTotalMaterial;
}
