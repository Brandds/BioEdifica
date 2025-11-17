package com.edifica.bioedifica.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResumoCalculosTermicosDTO {
    private Long projetoId;
    private String nomeProjeto;
    private List<MaterialProjetoDTO> materiais;
    private CalculoTermicoDTO resistenciaTermicaTotal;
    private CalculoTermicoDTO atrasoTermico;
    private CalculoTermicoDTO capacidadeTermica;
    private CalculoTermicoDTO transmitanciaTermica;
}