package com.edifica.bioedifica.dto.camada;

import java.util.List;

import com.edifica.bioedifica.model.CalculoTermico;
import com.edifica.bioedifica.model.TipoCamada;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * DTO de resposta com os dados da camada e seus materiais
 */
public record CamadaResponseDTO(
    @JsonProperty("id") Long id,
    @JsonProperty("nome") String nome,
    @JsonProperty("tipoCamada") TipoCamada tipoCamada,
    @JsonProperty("projetoId") Long projetoId,
    @JsonProperty("materiais") List<MaterialCamadaResponseDTO> materiais,
    @JsonProperty("calculoTermico") CalculoTermico calculoTermico
) {
    /**
     * DTO com informações de cada material na camada
     */
    public record MaterialCamadaResponseDTO(
        @JsonProperty("id") Long id,
        @JsonProperty("idMaterialExterno") Long idMaterialExterno,
        @JsonProperty("nomeMaterial") String nomeMaterial,
        @JsonProperty("espessura") Double espessura,
        @JsonProperty("ordem") Integer ordem,
        @JsonProperty("densidade") Double densidade,
        @JsonProperty("calorEspecifico") Double calorEspecifico,
        @JsonProperty("condutividadeTermica") Double condutividadeTermica
    ) {}
}
