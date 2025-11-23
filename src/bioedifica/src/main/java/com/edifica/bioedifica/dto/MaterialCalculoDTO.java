package com.edifica.bioedifica.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * DTO para receber dados de material do mock para cálculo térmico
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MaterialCalculoDTO {
    
    private Long idMaterialMock; // ID do material no mock_generic_materials.json
    
    private Double espessura; // metros
    
    private Integer ordem; // ordem do material na camada (1, 2, 3...)
}
