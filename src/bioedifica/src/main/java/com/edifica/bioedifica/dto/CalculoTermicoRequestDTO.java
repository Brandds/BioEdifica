package com.edifica.bioedifica.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

/**
 * DTO de requisição para cálculo térmico
 */
@NoArgsConstructor
@AllArgsConstructor
public class CalculoTermicoRequestDTO {
    
    private String tipoCamada; // PAREDE, COBERTURA, PISO
    
    private List<MaterialCalculoDTO> materiais;


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
}
