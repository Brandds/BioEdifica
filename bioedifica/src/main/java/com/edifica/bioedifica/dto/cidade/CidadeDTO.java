package com.edifica.bioedifica.dto.cidade;

import com.edifica.bioedifica.enums.cidade.TipoCidade;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CidadeDTO {
    
    private Long id;
    private String nome;
    private EstadoDTO estado;
    private TipoCidade tipo = TipoCidade.OFICIAL;

    public CidadeDTO(Long id) {
        this.id = id;
    }

}