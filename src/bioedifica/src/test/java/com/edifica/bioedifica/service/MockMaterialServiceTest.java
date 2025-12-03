package com.edifica.bioedifica.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.edifica.bioedifica.dto.FiltroDinamico;
import com.edifica.bioedifica.dto.material.MaterialCategoriaDTO;
import com.edifica.bioedifica.dto.material.MaterialDTO;
import com.edifica.bioedifica.dto.material.MaterialVisualizacaoDTO;
import com.edifica.bioedifica.mapper.MaterialMapper;
import com.edifica.bioedifica.service.serviceImpl.MockMaterialService;

/**
 * Testes unitários para MockMaterialService
 * Testa operações de leitura e filtro de materiais do arquivo JSON mock
 */
@ExtendWith(MockitoExtension.class)
class MockMaterialServiceTest {

    @Mock
    private MaterialMapper materialMapper;

    private MockMaterialService mockMaterialService;

    @BeforeEach
    void setUp() {
        mockMaterialService = new MockMaterialService(materialMapper);
    }

    @Test
    @DisplayName("Deve carregar todos os materiais do arquivo JSON")
    void testGetAllMaterials() {
        List<MaterialDTO> materiais = mockMaterialService.getAllMaterials();

        assertNotNull(materiais);
        assertFalse(materiais.isEmpty(), "Lista de materiais não deve estar vazia");
        
        // Verifica se os materiais têm dados básicos
        MaterialDTO primeiroMaterial = materiais.get(0);
        assertNotNull(primeiroMaterial.id());
        assertNotNull(primeiroMaterial.materialName());
    }

    @Test
    @DisplayName("Deve buscar material por ID existente")
    void testGetMaterialByIdExistente() {
        // Pega o primeiro material da lista para usar como referência
        List<MaterialDTO> todosMateriais = mockMaterialService.getAllMaterials();
        Long idExistente = todosMateriais.get(0).id();

        MaterialDTO resultado = mockMaterialService.getMaterialById(idExistente);

        assertNotNull(resultado);
        assertEquals(idExistente, resultado.id());
    }

    @Test
    @DisplayName("Deve retornar null quando material não existe")
    void testGetMaterialByIdInexistente() {
        MaterialDTO resultado = mockMaterialService.getMaterialById(999999L);

        assertNull(resultado);
    }

    @Test
    @DisplayName("Deve verificar se material existe")
    void testMaterialExists() {
        List<MaterialDTO> todosMateriais = mockMaterialService.getAllMaterials();
        Long idExistente = todosMateriais.get(0).id();

        boolean existe = mockMaterialService.materialExists(idExistente);
        boolean naoExiste = mockMaterialService.materialExists(999999L);

        assertTrue(existe);
        assertFalse(naoExiste);
    }

    @Test
    @DisplayName("Deve agrupar materiais por categoria")
    void testGetMaterialCategorias() {
        List<MaterialCategoriaDTO> categorias = mockMaterialService.getMaterialCategorias();

        assertNotNull(categorias);
        assertFalse(categorias.isEmpty(), "Deve retornar pelo menos uma categoria");
        
        // Verifica estrutura da primeira categoria
        MaterialCategoriaDTO primeiraCategoria = categorias.get(0);
        assertNotNull(primeiraCategoria.tipoMaterial());
        assertTrue(primeiraCategoria.quantidade() > 0, "Contagem deve ser maior que zero");
    }

    @Test
    @DisplayName("Deve buscar materiais do projeto por lista de IDs")
    void testGetMaterialByProjeto() {
        List<MaterialDTO> todosMateriais = mockMaterialService.getAllMaterials();
        Long id1 = todosMateriais.get(0).id();
        Long id2 = todosMateriais.size() > 1 ? todosMateriais.get(1).id() : id1;

        List<MaterialDTO> resultado = mockMaterialService.getMaterialByProjeto(Arrays.asList(id1, id2));

        assertNotNull(resultado);
        assertFalse(resultado.isEmpty());
        assertTrue(resultado.stream().anyMatch(m -> m.id().equals(id1)));
    }

    @Test
    @DisplayName("Deve retornar lista vazia quando nenhum ID corresponde")
    void testGetMaterialByProjetoListaVazia() {
        List<MaterialDTO> resultado = mockMaterialService.getMaterialByProjeto(Arrays.asList(999999L, 888888L));

        assertNotNull(resultado);
        assertTrue(resultado.isEmpty());
    }

