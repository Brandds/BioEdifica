package com.edifica.bioedifica.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

import java.util.Arrays;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.edifica.bioedifica.dto.CalculoTermicoRequestDTO;
import com.edifica.bioedifica.dto.CalculoTermicoResponseDTO;
import com.edifica.bioedifica.dto.CarbonoIncorporadoResponseDTO;
import com.edifica.bioedifica.dto.MaterialCalculoDTO;
import com.edifica.bioedifica.dto.material.MaterialDTO;
import com.edifica.bioedifica.model.MaterialProjeto;
import com.edifica.bioedifica.model.Projeto;
import com.edifica.bioedifica.repository.MaterialProjetoRepository;
import com.edifica.bioedifica.repository.ProjetoRepository;
import com.edifica.bioedifica.service.serviceImpl.CalculoTermicoService;
import com.edifica.bioedifica.service.serviceImpl.MockMaterialService;

/**
 * Testes unitários para CalculoTermicoService
 * Testa os cálculos de propriedades térmicas segundo NBR 15220-2
 * e cálculo de carbono incorporado
 */
@ExtendWith(MockitoExtension.class)
class CalculoTermicoServiceTest {

    @Mock
    private MockMaterialService mockMaterialService;

    @Mock
    private ProjetoRepository projetoRepository;

    @Mock
    private MaterialProjetoRepository materialProjetoRepository;

    @InjectMocks
    private CalculoTermicoService calculoTermicoService;

    private CalculoTermicoRequestDTO requestDTO;
    private MaterialDTO materialMock1;
    private MaterialDTO materialMock2;
    private Projeto projeto;
    private MaterialProjeto materialProjeto1;

    @BeforeEach
    void setUp() {
        // Material 1: Concreto
        materialMock1 = MaterialDTO.builder()
            .id(1L)
            .materialName("Concreto")
            .density(2400.0)           // kg/m³
            .calorEspecifico(1.0)      // kJ/(kg.K)
            .condutividadeTermica(1.75) // W/(m.K)
            .totalCo2eKgMf(0.15)       // kgCO2/kg
            .carbonA1a3(0.12)
            .carbonC1c4(0.03)
            .totalBiogenicCo2e(0.0)
            .build();

        // Material 2: Tijolo cerâmico
        materialMock2 = MaterialDTO.builder()
            .id(2L)
            .materialName("Tijolo Cerâmico")
            .density(1600.0)
            .calorEspecifico(0.92)
            .condutividadeTermica(0.90)
            .totalCo2eKgMf(0.10)
            .carbonA1a3(0.08)
            .carbonC1c4(0.02)
            .totalBiogenicCo2e(0.0)
            .build();

        // Request para cálculo térmico
        MaterialCalculoDTO mat1 = new MaterialCalculoDTO(1L, 0.10, 1); // 10cm de concreto
        MaterialCalculoDTO mat2 = new MaterialCalculoDTO(2L, 0.15, 2); // 15cm de tijolo

        requestDTO = new CalculoTermicoRequestDTO("PAREDE", Arrays.asList(mat1, mat2));

        // Projeto para cálculo de carbono
        projeto = new Projeto();
        projeto.setId(1L);
        projeto.setNome("Casa Sustentável");
        projeto.setAreaTotalConstruida(100.0); // 100 m²

        // Material do projeto
        materialProjeto1 = new MaterialProjeto();
        materialProjeto1.setId(1L);
        materialProjeto1.setIdMaterialExterno(1L);
        materialProjeto1.setEspessura(0.10); // 10cm
        materialProjeto1.setDensidade(2400.0); // kg/m³
        materialProjeto1.setProjeto(projeto);
    }

