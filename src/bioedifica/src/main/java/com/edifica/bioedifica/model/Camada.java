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
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
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
    
    public Camada(String nome, TipoCamada tipoCamada, Projeto projeto) {
        this.nome = nome;
        this.tipoCamada = tipoCamada;
        this.projeto = projeto;
    }
}
