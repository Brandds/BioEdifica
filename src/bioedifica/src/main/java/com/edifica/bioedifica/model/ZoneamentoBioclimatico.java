package com.edifica.bioedifica.model;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "zoneamento_bioclimatico")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ZoneamentoBioclimatico {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @OneToOne
    @JoinColumn(name = "cidade_id", nullable = false)
    private Cidade cidade;
    
    @Column(name = "zona_bioclimatica", length = 10)
    private String zonaBioclimatica;
    
    @Column(name = "latitude", precision = 10, scale = 6)
    private BigDecimal latitude;
    
    @Column(name = "longitude", precision = 10, scale = 6)
    private BigDecimal longitude;
    
    @Column(name = "altitude")
    private Integer altitude;
    
    @Column(name = "temperatura_bulbo_seco", precision = 5, scale = 2)
    private BigDecimal temperaturaBulboSeco;
    
    @Column(name = "umidade_relativa", precision = 5, scale = 2)
    private BigDecimal umidadeRelativa;
    
    @Column(name = "radiacao_horizontal_global", precision = 8, scale = 2)
    private BigDecimal radiacaoHorizontalGlobal;
    
    @Column(name = "velocidade_vento", precision = 5, scale = 2)
    private BigDecimal velocidadeVento;
    
    @Column(name = "amplitude_termica", precision = 5, scale = 2)
    private BigDecimal amplitudeTermica;
    
    public ZoneamentoBioclimatico(Long id) {
        this.id = id;
    }
}