package com.edifica.bioedifica.model;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Composicao {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @ManyToOne
    @JoinColumn(name = "camada_id", nullable = false)
    private Camada camada;
    
    @ManyToOne
    @JoinColumn(name = "material_projeto_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private MaterialProjeto materialProjeto;
    
    private Double espessura; // metros (pode sobrescrever espessura do MaterialProjeto)
    
    private Integer ordem; // ordem do material na camada (1, 2, 3...)

    public Composicao() {}

    public Composicao(Camada camada, MaterialProjeto materialProjeto, Integer ordem) {
        this.camada = camada;
        this.materialProjeto = materialProjeto;
        this.ordem = ordem;
    }

    public Composicao(Camada camada, MaterialProjeto materialProjeto, Double espessura, Integer ordem) {
        this.camada = camada;
        this.materialProjeto = materialProjeto;
        this.espessura = espessura;
        this.ordem = ordem;
    }

    public Composicao(Long id, Camada camada, MaterialProjeto materialProjeto, Double espessura, Integer ordem) {
        this.id = id;
        this.camada = camada;
        this.materialProjeto = materialProjeto;
        this.espessura = espessura;
        this.ordem = ordem;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Camada getCamada() { return camada; }
    public void setCamada(Camada camada) { this.camada = camada; }

    public MaterialProjeto getMaterialProjeto() { return materialProjeto; }
    public void setMaterialProjeto(MaterialProjeto materialProjeto) { this.materialProjeto = materialProjeto; }

    public Double getEspessura() { return espessura; }
    public void setEspessura(Double espessura) { this.espessura = espessura; }

    public Integer getOrdem() { return ordem; }
    public void setOrdem(Integer ordem) { this.ordem = ordem; }
}
