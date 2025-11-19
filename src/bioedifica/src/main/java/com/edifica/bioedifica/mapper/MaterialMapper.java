package com.edifica.bioedifica.mapper;

import java.util.List;

import org.springframework.stereotype.Component;

import com.edifica.bioedifica.dto.material.MaterialDTO;
import com.edifica.bioedifica.dto.material.MaterialVisualizacaoDTO;

/**
 * Mapper para conversão entre MaterialDTO e MaterialVisualizacaoDTO
 */
@Component
public class MaterialMapper {

    /**
     * Converte MaterialDTO para MaterialVisualizacaoDTO
     * @param materialDTO DTO completo do material
     * @return DTO simplificado para visualização
     */
    public MaterialVisualizacaoDTO toVisualizacaoDTO(MaterialDTO materialDTO) {
        if (materialDTO == null) {
            return null;
        }

        return new MaterialVisualizacaoDTO(
            materialDTO.id(),
            materialDTO.materialName(),
            materialDTO.materialType(),
            materialDTO.dataSourceUrl(),
            materialDTO.density(),
            materialDTO.materialTypeFamily(),
            null
        );
    }

    /**
     * Converte lista de MaterialDTO para lista de MaterialVisualizacaoDTO
     * @param materiaisDTO Lista de DTOs completos
     * @return Lista de DTOs simplificados para visualização
     */
    public List<MaterialVisualizacaoDTO> toVisualizacaoDTOList(List<MaterialDTO> materiaisDTO) {
        if (materiaisDTO == null) {
            return List.of();
        }

        return materiaisDTO.stream()
            .map(this::toVisualizacaoDTO)
            .toList();
    }
}
