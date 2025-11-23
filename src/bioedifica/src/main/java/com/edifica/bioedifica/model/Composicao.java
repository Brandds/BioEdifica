package com.edifica.bioedifica.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Composicao {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @ManyToOne
    @JoinColumn(name = "camada_id", nullable = false)
    private Camada camada;
    
    @ManyToOne
    @JoinColumn(name = "material_projeto_id", nullable = false)
    private MaterialProjeto materialProjeto;
    
    private Double espessura; // metros (pode sobrescrever espessura do MaterialProjeto)
    
    private Integer ordem; // ordem do material na camada (1, 2, 3...)
    
    public Composicao(Camada camada, MaterialProjeto materialProjeto, Double espessura, Integer ordem) {
        this.camada = camada;
        this.materialProjeto = materialProjeto;
        this.espessura = espessura;
        this.ordem = ordem;
    }
}
