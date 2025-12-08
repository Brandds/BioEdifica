package com.edifica.bioedifica.dto;

import lombok.Data;

/**
 * DTO para receber dados de material do mock para cálculo térmico
 */
@Data
public class MaterialCalculoDTO {
    
    private Long idMaterialMock; // ID do material no mock_generic_materials.json
    
    private Double espessura; // metros
    
    private Integer ordem; // ordem do material na camada (1, 2, 3...)

    public MaterialCalculoDTO(Long idMaterialMock, Double espessura, Integer ordem) {
        this.idMaterialMock = idMaterialMock;
        this.espessura = espessura;
        this.ordem = ordem;
    }

    public MaterialCalculoDTO() {}


    public Long getIdMaterialMock() {
        return idMaterialMock;
    }

    public void setIdMaterialMock(Long idMaterialMock) {
        this.idMaterialMock = idMaterialMock;
    }
    public Double getEspessura() {
        return espessura;
    }
    public void setEspessura(Double espessura) {
        this.espessura = espessura;
    }
    public Integer getOrdem() {
        return ordem;
    }
    public void setOrdem(Integer ordem) {
        this.ordem = ordem;
    }
}
