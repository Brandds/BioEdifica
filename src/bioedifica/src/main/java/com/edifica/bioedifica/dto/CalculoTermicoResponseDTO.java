package com.edifica.bioedifica.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * DTO de resposta com resultados dos cálculos térmicos
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CalculoTermicoResponseDTO {
    
    // Valores calculados segundo NBR 15220-2
    private Double transmitanciaTermica; // U [W/(m².K)]
    
    private Double capacidadeTermica; // CT [kJ/(m².K)]
    
    private Double atrasoTermico; // φ [horas]
    
    private Double resistenciaTermicaTotal; // RT [m².K/W]
    
    // Detalhes dos materiais utilizados no cálculo
    private List<MaterialDetalhadoDTO> materiaisDetalhados;


    public void setMateriaisDetalhados(List<MaterialDetalhadoDTO> materiaisDetalhados) {
        this.materiaisDetalhados = materiaisDetalhados;
    }
    
    public List<MaterialDetalhadoDTO> getMateriaisDetalhados() {
        return materiaisDetalhados;
    }

    public Double getTransmitanciaTermica() {
        return transmitanciaTermica;
    }
    public void setTransmitanciaTermica(Double transmitanciaTermica) {
        this.transmitanciaTermica = transmitanciaTermica;
    }

    public Double getCapacidadeTermica() {
        return capacidadeTermica;
    }
    public void setCapacidadeTermica(Double capacidadeTermica) {
        this.capacidadeTermica = capacidadeTermica;
    }

    public Double getResistenciaTermicaTotal() {
        return resistenciaTermicaTotal;
    }
    public void setResistenciaTermicaTotal(Double resistenciaTermicaTotal) {
        this.resistenciaTermicaTotal = resistenciaTermicaTotal;
    }

    public Double getAtrasoTermico() {
        return atrasoTermico;
    }
    public void setAtrasoTermico(Double atrasoTermico) {
        this.atrasoTermico = atrasoTermico;
    }
}
