package com.edifica.bioedifica.service;

import com.edifica.bioedifica.dto.CalculoTermicoRequestDTO;
import com.edifica.bioedifica.dto.CalculoTermicoResponseDTO;
import com.edifica.bioedifica.dto.CarbonoIncorporadoResponseDTO;

public interface ICalculoTermicoService {
    
    /**
     * Calcula propriedades térmicas com base em lista de materiais do mock
     * @param request Lista de materiais com IDs do mock, espessuras e ordem
     * @return Valores calculados de U, CT, RT e φ segundo NBR 15220-2
     */
    CalculoTermicoResponseDTO calcularPropriedadesTermicas(CalculoTermicoRequestDTO request);
    
    /**
     * Calcula carbono incorporado total do projeto [kgCO₂eq/m²]
     * 
     * Busca os materiais do projeto no banco de dados usando idMaterialExterno,
     * obtém os valores de carbono do mock (total_co2e_kg_mf, carbon_a1a3, carbon_c1c4, total_biogenic_co2e),
     * calcula a massa de cada material (densidade × espessura × área),
     * e retorna o carbono total por área do projeto.
     * 
     * @param projetoId ID do projeto para buscar área e materiais
     * @return DTO com carbono total por área [kgCO₂eq/m²] e detalhamento por material
     * @throws RuntimeException se o projeto não for encontrado ou não possuir área definida
     */
    CarbonoIncorporadoResponseDTO calcularCarbonoIncorporado(Long projetoId);
}
