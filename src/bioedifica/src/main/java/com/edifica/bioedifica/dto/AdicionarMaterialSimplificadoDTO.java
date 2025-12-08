package com.edifica.bioedifica.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AdicionarMaterialSimplificadoDTO {
    private String nomeCamada; // Nome da camada a ser criada
    private String tipoCamada; // PAREDE, COBERTURA, PISO
    private List<MaterialCalculoDTO> materiais;
    private Long projetoId;

    public String getNomeCamada() {
        return nomeCamada;
    }

    public void setNomeCamada(String nomeCamada) {
        this.nomeCamada = nomeCamada;
    }

    public String getTipoCamada() {
        return tipoCamada;
    }

    public void setTipoCamada(String tipoCamada) {
        this.tipoCamada = tipoCamada;
    }

    public List<MaterialCalculoDTO> getMateriais() {
        return materiais;
    }

    public void setMateriais(List<MaterialCalculoDTO> materiais) {
        this.materiais = materiais;
    }

    public Long getProjetoId() {
        return projetoId;
    }

    public void setProjetoId(Long projetoId) {
        this.projetoId = projetoId;
    }
}