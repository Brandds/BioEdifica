package com.edifica.bioedifica.model;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class Camada {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String nome;
    
    @Enumerated(EnumType.STRING)
    private TipoCamada tipoCamada; // PAREDE, COBERTURA, PISO
    
    @ManyToOne
    private Projeto projeto;
    
    @OneToMany(mappedBy = "camada", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Composicao> composicoes;
    
    // Valores calculados (opcionais - salvos apenas se usuário solicitar)
    @Embedded
    private CalculoTermico calculoTermico;

    public Camada() {}
    
    public Camada(String nome, TipoCamada tipoCamada, Projeto projeto) {
        this.nome = nome;
        this.tipoCamada = tipoCamada;
        this.projeto = projeto;
    }

    public Camada(Long id, String nome, TipoCamada tipoCamada, Projeto projeto, List<Composicao> composicoes, CalculoTermico calculoTermico) {
        this.id = id;
        this.nome = nome;
        this.tipoCamada = tipoCamada;
        this.projeto = projeto;
        this.composicoes = composicoes;
        this.calculoTermico = calculoTermico;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public TipoCamada getTipoCamada() { return tipoCamada; }
    public void setTipoCamada(TipoCamada tipoCamada) { this.tipoCamada = tipoCamada; }

    public Projeto getProjeto() { return projeto; }
    public void setProjeto(Projeto projeto) { this.projeto = projeto; }

    public List<Composicao> getComposicoes() { return composicoes; }
    public void setComposicoes(List<Composicao> composicoes) { this.composicoes = composicoes; }

    public CalculoTermico getCalculoTermico() { return calculoTermico; }
    public void setCalculoTermico(CalculoTermico calculoTermico) { this.calculoTermico = calculoTermico; }
}
