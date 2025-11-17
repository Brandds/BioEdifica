package com.edifica.bioedifica.service.serviceImpl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.edifica.bioedifica.dto.CalculoTermicoDTO;
import com.edifica.bioedifica.dto.MaterialProjetoDTO;
import com.edifica.bioedifica.dto.ResumoCalculosTermicosDTO;
import com.edifica.bioedifica.model.Projeto;
import com.edifica.bioedifica.repository.ProjetoRepository;
import com.edifica.bioedifica.service.IMaterialProjetoService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CalculoTermicoService {

    private final IMaterialProjetoService materialProjetoService;
    private final ProjetoRepository projetoRepository;

    /**
     * Calcula a Resistência Térmica Total (R) em m²K/W
     * R = Σ(espessura / condutividade_termica) para cada camada
     */
    public CalculoTermicoDTO calcularResistenciaTermicaTotal(Long projetoId) {
        List<MaterialProjetoDTO> materiais = materialProjetoService.buscarMateriaisPorProjeto(projetoId);
        
        double resistenciaTotal = materiais.stream()
            .filter(m -> m.getEspessura() != null && m.getCondutividadeTermica() != null)
            .filter(m -> m.getCondutividadeTermica() > 0)
            .mapToDouble(m -> m.getEspessura() / m.getCondutividadeTermica())
            .sum();

        return new CalculoTermicoDTO(
            projetoId,
            resistenciaTotal,
            "m²K/W",
            "Resistência térmica total do conjunto de materiais",
            "RESISTENCIA_TERMICA_TOTAL"
        );
    }

    /**
     * Calcula o Atraso Térmico φ (horas)
     * φ = 1.382 * Σ(Ri * Ci) onde Ri = espessura/condutividade e Ci = densidade * calor_especifico * espessura
     */
    public CalculoTermicoDTO calcularAtrasoTermico(Long projetoId) {
        List<MaterialProjetoDTO> materiais = materialProjetoService.buscarMateriaisPorProjeto(projetoId);
        
        double somaRiCi = materiais.stream()
            .filter(this::todosParametrosPresentes)
            .mapToDouble(m -> {
                double Ri = m.getEspessura() / m.getCondutividadeTermica();
                double Ci = m.getDensidade() * m.getCalorEspecifico() * m.getEspessura();
                return Ri * Ci;
            })
            .sum();

        double atrasoTermico = 1.382 * somaRiCi;

        return new CalculoTermicoDTO(
            projetoId,
            atrasoTermico,
            "horas",
            "Atraso térmico do conjunto de materiais",
            "ATRASO_TERMICO"
        );
    }

    /**
     * Calcula a Capacidade Térmica (kJ/m²K)
     * CT = Σ(densidade * calor_especifico * espessura)
     */
    public CalculoTermicoDTO calcularCapacidadeTermica(Long projetoId) {
        List<MaterialProjetoDTO> materiais = materialProjetoService.buscarMateriaisPorProjeto(projetoId);
        
        double capacidadeTermica = materiais.stream()
            .filter(this::todosParametrosPresentes)
            .mapToDouble(m -> m.getDensidade() * m.getCalorEspecifico() * m.getEspessura())
            .sum();

        return new CalculoTermicoDTO(
            projetoId,
            capacidadeTermica,
            "kJ/m²K",
            "Capacidade térmica total do conjunto de materiais",
            "CAPACIDADE_TERMICA"
        );
    }

    /**
     * Calcula a Transmitância Térmica (W/m²K)
     * U = 1 / Rt onde Rt é a resistência térmica total
     */
    public CalculoTermicoDTO calcularTransmitanciaTermica(Long projetoId) {
        CalculoTermicoDTO resistenciaTotal = calcularResistenciaTermicaTotal(projetoId);
        
        double transmitancia = 0.0;
        if (resistenciaTotal.getValor() > 0) {
            transmitancia = 1.0 / resistenciaTotal.getValor();
        }

        return new CalculoTermicoDTO(
            projetoId,
            transmitancia,
            "W/m²K",
            "Transmitância térmica do conjunto de materiais",
            "TRANSMITANCIA_TERMICA"
        );
    }

    /**
     * Retorna um resumo completo com todos os cálculos térmicos
     */
    public ResumoCalculosTermicosDTO calcularResumoCompleto(Long projetoId) {
        Projeto projeto = projetoRepository.findById(projetoId)
            .orElseThrow(() -> new RuntimeException("Projeto não encontrado"));

        List<MaterialProjetoDTO> materiaisDTO = materialProjetoService.buscarMateriaisPorProjeto(projetoId);

        return new ResumoCalculosTermicosDTO(
            projetoId,
            projeto.getNome(),
            materiaisDTO,
            calcularResistenciaTermicaTotal(projetoId),
            calcularAtrasoTermico(projetoId),
            calcularCapacidadeTermica(projetoId),
            calcularTransmitanciaTermica(projetoId)
        );
    }

    private boolean todosParametrosPresentes(MaterialProjetoDTO material) {
        return material.getDensidade() != null && 
               material.getCalorEspecifico() != null && 
               material.getCondutividadeTermica() != null && 
               material.getEspessura() != null &&
               material.getCondutividadeTermica() > 0 &&
               material.getEspessura() > 0;
    }
}