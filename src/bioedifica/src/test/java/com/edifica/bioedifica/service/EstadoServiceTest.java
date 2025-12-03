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

import com.edifica.bioedifica.dto.cidade.EstadoDTO;
import com.edifica.bioedifica.model.Estado;
import com.edifica.bioedifica.repository.EstadoRepository;
import com.edifica.bioedifica.service.serviceImpl.EstadoService;

/**
 * Testes unitários para EstadoService
 * Testa as operações de CRUD de estados brasileiros
 */
@ExtendWith(MockitoExtension.class)
class EstadoServiceTest {

    @Mock
    private EstadoRepository estadoRepository;

    @InjectMocks
    private EstadoService estadoService;

    private EstadoDTO estadoDTO;
    private Estado estado;

    @BeforeEach
    void setUp() {
        estadoDTO = EstadoDTO.builder()
            .id(1L)
            .uf("MG")
            .nome("Minas Gerais")
            .build();

        estado = new Estado();
        estado.setId(1L);
        estado.setUf("MG");
        estado.setNome("Minas Gerais");
    }

    @Test
    @DisplayName("Deve salvar estado com sucesso")
    void testSalvarEstado() {
        when(estadoRepository.save(any(Estado.class))).thenReturn(estado);

        EstadoDTO resultado = estadoService.salvar(estadoDTO);

        assertNotNull(resultado);
        assertEquals("MG", resultado.getUf());
        assertEquals("Minas Gerais", resultado.getNome());
        verify(estadoRepository, times(1)).save(any(Estado.class));
    }

    @Test
    @DisplayName("Deve listar todos os estados")
    void testListarTodosEstados() {
        Estado estado2 = new Estado();
        estado2.setId(2L);
        estado2.setUf("SP");
        estado2.setNome("São Paulo");

        when(estadoRepository.findAll()).thenReturn(Arrays.asList(estado, estado2));

        List<EstadoDTO> resultado = estadoService.listarTodos();

        assertNotNull(resultado);
        assertEquals(2, resultado.size());
        assertEquals("MG", resultado.get(0).getUf());
        assertEquals("SP", resultado.get(1).getUf());
        verify(estadoRepository, times(1)).findAll();
    }

    @Test
    @DisplayName("Deve buscar estado por ID")
    void testBuscarEstadoPorId() {
        when(estadoRepository.findById(1L)).thenReturn(Optional.of(estado));

        Optional<EstadoDTO> resultado = estadoService.buscarPorId(1L);

        assertTrue(resultado.isPresent());
        assertEquals("MG", resultado.get().getUf());
        verify(estadoRepository, times(1)).findById(1L);
    }

    @Test
    @DisplayName("Deve retornar vazio quando estado não existe")
    void testBuscarEstadoInexistente() {
        when(estadoRepository.findById(999L)).thenReturn(Optional.empty());

        Optional<EstadoDTO> resultado = estadoService.buscarPorId(999L);

        assertFalse(resultado.isPresent());
        verify(estadoRepository, times(1)).findById(999L);
    }

    @Test
    @DisplayName("Deve buscar estado por UF")
    void testBuscarPorUf() {
        when(estadoRepository.findByUf("MG")).thenReturn(Optional.of(estado));

        Optional<EstadoDTO> resultado = estadoService.buscarPorUf("MG");

        assertTrue(resultado.isPresent());
        assertEquals("Minas Gerais", resultado.get().getNome());
        verify(estadoRepository, times(1)).findByUf("MG");
    }

    @Test
    @DisplayName("Deve verificar se estado existe por UF")
    void testExistePorUf() {
        when(estadoRepository.existsByUf("MG")).thenReturn(true);

        boolean resultado = estadoService.existePorUf("MG");

        assertTrue(resultado);
        verify(estadoRepository, times(1)).existsByUf("MG");
    }

    @Test
    @DisplayName("Deve deletar estado")
    void testDeletarEstado() {
        when(estadoRepository.existsById(1L)).thenReturn(true);
        doNothing().when(estadoRepository).deleteById(1L);

        assertDoesNotThrow(() -> estadoService.deletar(1L));
        verify(estadoRepository, times(1)).existsById(1L);
        verify(estadoRepository, times(1)).deleteById(1L);
    }
}
