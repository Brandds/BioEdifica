package com.edifica.bioedifica.model;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Embeddable
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CalculoTermico {
    
    // Transmitância Térmica [W/(m².K)]
    private Double transmitanciaTermica;
    
    // Capacidade Térmica [kJ/(m².K)]
    private Double capacidadeTermica;
    
    // Atraso Térmico [horas]
    private Double atrasoTermico;
}
