package com.edifica.bioedifica.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

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

  // Getters e Setters
  public Long getId() { return id; }
  public void setId(Long id) { this.id = id; }

  public Long getIdMaterialExterno() { return idMaterialExterno; }
  public void setIdMaterialExterno(Long idMaterialExterno) { this.idMaterialExterno = idMaterialExterno; }

  public Projeto getProjeto() { return projeto; }
  public void setProjeto(Projeto projeto) { this.projeto = projeto; }

  public Camada getCamada() { return camada; }
  public void setCamada(Camada camada) { this.camada = camada; }

  public Double getDensidade() { return densidade; }
  public void setDensidade(Double densidade) { this.densidade = densidade; }

  public Double getCalorEspecifico() { return calorEspecifico; }
  public void setCalorEspecifico(Double calorEspecifico) { this.calorEspecifico = calorEspecifico; }

  public Double getCondutividadeTermica() { return condutividadeTermica; }
  public void setCondutividadeTermica(Double condutividadeTermica) { this.condutividadeTermica = condutividadeTermica; }

  public Double getEspessura() { return espessura; }
  public void setEspessura(Double espessura) { this.espessura = espessura; }

  public String getNomeMaterial() { return nomeMaterial; }
  public void setNomeMaterial(String nomeMaterial) { this.nomeMaterial = nomeMaterial; }

  public String getTipoAplicacao() { return tipoAplicacao; }
  public void setTipoAplicacao(String tipoAplicacao) { this.tipoAplicacao = tipoAplicacao; }
}
