package com.edifica.bioedifica.service;

import java.util.List;

import com.edifica.bioedifica.dto.FiltroDinamico;
import com.edifica.bioedifica.dto.material.MaterialCategoriaDTO;
import com.edifica.bioedifica.dto.material.MaterialDTO;
import com.edifica.bioedifica.dto.material.MaterialVisualizacaoDTO;

public interface IMockMaterialService {
    List<MaterialCategoriaDTO> getMaterialCategorias();
    List<MaterialDTO> filtrarMateriais(List<FiltroDinamico> filtros);
    List<MaterialDTO> getMaterialByProjeto(List<Long> idsMateriais);
    MaterialDTO getMaterialById(Long id);
    List<MaterialVisualizacaoDTO> getMaterialsByCategory(String category);
    List<MaterialVisualizacaoDTO> getMaterialsBytipoProduto(String tipoProduto);
    List<MaterialVisualizacaoDTO> getMaterialsByTipoFamilia(String tipoFamilia);
}
