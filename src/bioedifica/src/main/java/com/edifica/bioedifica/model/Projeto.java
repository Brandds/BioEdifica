package com.edifica.bioedifica.model;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Projeto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String descricao;
    private Double areaTotalConstruida; // em metros quadrados

    @ManyToOne
    private Usuario usuario;

    @ManyToOne
    private Cidade cidade;

    @OneToMany(mappedBy = "projeto")
    private List<MaterialProjeto> materiais;

    private boolean ativo = true;

    public Projeto(Long id) {
        this.id = id;
    }

    public Projeto(String nome, String descricao, Usuario usuario) {
        this.nome = nome;
        this.descricao = descricao;
        this.usuario = usuario;
        this.areaTotalConstruida = null;
    }

    public Projeto(String nome, String descricao, Usuario usuario, Cidade cidade) {
        this.nome = nome;
        this.descricao = descricao;
        this.usuario = usuario;
        this.cidade = cidade;
        this.areaTotalConstruida = null;
    }

    public Projeto (Long id, String nome, String descricao, Usuario usuario) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.usuario = usuario;
        this.areaTotalConstruida = null;
    }

    
}
