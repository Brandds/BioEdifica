package com.edifica.bioedifica.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AdicionarMaterialSimplificadoDTO {
    private Long idMaterialExterno;
    private Double espessura;
}