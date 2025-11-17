package com.edifica.bioedifica.enums.cidade;

public enum TipoCidade {
    OFICIAL("Cidade oficial do sistema"),
    USUARIO("Cidade criada pelo usuário");
    
    private final String descricao;
    
    TipoCidade(String descricao) {
        this.descricao = descricao;
    }
    
    public String getDescricao() {
        return descricao;
    }
}