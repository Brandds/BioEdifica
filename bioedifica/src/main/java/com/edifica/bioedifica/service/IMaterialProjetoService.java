package com.edifica.bioedifica.service;

import java.util.List;

import com.edifica.bioedifica.dto.MaterialProjetoDTO;

public interface IMaterialProjetoService {
  List<MaterialProjetoDTO> buscarMateriaisPorProjeto(Long projetoId);
  MaterialProjetoDTO adicionarMaterialAoProjeto(Long projetoId, MaterialProjetoDTO materialDTO);
  MaterialProjetoDTO adicionarMaterialDoMock(Long projetoId, Long idMaterialExterno, Double espessura);
  MaterialProjetoDTO atualizarMaterial(Long materialId, MaterialProjetoDTO materialDTO);
  void removerMaterial(Long materialId);
}
