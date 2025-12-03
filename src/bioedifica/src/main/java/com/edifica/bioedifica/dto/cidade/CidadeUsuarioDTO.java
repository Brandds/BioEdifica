package com.edifica.bioedifica.dto.cidade;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CidadeUsuarioDTO {
    
    @NotBlank(message = "Nome da cidade é obrigatório")
    private String nome;
    
    @NotNull(message = "Estado é obrigatório")
    private Long estadoId;
    
    // Campos opcionais para zoneamento bioclimático
    private ZoneamentoDTO zoneamentoBioclimatico;
}