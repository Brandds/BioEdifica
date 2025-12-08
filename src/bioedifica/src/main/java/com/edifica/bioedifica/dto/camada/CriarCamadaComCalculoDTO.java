package com.edifica.bioedifica.dto.camada;

import java.util.List;

import com.edifica.bioedifica.model.TipoCamada;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * DTO para criação de camada com cálculo térmico
 * Usado quando o usuário monta uma camada no frontend e envia para calcular/salvar
 */
public record CriarCamadaComCalculoDTO(
    @JsonProperty("nome") String nome,
    @JsonProperty("tipoCamada") TipoCamada tipoCamada,
    @JsonProperty("projetoId") Long projetoId,
    @JsonProperty("materiais") List<MaterialCamadaDTO> materiais
) {
    /**
     * DTO interno representando cada material na camada
     */
    public record MaterialCamadaDTO(
        @JsonProperty("idMaterialMock") Long idMaterialMock,
        @JsonProperty("espessura") Double espessura,
        @JsonProperty("ordem") Integer ordem
    ) {}
}
