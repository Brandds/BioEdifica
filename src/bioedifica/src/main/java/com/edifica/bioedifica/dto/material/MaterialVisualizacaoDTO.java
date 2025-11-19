package com.edifica.bioedifica.dto.material;

public record MaterialVisualizacaoDTO(
    Long id,
    String materialName,
    String materialType,
    String dataSourceUrl,
    Double density,
    String materialTypeFamily,
    Long idMaterialExterno
) {}
