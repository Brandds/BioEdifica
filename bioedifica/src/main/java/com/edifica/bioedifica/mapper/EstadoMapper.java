package com.edifica.bioedifica.mapper;

import com.edifica.bioedifica.dto.cidade.EstadoDTO;
import com.edifica.bioedifica.model.Estado;

public class EstadoMapper {
    
    public static EstadoDTO toDTO(Estado estado) {
        if (estado == null) return null;
        return new EstadoDTO(
            estado.getId(),
            estado.getUf(),
            estado.getNome()
        );
    }
    
    public static Estado toEntity(EstadoDTO dto) {
        if (dto == null) return null;
        var estado = new Estado();
        estado.setId(dto.getId());
        estado.setUf(dto.getUf());
        estado.setNome(dto.getNome());
        return estado;
    }
    
    public static void updateEntityFromDTO(Estado estado, EstadoDTO dto) {
        if (estado == null || dto == null) return;
        estado.setUf(dto.getUf());
        estado.setNome(dto.getNome());
    }
}