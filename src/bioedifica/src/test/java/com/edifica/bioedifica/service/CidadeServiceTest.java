package com.edifica.bioedifica.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.edifica.bioedifica.dto.cidade.CidadeDTO;
import com.edifica.bioedifica.dto.cidade.EstadoDTO;
import com.edifica.bioedifica.model.Cidade;
import com.edifica.bioedifica.model.Estado;
import com.edifica.bioedifica.repository.CidadeRepository;
import com.edifica.bioedifica.repository.EstadoRepository;
import com.edifica.bioedifica.service.serviceImpl.CidadeService;

/**
 * Testes unitários para CidadeService
 * Testa as operações de CRUD de cidades
 */
@ExtendWith(MockitoExtension.class)
class CidadeServiceTest {

    @Mock
    private CidadeRepository cidadeRepository;

    @Mock
    private EstadoRepository estadoRepository;

    @InjectMocks
    private CidadeService cidadeService;

    private CidadeDTO cidadeDTO;
    private Cidade cidade;
    private Estado estado;

    @BeforeEach
    void setUp() {
        estado = new Estado();
        estado.setId(1L);
        estado.setUf("MG");
        estado.setNome("Minas Gerais");

        EstadoDTO estadoDTO = EstadoDTO.builder()
            .id(1L)
            .uf("MG")
            .nome("Minas Gerais")
            .build();

        cidadeDTO = CidadeDTO.builder()
            .id(1L)
            .nome("Belo Horizonte")
            .estado(estadoDTO)
            .build();

        cidade = new Cidade();
        cidade.setId(1L);
        cidade.setNome("Belo Horizonte");
        cidade.setEstado(estado);
    }

    @Test
    @DisplayName("Deve salvar cidade com sucesso")
    void testSalvarCidade() {
        when(cidadeRepository.save(any(Cidade.class))).thenReturn(cidade);

        CidadeDTO resultado = cidadeService.salvar(cidadeDTO);

        assertNotNull(resultado);
        assertEquals("Belo Horizonte", resultado.getNome());
        verify(cidadeRepository, times(1)).save(any(Cidade.class));
    }

    @Test
    @DisplayName("Deve listar todas as cidades")
    void testListarTodasCidades() {
        Cidade cidade2 = new Cidade();
        cidade2.setId(2L);
        cidade2.setNome("São Paulo");
        cidade2.setEstado(estado);

        when(cidadeRepository.findAll()).thenReturn(Arrays.asList(cidade, cidade2));

        List<CidadeDTO> resultado = cidadeService.listarTodos();

        assertNotNull(resultado);
        assertEquals(2, resultado.size());
        assertEquals("Belo Horizonte", resultado.get(0).getNome());
        verify(cidadeRepository, times(1)).findAll();
    }

    @Test
    @DisplayName("Deve buscar cidade por ID")
    void testBuscarCidadePorId() {
        when(cidadeRepository.findById(1L)).thenReturn(Optional.of(cidade));

        Optional<CidadeDTO> resultado = cidadeService.buscarPorId(1L);

        assertTrue(resultado.isPresent());
        assertEquals("Belo Horizonte", resultado.get().getNome());
        verify(cidadeRepository, times(1)).findById(1L);
    }

    @Test
    @DisplayName("Deve retornar vazio quando cidade não existe")
    void testBuscarCidadeInexistente() {
        when(cidadeRepository.findById(999L)).thenReturn(Optional.empty());

        Optional<CidadeDTO> resultado = cidadeService.buscarPorId(999L);

        assertFalse(resultado.isPresent());
        verify(cidadeRepository, times(1)).findById(999L);
    }

    @Test
    @DisplayName("Deve deletar cidade")
    void testDeletarCidade() {
        when(cidadeRepository.existsById(1L)).thenReturn(true);
        doNothing().when(cidadeRepository).deleteById(1L);

        assertDoesNotThrow(() -> cidadeService.deletar(1L));
        verify(cidadeRepository, times(1)).existsById(1L);
        verify(cidadeRepository, times(1)).deleteById(1L);
    }
}
