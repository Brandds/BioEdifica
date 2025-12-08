package com.edifica.bioedifica.model;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
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

    public Projeto() {}

    public Projeto(Long id, String nome, String descricao, Double areaTotalConstruida, Usuario usuario, Cidade cidade, List<MaterialProjeto> materiais, boolean ativo) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.areaTotalConstruida = areaTotalConstruida;
        this.usuario = usuario;
        this.cidade = cidade;
        this.materiais = materiais;
        this.ativo = ativo;
    }

    // Getters e Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getDescricao() { return descricao; }
    public void setDescricao(String descricao) { this.descricao = descricao; }

    public Double getAreaTotalConstruida() { return areaTotalConstruida; }
    public void setAreaTotalConstruida(Double areaTotalConstruida) { this.areaTotalConstruida = areaTotalConstruida; }

    public Usuario getUsuario() { return usuario; }
    public void setUsuario(Usuario usuario) { this.usuario = usuario; }

    public Cidade getCidade() { return cidade; }
    public void setCidade(Cidade cidade) { this.cidade = cidade; }

    public List<MaterialProjeto> getMateriais() { return materiais; }
    public void setMateriais(List<MaterialProjeto> materiais) { this.materiais = materiais; }

    public boolean isAtivo() { return ativo; }
    public void setAtivo(boolean ativo) { this.ativo = ativo; }

    
}
