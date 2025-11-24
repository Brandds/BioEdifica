package com.edifica.bioedifica.service.serviceImpl;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import org.springframework.stereotype.Service;

import com.edifica.bioedifica.dto.CalculoTermicoRequestDTO;
import com.edifica.bioedifica.dto.CalculoTermicoResponseDTO;
import com.edifica.bioedifica.dto.CarbonoIncorporadoResponseDTO;
import com.edifica.bioedifica.dto.CarbonoMaterialDTO;
import com.edifica.bioedifica.dto.MaterialCalculoDTO;
import com.edifica.bioedifica.dto.MaterialDetalhadoDTO;
import com.edifica.bioedifica.dto.material.MaterialDTO;
import com.edifica.bioedifica.model.MaterialProjeto;
import com.edifica.bioedifica.model.Projeto;
import com.edifica.bioedifica.repository.MaterialProjetoRepository;
import com.edifica.bioedifica.repository.ProjetoRepository;
import com.edifica.bioedifica.service.ICalculoTermicoService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CalculoTermicoService implements ICalculoTermicoService {

    private final MockMaterialService mockMaterialService;
    private final ProjetoRepository projetoRepository;
    private final MaterialProjetoRepository materialProjetoRepository;

    @Override
    public CalculoTermicoResponseDTO calcularPropriedadesTermicas(CalculoTermicoRequestDTO request) {
        
        // Ordena materiais pela ordem
        List<MaterialCalculoDTO> materiaisOrdenados = request.getMateriais().stream()
                .sorted(Comparator.comparing(MaterialCalculoDTO::getOrdem))
                .toList();
        
        // Busca propriedades térmicas de cada material no mock
        List<MaterialDetalhadoDTO> materiaisDetalhados = new ArrayList<>();
        
        for (MaterialCalculoDTO mat : materiaisOrdenados) {
            var materialMock = mockMaterialService.getMaterialById(mat.getIdMaterialMock());
            
            if (materialMock == null) {
                throw new RuntimeException("Material com ID " + mat.getIdMaterialMock() + " não encontrado no mock");
            }
            
            // Busca propriedades térmicas do mock
            Double densidade = materialMock.density(); 
            Double calorEspecifico = materialMock.calorEspecifico();
            Double condutividade = materialMock.condutividadeTermica();
            
            MaterialDetalhadoDTO detalhado = new MaterialDetalhadoDTO(
                    mat.getIdMaterialMock(),
                    materialMock.materialName(),
                    mat.getEspessura(),
                    mat.getOrdem(),
                    densidade,
                    calorEspecifico,
                    condutividade
            );
            
            materiaisDetalhados.add(detalhado);
        }
        
        // Calcula propriedades térmicas segundo NBR 15220-2
        Double resistenciaTermica = calcularResistenciaTermicaTotal(materiaisDetalhados, request.getTipoCamada());
        Double transmitancia = calcularTransmitanciaTermica(resistenciaTermica);
        Double capacidade = calcularCapacidadeTermica(materiaisDetalhados);
        Double atraso = calcularAtrasoTermico(materiaisDetalhados);
        
        return new CalculoTermicoResponseDTO(
                transmitancia,
                capacidade,
                atraso,
                resistenciaTermica,
                materiaisDetalhados
        );
    }
    
    /**
     * Calcula Resistência Térmica Total RT = Σ(e/λ) + Rse + Rsi
     * NBR 15220-2, item 5.2
     * Resistências superficiais variam conforme o tipo de camada (Tabela B.1)
     */
    private Double calcularResistenciaTermicaTotal(List<MaterialDetalhadoDTO> materiais, String tipoCamada) {
        // Resistências superficiais (NBR 15220-2, Tabela B.1)
        double RSI; // Resistência superficial interna [m².K/W]
        final double RSE = 0.04; // Resistência superficial externa [m².K/W]
        
        // Define RSI conforme o tipo de camada
        switch (tipoCamada.toUpperCase()) {
            case "PAREDE":
                RSI = 0.13;
                break;
            case "COBERTURA":
                RSI = 0.10;
                break;
            case "PISO":
                RSI = 0.17;
                break;
            default:
                RSI = 0.13; // Valor padrão (parede)
        }
        
        double somatorioR = 0.0;
        
        for (MaterialDetalhadoDTO mat : materiais) {
            if (mat.getCondutividadeTermica() != null && mat.getCondutividadeTermica() > 0 
                    && mat.getEspessura() != null) {
                // R = e / λ
                somatorioR += mat.getEspessura() / mat.getCondutividadeTermica();
            }
        }
        
        return RSI + somatorioR + RSE; // [m².K/W]
    }
    
    /**
     * Calcula Transmitância Térmica U = 1 / RT
     * NBR 15220-2, item 5.1
     */
    private Double calcularTransmitanciaTermica(Double resistenciaTermica) {
        if (resistenciaTermica != null && resistenciaTermica > 0) {
            return 1.0 / resistenciaTermica; // [W/(m².K)]
        }
        return null;
    }
    
    /**
     * Calcula Capacidade Térmica CT = Σ(ρ × c × e)
     * NBR 15220-2, item 5.3
     */
    private Double calcularCapacidadeTermica(List<MaterialDetalhadoDTO> materiais) {
        double ct = 0.0;
        
        for (MaterialDetalhadoDTO mat : materiais) {
            if (mat.getDensidade() != null && mat.getCalorEspecifico() != null 
                    && mat.getEspessura() != null) {
                // CT = ρ × c × e
                ct += mat.getDensidade() * mat.getCalorEspecifico() * mat.getEspessura();
            }
        }
        
        return ct; // [kJ/(m².K)]
    }
    
    /**
     * Calcula Atraso Térmico φ = 1.382 × RT × √(CT)
     * NBR 15220-2, item 5.4 - Método simplificado
     */
    private Double calcularAtrasoTermico(List<MaterialDetalhadoDTO> materiais) {
        double soma = 0.0;
        double rAcumulada = 0.0;
        
        for (MaterialDetalhadoDTO mat : materiais) {
            if (mat.getDensidade() != null && mat.getCalorEspecifico() != null
                    && mat.getCondutividadeTermica() != null && mat.getCondutividadeTermica() > 0
                    && mat.getEspessura() != null) {
                
                double r = mat.getEspessura() / mat.getCondutividadeTermica();
                double ct = mat.getDensidade() * mat.getCalorEspecifico() * mat.getEspessura();
                
                soma += (rAcumulada + r / 2.0) * ct;
                rAcumulada += r;
            }
        }
        
        if (soma > 0) {
            return 1.382 * soma / 3.6; // Conversão para horas
        }
        
        return 0.0; // [horas]
    }
    
    @Override
    public CarbonoIncorporadoResponseDTO calcularCarbonoIncorporado(Long projetoId) {
        // 1. Buscar o projeto no banco de dados
        Projeto projeto = projetoRepository.findById(projetoId)
                .orElseThrow(() -> new RuntimeException("Projeto com ID " + projetoId + " não encontrado"));
        
        // 2. Validar se o projeto possui área definida
        if (projeto.getAreaTotalConstruida() == null || projeto.getAreaTotalConstruida() <= 0) {
            throw new RuntimeException("Projeto não possui área total construída definida");
        }
        
        Double areaTotalProjeto = projeto.getAreaTotalConstruida();
        
        // 3. Buscar todos os materiais do projeto
        List<MaterialProjeto> materiaisDoProjeto = materialProjetoRepository.findByProjetoId(projetoId);
        
        if (materiaisDoProjeto.isEmpty()) {
            throw new RuntimeException("Projeto não possui materiais cadastrados");
        }
        
        // 4. Calcular carbono de cada material
        List<CarbonoMaterialDTO> materiaisDetalhados = new ArrayList<>();
        double carbonoTotalAbsoluto = 0.0;
        
        for (MaterialProjeto materialProjeto : materiaisDoProjeto) {
            Long idMaterialMock = materialProjeto.getIdMaterialExterno();
            
            // Buscar dados do material no mock
            MaterialDTO materialMock = mockMaterialService.getMaterialById(idMaterialMock);
            
            if (materialMock == null) {
                System.err.println("Material com ID " + idMaterialMock + " não encontrado no mock. Ignorando...");
                continue;
            }
            
            // Obter valores de carbono do mock
            Double co2PorKg = materialMock.totalCo2eKgMf(); // total_co2e_kg_mf
            Double carbonoA1A3 = materialMock.carbonA1a3(); // carbon_a1a3
            Double carbonoC1C4 = materialMock.carbonC1c4(); // carbon_c1c4
            Double carbonoBiogenico = materialMock.totalBiogenicCo2e(); // total_biogenic_co2e
            
            // Obter densidade e espessura do MaterialProjeto
            Double densidade = materialProjeto.getDensidade();
            Double espessura = materialProjeto.getEspessura();
            
            // Validar dados necessários
            if (densidade == null || espessura == null || co2PorKg == null) {
                System.err.println("Material " + materialMock.materialName() + " não possui densidade, espessura ou CO2. Ignorando...");
                continue;
            }
            
            // Calcular massa por unidade de área [kg/m²]
            // massa_por_m² = densidade [kg/m³] × espessura [m]
            Double massaPorUnidade = densidade * espessura;
            
            // Calcular carbono total do material [kgCO₂eq]
            // carbono_total = massa_por_m² [kg/m²] × área_total [m²] × co2_por_kg [kgCO₂eq/kg]
            Double carbonoTotalMaterial = massaPorUnidade * areaTotalProjeto * co2PorKg;
            
            carbonoTotalAbsoluto += carbonoTotalMaterial;
            
            // Criar DTO com detalhamento
            CarbonoMaterialDTO materialDetalhado = new CarbonoMaterialDTO(
                    idMaterialMock,
                    materialMock.materialName(),
                    materialMock.materialType(),
                    espessura,
                    densidade,
                    massaPorUnidade,
                    co2PorKg,
                    carbonoA1A3,
                    carbonoC1C4,
                    carbonoBiogenico,
                    carbonoTotalMaterial
            );
            
            materiaisDetalhados.add(materialDetalhado);
        }
        
        // 5. Calcular carbono por área [kgCO₂eq/m²]
        Double carbonoTotalPorArea = carbonoTotalAbsoluto / areaTotalProjeto;
        
        // 6. Retornar resposta
        return new CarbonoIncorporadoResponseDTO(
                carbonoTotalPorArea,
                carbonoTotalAbsoluto,
                areaTotalProjeto,
                projeto.getNome(),
                materiaisDetalhados.size(),
                materiaisDetalhados
        );
    }
}
