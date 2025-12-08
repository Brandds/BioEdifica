package com.edifica.bioedifica.model;

import jakarta.persistence.Embeddable;

@Embeddable
public class CalculoTermico {
    
    // Transmitância Térmica [W/(m².K)]
    private Double transmitanciaTermica;
    
    // Capacidade Térmica [kJ/(m².K)]
    private Double capacidadeTermica;
    
    // Atraso Térmico [horas]
    private Double atrasoTermico;

    public CalculoTermico() {}

    public CalculoTermico(Double transmitanciaTermica, Double capacidadeTermica, Double atrasoTermico) {
        this.transmitanciaTermica = transmitanciaTermica;
        this.capacidadeTermica = capacidadeTermica;
        this.atrasoTermico = atrasoTermico;
    }

    public Double getTransmitanciaTermica() { return transmitanciaTermica; }
    public void setTransmitanciaTermica(Double transmitanciaTermica) { this.transmitanciaTermica = transmitanciaTermica; }

    public Double getCapacidadeTermica() { return capacidadeTermica; }
    public void setCapacidadeTermica(Double capacidadeTermica) { this.capacidadeTermica = capacidadeTermica; }

    public Double getAtrasoTermico() { return atrasoTermico; }
    public void setAtrasoTermico(Double atrasoTermico) { this.atrasoTermico = atrasoTermico; }
}
