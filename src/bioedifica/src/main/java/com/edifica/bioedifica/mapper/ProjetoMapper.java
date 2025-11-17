package com.edifica.bioedifica.mapper;

import com.edifica.bioedifica.dto.projeto.ProjetoDetalhadoDTO;
import com.edifica.bioedifica.model.Projeto;
import com.edifica.bioedifica.model.Usuario;

public class ProjetoMapper {
  public static Projeto toEntity(ProjetoDetalhadoDTO dto, Usuario usuario) {
    if(dto == null) return null;
    return new Projeto(dto.id(), dto.nome(), dto.descricao(), usuario);
  }

  public static ProjetoDetalhadoDTO toDetalhadoDTO(Projeto projeto) {
    if(projeto == null) return null;
    return new ProjetoDetalhadoDTO(projeto.getId(), projeto.getNome(), projeto.getDescricao(), null);
  }
}
