package com.edifica.bioedifica.mapper;

import com.edifica.bioedifica.dto.cidade.ZoneamentoBioclimaticoDTO;
import com.edifica.bioedifica.dto.cidade.ZoneamentoDTO;
import com.edifica.bioedifica.model.Cidade;
import com.edifica.bioedifica.model.ZoneamentoBioclimatico;

public class ZoneamentoBioclimaticoMapper {
    
    public static ZoneamentoBioclimaticoDTO toDTO(ZoneamentoBioclimatico zoneamento) {
        if (zoneamento == null) return null;
        
        var dto = new ZoneamentoBioclimaticoDTO();
        dto.setId(zoneamento.getId());
        dto.setCidade(CidadeMapper.toDTO(zoneamento.getCidade()));
        dto.setZonaBioclimatica(zoneamento.getZonaBioclimatica());
        dto.setLatitude(zoneamento.getLatitude());
        dto.setLongitude(zoneamento.getLongitude());
        dto.setAltitude(zoneamento.getAltitude());
        dto.setTemperaturaBulboSeco(zoneamento.getTemperaturaBulboSeco());
        dto.setUmidadeRelativa(zoneamento.getUmidadeRelativa());
        dto.setRadiacaoHorizontalGlobal(zoneamento.getRadiacaoHorizontalGlobal());
        dto.setVelocidadeVento(zoneamento.getVelocidadeVento());
        dto.setAmplitudeTermica(zoneamento.getAmplitudeTermica());
        
        return dto;
    }
    
    public static ZoneamentoBioclimatico toEntity(ZoneamentoBioclimaticoDTO dto) {
        if (dto == null) return null;
        var zoneamento = new ZoneamentoBioclimatico();
        zoneamento.setId(dto.getId());
        zoneamento.setCidade(CidadeMapper.toEntity(dto.getCidade()));
        zoneamento.setZonaBioclimatica(dto.getZonaBioclimatica());
        zoneamento.setLatitude(dto.getLatitude());
        zoneamento.setLongitude(dto.getLongitude());
        zoneamento.setAltitude(dto.getAltitude());
        zoneamento.setTemperaturaBulboSeco(dto.getTemperaturaBulboSeco());
        zoneamento.setUmidadeRelativa(dto.getUmidadeRelativa());
        zoneamento.setRadiacaoHorizontalGlobal(dto.getRadiacaoHorizontalGlobal());
        zoneamento.setVelocidadeVento(dto.getVelocidadeVento());
        zoneamento.setAmplitudeTermica(dto.getAmplitudeTermica());
        return zoneamento;
    }
    
    public static void updateEntityFromDTO(ZoneamentoBioclimatico zoneamento, ZoneamentoBioclimaticoDTO dto) {
        if (zoneamento == null || dto == null) return;
        zoneamento.setZonaBioclimatica(dto.getZonaBioclimatica());
        zoneamento.setLatitude(dto.getLatitude());
        zoneamento.setLongitude(dto.getLongitude());
        zoneamento.setAltitude(dto.getAltitude());
        zoneamento.setTemperaturaBulboSeco(dto.getTemperaturaBulboSeco());
        zoneamento.setUmidadeRelativa(dto.getUmidadeRelativa());
        zoneamento.setRadiacaoHorizontalGlobal(dto.getRadiacaoHorizontalGlobal());
        zoneamento.setVelocidadeVento(dto.getVelocidadeVento());
        zoneamento.setAmplitudeTermica(dto.getAmplitudeTermica());
        if (dto.getCidade() != null) {
            zoneamento.setCidade(CidadeMapper.toEntity(dto.getCidade()));
        }
    }

    public static ZoneamentoBioclimatico toZoneamentoUsuario(ZoneamentoDTO zoneamento, Long cidadeId) {
        if (zoneamento == null) return null;
        
        var entity = new ZoneamentoBioclimatico();
        entity.setZonaBioclimatica(zoneamento.getZonaBioclimatica());
        entity.setLatitude(zoneamento.getLatitude());
        entity.setLongitude(zoneamento.getLongitude());
        entity.setAltitude(zoneamento.getAltitude());
        entity.setTemperaturaBulboSeco(zoneamento.getTemperaturaBulboSeco());
        entity.setUmidadeRelativa(zoneamento.getUmidadeRelativa());
        entity.setRadiacaoHorizontalGlobal(zoneamento.getRadiacaoHorizontalGlobal());
        entity.setVelocidadeVento(zoneamento.getVelocidadeVento());
        entity.setAmplitudeTermica(zoneamento.getAmplitudeTermica());
        entity.setCidade(new Cidade(cidadeId));
        
        return entity;
    }
}