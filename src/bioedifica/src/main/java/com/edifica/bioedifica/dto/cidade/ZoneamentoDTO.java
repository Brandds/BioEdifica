package com.edifica.bioedifica.dto.cidade;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ZoneamentoDTO {
  private String zonaBioclimatica;
  private BigDecimal latitude;
  private BigDecimal longitude;
  private Integer altitude;
  private BigDecimal temperaturaBulboSeco;
  private BigDecimal umidadeRelativa;
  private BigDecimal radiacaoHorizontalGlobal;
  private BigDecimal velocidadeVento;
  private BigDecimal amplitudeTermica;

}
