package com.edifica.bioedifica.mapper;

import com.edifica.bioedifica.dto.cidade.CidadeDetalhadaDTO;
import com.edifica.bioedifica.dto.cidade.EstadoDTO;
import com.edifica.bioedifica.dto.cidade.ZoneamentoBioclimaticoDTO;
import com.edifica.bioedifica.dto.projeto.ProjetoDetalhadoDTO;
import com.edifica.bioedifica.model.Cidade;
import com.edifica.bioedifica.model.Projeto;
import com.edifica.bioedifica.model.Usuario;
import com.edifica.bioedifica.model.ZoneamentoBioclimatico;

public class ProjetoMapper {
  public static Projeto toEntity(ProjetoDetalhadoDTO dto, Usuario usuario) {
    if(dto == null) return null;
    Projeto projeto = new Projeto(dto.id(), dto.nome(), dto.descricao(), usuario);
    if(dto.cidade() != null) {
      projeto.setCidade(new Cidade(dto.cidade().getId()));
    }
    return projeto;
  }

  public static ProjetoDetalhadoDTO toDetalhadoDTO(Projeto projeto) {
    if(projeto == null) return null;
    
    CidadeDetalhadaDTO cidadeDTO = null;
    if(projeto.getCidade() != null) {
      Cidade cidade = projeto.getCidade();
      ZoneamentoBioclimaticoDTO zoneamentoDTO = null;
      
      if(cidade.getZoneamentoBioclimatico() != null) {
        ZoneamentoBioclimatico zona = cidade.getZoneamentoBioclimatico();
        zoneamentoDTO = new ZoneamentoBioclimaticoDTO(
          zona.getId(),
          null // Evita referência circular
        );
        zoneamentoDTO.setZonaBioclimatica(zona.getZonaBioclimatica());
        zoneamentoDTO.setLatitude(zona.getLatitude());
        zoneamentoDTO.setLongitude(zona.getLongitude());
        zoneamentoDTO.setAltitude(zona.getAltitude());
        zoneamentoDTO.setTemperaturaBulboSeco(zona.getTemperaturaBulboSeco());
        zoneamentoDTO.setUmidadeRelativa(zona.getUmidadeRelativa());
        zoneamentoDTO.setRadiacaoHorizontalGlobal(zona.getRadiacaoHorizontalGlobal());
        zoneamentoDTO.setVelocidadeVento(zona.getVelocidadeVento());
        zoneamentoDTO.setAmplitudeTermica(zona.getAmplitudeTermica());
      }
      
      EstadoDTO estadoDTO = new EstadoDTO(
        cidade.getEstado().getId(),
        cidade.getEstado().getUf(),
        cidade.getEstado().getNome()
      );
      
      cidadeDTO = new CidadeDetalhadaDTO(
        cidade.getId(),
        cidade.getNome(),
        estadoDTO,
        cidade.getTipo(),
        zoneamentoDTO
      );
    }
    
    return new ProjetoDetalhadoDTO(
      projeto.getId(), 
      projeto.getNome(), 
      projeto.getDescricao(), 
      null,
      cidadeDTO,
      projeto.getAreaTotalConstruida()
    );
  }
}
