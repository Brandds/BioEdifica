package com.edifica.bioedifica.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AdicionarMaterialSimplificadoDTO {
    private String tipoCamada; // PAREDE, COBERTURA, PISO
    private List<MaterialCalculoDTO> materiais;
    private Long projetoId;
}