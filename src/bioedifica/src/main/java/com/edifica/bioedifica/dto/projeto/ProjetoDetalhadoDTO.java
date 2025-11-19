package com.edifica.bioedifica.dto.projeto;

import java.util.List;

import com.edifica.bioedifica.dto.cidade.CidadeDetalhadaDTO;
import com.edifica.bioedifica.dto.material.MaterialDTO;

public record ProjetoDetalhadoDTO(
  Long id,
  String nome,
  String descricao,
  List<MaterialDTO> materiais,
  CidadeDetalhadaDTO cidade
){}
