package com.edifica.bioedifica.dto.cidade;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class ZoneamentoBioclimaticoDTO extends ZoneamentoDTO {
    
    private Long id;
    private CidadeDTO cidade;
}