package com.edifica.bioedifica.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * DTO de requisição para cálculo térmico
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CalculoTermicoRequestDTO {
    
    private String tipoCamada; // PAREDE, COBERTURA, PISO
    
    private List<MaterialCalculoDTO> materiais;
}
