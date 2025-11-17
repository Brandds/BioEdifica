package com.edifica.bioedifica.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MaterialProjetoDTO {
    private Long id;
    private Long idMaterialExterno;
    private String nomeMaterial;
    private String tipoAplicacao;
    private Double densidade;
    private Double calorEspecifico;
    private Double condutividadeTermica;
    private Double espessura;
}