package com.edifica.bioedifica.dto.cidade;

import com.edifica.bioedifica.enums.cidade.TipoCidade;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CidadeDTO {
    
    private Long id;
    private String nome;
    private EstadoDTO estado;
    @Builder.Default
    private TipoCidade tipo = TipoCidade.OFICIAL;

    public CidadeDTO(Long id) {
        this.id = id;
    }

}