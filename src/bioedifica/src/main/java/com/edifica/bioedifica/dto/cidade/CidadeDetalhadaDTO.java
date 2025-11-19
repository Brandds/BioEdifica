package com.edifica.bioedifica.dto.cidade;

import com.edifica.bioedifica.enums.cidade.TipoCidade;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class CidadeDetalhadaDTO extends CidadeDTO {
    
    private ZoneamentoBioclimaticoDTO zoneamentoBioclimatico;
    
    public CidadeDetalhadaDTO(Long id, String nome, EstadoDTO estado, TipoCidade tipo,
                              ZoneamentoBioclimaticoDTO zoneamentoBioclimatico) {
        super(id, nome, estado, tipo);
        this.zoneamentoBioclimatico = zoneamentoBioclimatico;
    }
}
