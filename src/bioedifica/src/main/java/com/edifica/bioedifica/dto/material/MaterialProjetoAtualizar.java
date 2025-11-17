package com.edifica.bioedifica.dto.material;

public record MaterialProjetoAtualizar(
  Long idMaterialProjeto,
  Long idProjeto,
  boolean remover
) {
  
}
