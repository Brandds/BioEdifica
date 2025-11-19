package com.edifica.bioedifica.service;

import java.util.List;

import com.edifica.bioedifica.dto.MaterialProjetoDTO;
import com.edifica.bioedifica.dto.material.MaterialVisualizacaoDTO;

public interface IMaterialProjetoService {
  List<MaterialVisualizacaoDTO> buscarMateriaisPorProjeto(Long projetoId);
  MaterialProjetoDTO adicionarMaterialAoProjeto(Long projetoId, MaterialProjetoDTO materialDTO);
  MaterialProjetoDTO adicionarMaterialDoMock(Long projetoId, Long idMaterialExterno, Double espessura);
  MaterialProjetoDTO atualizarMaterial(Long materialId, MaterialProjetoDTO materialDTO);
  void removerMaterial(Long materialId);
}
