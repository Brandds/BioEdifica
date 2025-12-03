package com.edifica.bioedifica.dto.cidade;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EstadoDTO {
    
    private Long id;
    private String uf;
    private String nome;
}