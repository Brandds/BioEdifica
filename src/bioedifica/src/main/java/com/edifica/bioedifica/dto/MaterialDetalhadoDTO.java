package com.edifica.bioedifica.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * DTO com detalhes do material buscado do mock
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MaterialDetalhadoDTO {
    
    private Long idMaterialMock;
    
    private String nomeMaterial;
    
    private Double espessura; // metros
    
    private Integer ordem;
    
    // Propriedades térmicas obtidas do mock
    private Double densidade; // kg/m³
    
    private Double calorEspecifico; // kJ/(kg.K)
    
    private Double condutividadeTermica; // W/(m.K)
}