    @Test
    @DisplayName("Deve filtrar materiais por tipo (materialType)")
    void testFiltrarMateriaisPorTipo() {
        // Pega um tipo existente da lista de materiais
        List<MaterialDTO> todosMateriais = mockMaterialService.getAllMaterials();
        String tipoExistente = todosMateriais.get(0).materialType();
        
        FiltroDinamico filtro = new FiltroDinamico("materialType", tipoExistente);
        List<MaterialDTO> resultado = mockMaterialService.filtrarMateriais(Arrays.asList(filtro));

        assertNotNull(resultado);
        // Verifica que todos os materiais retornados têm o tipo correto
        assertTrue(resultado.stream().allMatch(m -> 
            m.materialType() != null && m.materialType().equalsIgnoreCase(tipoExistente)
        ));
    }

    @Test
    @DisplayName("Deve retornar nome do material por ID")
    void testGetMaterialName() {
        List<MaterialDTO> todosMateriais = mockMaterialService.getAllMaterials();
        Long idExistente = todosMateriais.get(0).id();
        String nomeEsperado = todosMateriais.get(0).materialName();

        String nome = mockMaterialService.getMaterialName(idExistente);

        assertNotNull(nome);
        assertEquals(nomeEsperado, nome);
    }

    @Test
    @DisplayName("Deve retornar mensagem padrão quando material não existe")
    void testGetMaterialNameInexistente() {
        String nome = mockMaterialService.getMaterialName(999999L);

        assertEquals("Material desconhecido", nome);
    }

    @Test
    @DisplayName("Deve retornar densidade do material")
    void testGetMaterialDensity() {
        List<MaterialDTO> todosMateriais = mockMaterialService.getAllMaterials();
        MaterialDTO material = todosMateriais.stream()
            .filter(m -> m.density() != null)
            .findFirst()
            .orElse(null);
        
        if (material != null) {
            Double densidade = mockMaterialService.getMaterialDensity(material.id());
            assertNotNull(densidade);
            assertEquals(material.density(), densidade);
        }
    }

    @Test
    @DisplayName("Deve retornar tipo do material")
    void testGetMaterialType() {
        List<MaterialDTO> todosMateriais = mockMaterialService.getAllMaterials();
        Long idExistente = todosMateriais.get(0).id();
        String tipoEsperado = todosMateriais.get(0).materialType();

        String tipo = mockMaterialService.getMaterialType(idExistente);

        assertNotNull(tipo);
        assertEquals(tipoEsperado, tipo);
    }

    @Test
    @DisplayName("Deve determinar tipo de aplicação baseado no material")
    void testDetermineTipoAplicacao() {
        assertEquals("PAREDE", mockMaterialService.determineTipoAplicacao("concrete"));
        assertEquals("PAREDE", mockMaterialService.determineTipoAplicacao("brick"));
        assertEquals("PAREDE", mockMaterialService.determineTipoAplicacao("steel"));
        assertEquals("COBERTURA", mockMaterialService.determineTipoAplicacao("glass"));
        assertEquals("PAREDE", mockMaterialService.determineTipoAplicacao(null));
    }

    @Test
    @DisplayName("Deve retornar condutividade térmica para material e aplicação")
    void testGetCondutividadeTermica() {
        Double condutividadeConcreto = mockMaterialService.getCondutividadeTermica("concrete", "PAREDE");
        Double condutividadeTijolo = mockMaterialService.getCondutividadeTermica("brick", "PAREDE");
        
        assertNotNull(condutividadeConcreto);
        assertNotNull(condutividadeTijolo);
        assertEquals(1.75, condutividadeConcreto, 0.01);
        assertEquals(0.90, condutividadeTijolo, 0.01);
    }

    @Test
    @DisplayName("Deve retornar calor específico para material e aplicação")
    void testGetCalorEspecifico() {
        Double calorConcreto = mockMaterialService.getCalorEspecifico("concrete", "PAREDE");
        Double calorTijolo = mockMaterialService.getCalorEspecifico("brick", "PAREDE");
        
        assertNotNull(calorConcreto);
        assertNotNull(calorTijolo);
        assertEquals(1.00, calorConcreto, 0.01);
        assertEquals(0.92, calorTijolo, 0.01);
    }

