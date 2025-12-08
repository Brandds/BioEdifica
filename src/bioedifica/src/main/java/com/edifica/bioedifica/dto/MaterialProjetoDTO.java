package com.edifica.bioedifica.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class MaterialProjetoDTO {

    public MaterialProjetoDTO(Long id1, Long idMaterialExterno1, String nomeMaterial1, String tipoAplicacao1, Double densidade1, Double calorEspecifico1, Double condutividadeTermica1, Double espessura1) {
    }
    private Long id;
    private Long idMaterialExterno;
    private String nomeMaterial;
    private String tipoAplicacao;
    private Double densidade;
    private Double calorEspecifico;
    private Double condutividadeTermica;
    private Double espessura;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getIdMaterialExterno() {
        return idMaterialExterno;
    }

    public void setIdMaterialExterno(Long idMaterialExterno) {
        this.idMaterialExterno = idMaterialExterno;
    }

    public String getNomeMaterial() {
        return nomeMaterial;
    }

    public void setNomeMaterial(String nomeMaterial) {
        this.nomeMaterial = nomeMaterial;
    }

    public String getTipoAplicacao() {
        return tipoAplicacao;
    }

    public void setTipoAplicacao(String tipoAplicacao) {
        this.tipoAplicacao = tipoAplicacao;
    }

    public Double getDensidade() {
        return densidade;
    }

    public void setDensidade(Double densidade) {
        this.densidade = densidade;
    }

    public Double getCalorEspecifico() {
        return calorEspecifico;
    }

    public void setCalorEspecifico(Double calorEspecifico) {
        this.calorEspecifico = calorEspecifico;
    }

    public Double getCondutividadeTermica() {
        return condutividadeTermica;
    }

    public void setCondutividadeTermica(Double condutividadeTermica) {
        this.condutividadeTermica = condutividadeTermica;
    }

    public Double getEspessura() {
        return espessura;
    }

    public void setEspessura(Double espessura) {
        this.espessura = espessura;
    }


}