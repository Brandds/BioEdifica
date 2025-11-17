package com.edifica.bioedifica.model;

import com.edifica.bioedifica.enums.cidade.TipoCidade;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "cidade")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Cidade {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name = "nome", length = 100, nullable = false)
    private String nome;
    
    @ManyToOne
    @JoinColumn(name = "estado_id", nullable = false)
    private Estado estado;
    
    @Enumerated(EnumType.STRING)
    @Column(name = "tipo", nullable = false)
    private TipoCidade tipo = TipoCidade.OFICIAL; // Padrão para cidades do sistema
    
    @ManyToOne
    @JoinColumn(name = "usuario_criador_id")
    private Usuario usuarioCriador; // Null para cidades oficiais, preenchido para cidades de usuário
    
    @OneToOne(mappedBy = "cidade", cascade = CascadeType.ALL)
    private ZoneamentoBioclimatico zoneamentoBioclimatico;
    
    public Cidade(Long id) {
        this.id = id;
    }
    
    public Cidade(String nome, Estado estado) {
        this.nome = nome;
        this.estado = estado;
        this.tipo = TipoCidade.OFICIAL; // Padrão para cidades do sistema
    }
    
    // Construtor para cidade criada pelo usuário
    public Cidade(String nome, Estado estado, Usuario usuarioCriador) {
        this.nome = nome;
        this.estado = estado;
        this.tipo = TipoCidade.USUARIO;
        this.usuarioCriador = usuarioCriador;
    }
}