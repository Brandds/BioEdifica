package com.edifica.bioedifica.service;

import java.util.List;

import com.edifica.bioedifica.dto.camada.CamadaResponseDTO;
import com.edifica.bioedifica.dto.camada.CriarCamadaComCalculoDTO;

/**
 * Interface de serviço para operações com Camada
 */
public interface ICamadaService {
    
    /**
     * Cria uma nova camada com cálculo térmico
     * - Busca dados dos materiais no mock
     * - Calcula propriedades térmicas
     * - Salva a camada, composições e materiais do projeto
     * 
     * @param dto Dados da camada e lista de materiais do mock
     * @return Camada criada com cálculo térmico
     */
    CamadaResponseDTO criarCamadaComCalculo(CriarCamadaComCalculoDTO dto);
    
    /**
     * Lista todas as camadas de um projeto
     * 
     * @param projetoId ID do projeto
     * @return Lista de camadas com materiais e cálculos
     */
    List<CamadaResponseDTO> listarCamadasPorProjeto(Long projetoId);
    
    /**
     * Busca uma camada por ID
     * 
     * @param camadaId ID da camada
     * @return Dados da camada
     */
    CamadaResponseDTO buscarCamadaPorId(Long camadaId);
    
    /**
     * Exclui uma camada e todos os materiais vinculados
     * Usa cascade para deletar composições automaticamente
     * 
     * @param camadaId ID da camada a ser excluída
     */
    void excluirCamada(Long camadaId);
}
