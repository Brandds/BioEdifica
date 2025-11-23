package com.edifica.bioedifica.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Data
@Entity
public class MaterialProjeto {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private Long idMaterialExterno;

  @ManyToOne
  private Projeto projeto;

  @ManyToOne
  private Camada camada;

  // Propriedades térmicas do material para cálculos

  private Double densidade; // kg/m³

  private Double calorEspecifico; // kJ/(kg.K)

  private Double condutividadeTermica; // W/(m.K)

  private Double espessura; // metros

  private String nomeMaterial;

  private String tipoAplicacao; // PAREDE, COBERTURA

  public MaterialProjeto() {
  }

  public MaterialProjeto(Projeto projeto, Long idMaterialExterno) {
    this.projeto = projeto;
    this.idMaterialExterno = idMaterialExterno;
  }

  public MaterialProjeto(Projeto projeto, Long idMaterialExterno, Double densidade, 
                        Double calorEspecifico, Double condutividadeTermica, Double espessura,
                        String nomeMaterial, String tipoAplicacao) {
    this.projeto = projeto;
    this.idMaterialExterno = idMaterialExterno;
    this.densidade = densidade;
    this.calorEspecifico = calorEspecifico;
    this.condutividadeTermica = condutividadeTermica;
    this.espessura = espessura;
    this.nomeMaterial = nomeMaterial;
    this.tipoAplicacao = tipoAplicacao;
  }
}
