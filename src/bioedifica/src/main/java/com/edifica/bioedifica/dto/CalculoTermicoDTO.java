package com.edifica.bioedifica.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CalculoTermicoDTO {
    private Long projetoId;
    private Double valor;
    private String unidade;
    private String descricao;
    private String tipoCalculo;
}