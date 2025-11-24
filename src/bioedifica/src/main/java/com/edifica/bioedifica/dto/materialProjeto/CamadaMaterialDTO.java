package com.edifica.bioedifica.dto.materialProjeto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CamadaMaterialDTO {
  private Long idMaterialExterno;
  private Double espessura;
}