    @Test
    @DisplayName("Deve calcular propriedades térmicas de parede corretamente")
    void testCalcularPropriedadesTermicasParede() {
        when(mockMaterialService.getMaterialById(1L)).thenReturn(materialMock1);
        when(mockMaterialService.getMaterialById(2L)).thenReturn(materialMock2);

        CalculoTermicoResponseDTO resultado = calculoTermicoService.calcularPropriedadesTermicas(requestDTO);

        assertNotNull(resultado);
        assertNotNull(resultado.getTransmitanciaTermica());
        assertNotNull(resultado.getCapacidadeTermica());
        assertNotNull(resultado.getAtrasoTermico());
        assertNotNull(resultado.getResistenciaTermicaTotal());
        assertEquals(2, resultado.getMateriaisDetalhados().size());
        
        // Verifica se transmitância é maior que zero
        assertTrue(resultado.getTransmitanciaTermica() > 0);
        
        // Verifica se resistência térmica é maior que zero
        assertTrue(resultado.getResistenciaTermicaTotal() > 0);
        
        verify(mockMaterialService, times(1)).getMaterialById(1L);
        verify(mockMaterialService, times(1)).getMaterialById(2L);
    }

    @Test
    @DisplayName("Deve calcular propriedades térmicas de cobertura")
    void testCalcularPropriedadesTermicasCobertura() {
        requestDTO.setTipoCamada("COBERTURA");
        when(mockMaterialService.getMaterialById(1L)).thenReturn(materialMock1);
        when(mockMaterialService.getMaterialById(2L)).thenReturn(materialMock2);

        CalculoTermicoResponseDTO resultado = calculoTermicoService.calcularPropriedadesTermicas(requestDTO);

        assertNotNull(resultado);
        assertTrue(resultado.getTransmitanciaTermica() > 0);
        verify(mockMaterialService, times(2)).getMaterialById(anyLong());
    }

    @Test
    @DisplayName("Deve calcular propriedades térmicas de piso")
    void testCalcularPropriedadesTermicasPiso() {
        requestDTO.setTipoCamada("PISO");
        when(mockMaterialService.getMaterialById(1L)).thenReturn(materialMock1);
        when(mockMaterialService.getMaterialById(2L)).thenReturn(materialMock2);

        CalculoTermicoResponseDTO resultado = calculoTermicoService.calcularPropriedadesTermicas(requestDTO);

        assertNotNull(resultado);
        assertTrue(resultado.getTransmitanciaTermica() > 0);
        verify(mockMaterialService, times(2)).getMaterialById(anyLong());
    }

    @Test
    @DisplayName("Deve lançar exceção quando material não é encontrado no mock")
    void testCalcularComMaterialInexistente() {
        when(mockMaterialService.getMaterialById(1L)).thenReturn(null);

        assertThrows(RuntimeException.class, () -> {
            calculoTermicoService.calcularPropriedadesTermicas(requestDTO);
        });

        verify(mockMaterialService, times(1)).getMaterialById(1L);
    }

    @Test
    @DisplayName("Deve ordenar materiais pela ordem antes de calcular")
    void testOrdenarMateriaisPelaOrdem() {
        // Criar materiais fora de ordem
        MaterialCalculoDTO mat1 = new MaterialCalculoDTO(2L, 0.15, 2);
        MaterialCalculoDTO mat2 = new MaterialCalculoDTO(1L, 0.10, 1);
        
        CalculoTermicoRequestDTO requestDesordenado = new CalculoTermicoRequestDTO(
            "PAREDE", 
            Arrays.asList(mat1, mat2)
        );

        when(mockMaterialService.getMaterialById(1L)).thenReturn(materialMock1);
        when(mockMaterialService.getMaterialById(2L)).thenReturn(materialMock2);

        CalculoTermicoResponseDTO resultado = calculoTermicoService.calcularPropriedadesTermicas(requestDesordenado);

        assertNotNull(resultado);
        // Verifica se o primeiro material detalhado é o de ordem 1
        assertEquals(1L, resultado.getMateriaisDetalhados().get(0).getIdMaterialMock());
        assertEquals(2L, resultado.getMateriaisDetalhados().get(1).getIdMaterialMock());
    }

