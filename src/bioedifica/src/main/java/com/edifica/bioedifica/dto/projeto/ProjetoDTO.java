package com.edifica.bioedifica.dto.projeto;

public record ProjetoDTO(
    Long id,
    String nome,
    String descricao,
    Long usuarioId,
    Long cidadeId
) {}
