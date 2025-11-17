package com.edifica.bioedifica.mapper;

import com.edifica.bioedifica.dto.cidade.CidadeDTO;
import com.edifica.bioedifica.model.Cidade;

public class CidadeMapper {
    
    public static CidadeDTO toDTO(Cidade cidade) {
        if (cidade == null) return null;
        return new CidadeDTO(
            cidade.getId(),
            cidade.getNome(),
            EstadoMapper.toDTO(cidade.getEstado()),
            cidade.getTipo()
        );
    }
    
    public static Cidade toEntity(CidadeDTO dto) {
        if (dto == null) return null;
        var cidade = new Cidade();
        cidade.setId(dto.getId());
        cidade.setNome(dto.getNome());
        cidade.setEstado(EstadoMapper.toEntity(dto.getEstado()));
        return cidade;
    }
    
    public static void updateEntityFromDTO(Cidade cidade, CidadeDTO dto) {
        if (cidade == null || dto == null) return;
        cidade.setNome(dto.getNome());
        if (dto.getEstado() != null) {
            cidade.setEstado(EstadoMapper.toEntity(dto.getEstado()));
        }
    }
}