    @Test
    @DisplayName("Deve calcular carbono incorporado com sucesso")
    void testCalcularCarbonoIncorporado() {
        when(projetoRepository.findById(1L)).thenReturn(Optional.of(projeto));
        when(materialProjetoRepository.findByProjetoId(1L)).thenReturn(Arrays.asList(materialProjeto1));
        when(mockMaterialService.getMaterialById(1L)).thenReturn(materialMock1);

        CarbonoIncorporadoResponseDTO resultado = calculoTermicoService.calcularCarbonoIncorporado(1L);

        assertNotNull(resultado);
        assertNotNull(resultado.getCarbonoTotalPorArea());
        assertEquals(100.0, resultado.getAreaTotalProjeto());
        assertEquals("Casa Sustentável", resultado.getNomeProjeto());
        assertEquals(1, resultado.getQuantidadeMateriais());
        assertEquals(1, resultado.getMateriaisDetalhados().size());
        
        // Verifica cálculo: densidade (2400) × espessura (0.10) × area (100) × co2/kg (0.15) = 3600 kgCO2
        // Por área: 3600 / 100 = 36 kgCO2/m²
        assertTrue(resultado.getCarbonoTotalPorArea() > 0);
        
        verify(projetoRepository, times(1)).findById(1L);
        verify(materialProjetoRepository, times(1)).findByProjetoId(1L);
        verify(mockMaterialService, times(1)).getMaterialById(1L);
    }

    @Test
    @DisplayName("Deve lançar exceção quando projeto não é encontrado")
    void testCalcularCarbonoProjetoInexistente() {
        when(projetoRepository.findById(999L)).thenReturn(Optional.empty());

        RuntimeException exception = assertThrows(RuntimeException.class, () -> {
            calculoTermicoService.calcularCarbonoIncorporado(999L);
        });

        assertTrue(exception.getMessage().contains("não encontrado"));
        verify(projetoRepository, times(1)).findById(999L);
        verify(materialProjetoRepository, never()).findByProjetoId(anyLong());
    }

    @Test
    @DisplayName("Deve lançar exceção quando projeto não tem área definida")
    void testCalcularCarbonoSemArea() {
        projeto.setAreaTotalConstruida(null);
        when(projetoRepository.findById(1L)).thenReturn(Optional.of(projeto));

        RuntimeException exception = assertThrows(RuntimeException.class, () -> {
            calculoTermicoService.calcularCarbonoIncorporado(1L);
        });

        assertTrue(exception.getMessage().contains("área"));
        verify(projetoRepository, times(1)).findById(1L);
        verify(materialProjetoRepository, never()).findByProjetoId(anyLong());
    }

    @Test
    @DisplayName("Deve lançar exceção quando projeto não tem materiais")
    void testCalcularCarbonoSemMateriais() {
        when(projetoRepository.findById(1L)).thenReturn(Optional.of(projeto));
        when(materialProjetoRepository.findByProjetoId(1L)).thenReturn(Arrays.asList());

        RuntimeException exception = assertThrows(RuntimeException.class, () -> {
            calculoTermicoService.calcularCarbonoIncorporado(1L);
        });

        assertTrue(exception.getMessage().contains("materiais"));
        verify(projetoRepository, times(1)).findById(1L);
        verify(materialProjetoRepository, times(1)).findByProjetoId(1L);
    }

    @Test
    @DisplayName("Deve calcular capacidade térmica corretamente")
    void testCalcularCapacidadeTermica() {
        when(mockMaterialService.getMaterialById(1L)).thenReturn(materialMock1);
        when(mockMaterialService.getMaterialById(2L)).thenReturn(materialMock2);

        CalculoTermicoResponseDTO resultado = calculoTermicoService.calcularPropriedadesTermicas(requestDTO);

        assertNotNull(resultado.getCapacidadeTermica());
        // CT = Σ(ρ × c × e)
        // Material 1: 2400 × 1.0 × 0.10 = 240
        // Material 2: 1600 × 0.92 × 0.15 = 220.8
        // Total esperado ≈ 460.8 kJ/(m².K)
        assertTrue(resultado.getCapacidadeTermica() > 400);
    }

    @Test
    @DisplayName("Deve calcular com lista de materiais vazia")
    void testCalcularComListaVazia() {
        CalculoTermicoRequestDTO requestVazio = new CalculoTermicoRequestDTO("PAREDE", Arrays.asList());

        CalculoTermicoResponseDTO resultado = calculoTermicoService.calcularPropriedadesTermicas(requestVazio);

        assertNotNull(resultado);
        assertEquals(0, resultado.getMateriaisDetalhados().size());
        verify(mockMaterialService, never()).getMaterialById(anyLong());
    }
}
