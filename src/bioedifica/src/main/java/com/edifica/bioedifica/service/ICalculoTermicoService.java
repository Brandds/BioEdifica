package com.edifica.bioedifica.service;

import com.edifica.bioedifica.dto.CalculoTermicoRequestDTO;
import com.edifica.bioedifica.dto.CalculoTermicoResponseDTO;

public interface ICalculoTermicoService {
    
    /**
     * Calcula propriedades térmicas com base em lista de materiais do mock
     * @param request Lista de materiais com IDs do mock, espessuras e ordem
     * @return Valores calculados de U, CT, RT e φ segundo NBR 15220-2
     */
    CalculoTermicoResponseDTO calcularPropriedadesTermicas(CalculoTermicoRequestDTO request);
}