    @Test
    @DisplayName("Deve retornar densidade para material e aplicação")
    void testGetDensidade() {
        Double densidadeConcreto = mockMaterialService.getDensidade("concrete", "PAREDE");
        Double densidadeTijolo = mockMaterialService.getDensidade("brick", "PAREDE");
        
        assertNotNull(densidadeConcreto);
        assertNotNull(densidadeTijolo);
        assertEquals(2400.0, densidadeConcreto, 0.1);
        assertEquals(1600.0, densidadeTijolo, 0.1);
    }

    @Test
    @DisplayName("Deve retornar data source URL do material")
    void testGetDataSourceUrl() {
        List<MaterialDTO> todosMateriais = mockMaterialService.getAllMaterials();
        MaterialDTO material = todosMateriais.stream()
            .filter(m -> m.dataSourceUrl() != null)
            .findFirst()
            .orElse(null);
        
        if (material != null) {
            String url = mockMaterialService.getDataSourceUrl(material.id());
            assertNotNull(url);
            assertEquals(material.dataSourceUrl(), url);
        }
    }

    @Test
    @DisplayName("Deve buscar materiais por categoria")
    void testGetMaterialsByCategory() {
        List<MaterialDTO> todosMateriais = mockMaterialService.getAllMaterials();
        String categoria = todosMateriais.get(0).materialType();
        
        when(materialMapper.toVisualizacaoDTOList(anyList())).thenReturn(Arrays.asList());

        List<MaterialVisualizacaoDTO> resultado = mockMaterialService.getMaterialsByCategory(categoria);

        assertNotNull(resultado);
        verify(materialMapper, times(1)).toVisualizacaoDTOList(anyList());
    }

    @Test
    @DisplayName("Deve buscar materiais por tipo de produto")
    void testGetMaterialsByTipoProduto() {
        List<MaterialDTO> todosMateriais = mockMaterialService.getAllMaterials();
        MaterialDTO materialComTipoProduto = todosMateriais.stream()
            .filter(m -> m.productType() != null)
            .findFirst()
            .orElse(null);
        
        if (materialComTipoProduto != null) {
            when(materialMapper.toVisualizacaoDTOList(anyList())).thenReturn(Arrays.asList());

            List<MaterialVisualizacaoDTO> resultado = mockMaterialService
                .getMaterialsBytipoProduto(materialComTipoProduto.productType());

            assertNotNull(resultado);
            verify(materialMapper, times(1)).toVisualizacaoDTOList(anyList());
        }
    }

    @Test
    @DisplayName("Deve buscar materiais por tipo de família")
    void testGetMaterialsByTipoFamilia() {
        List<MaterialDTO> todosMateriais = mockMaterialService.getAllMaterials();
        MaterialDTO materialComFamilia = todosMateriais.stream()
            .filter(m -> m.materialTypeFamily() != null)
            .findFirst()
            .orElse(null);
        
        if (materialComFamilia != null) {
            when(materialMapper.toVisualizacaoDTOList(anyList())).thenReturn(Arrays.asList());

            List<MaterialVisualizacaoDTO> resultado = mockMaterialService
                .getMaterialsByTipoFamilia(materialComFamilia.materialTypeFamily());

            assertNotNull(resultado);
            verify(materialMapper, times(1)).toVisualizacaoDTOList(anyList());
        }
    }

    @Test
    @DisplayName("Deve retornar valores padrão quando parâmetros são nulos")
    void testValoresPadraoComParametrosNulos() {
        Double condutividade = mockMaterialService.getCondutividadeTermica(null, null);
        Double calor = mockMaterialService.getCalorEspecifico(null, null);
        Double densidade = mockMaterialService.getDensidade(null, null);

        assertEquals(1.0, condutividade);
        assertEquals(1.0, calor);
        assertEquals(2000.0, densidade);
    }

    @Test
    @DisplayName("Deve filtrar com múltiplos critérios")
    void testFiltrarComMultiplosCriterios() {
        List<MaterialDTO> todosMateriais = mockMaterialService.getAllMaterials();
        MaterialDTO referencia = todosMateriais.get(0);
        
        FiltroDinamico filtro1 = new FiltroDinamico("materialType", referencia.materialType());
        FiltroDinamico filtro2 = new FiltroDinamico("materialName", referencia.materialName());

        List<MaterialDTO> resultado = mockMaterialService
            .filtrarMateriais(Arrays.asList(filtro1, filtro2));

        assertNotNull(resultado);
        // Se ambos os filtros correspondem, deve retornar pelo menos o material de referência
        assertTrue(resultado.stream().anyMatch(m -> 
            m.materialType().equals(referencia.materialType()) && 
            m.materialName().equals(referencia.materialName())
        ));
    }
}
