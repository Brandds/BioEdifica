package com.edifica.bioedifica.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.util.ReflectionTestUtils;

import com.edifica.bioedifica.dto.projeto.ProjetoDTO;
import com.edifica.bioedifica.dto.projeto.ProjetoDetalhadoDTO;
import com.edifica.bioedifica.model.Cidade;
import com.edifica.bioedifica.model.Estado;
import com.edifica.bioedifica.model.Projeto;
import com.edifica.bioedifica.model.Usuario;
import com.edifica.bioedifica.repository.CidadeRepository;
import com.edifica.bioedifica.repository.MaterialProjetoRepository;
import com.edifica.bioedifica.repository.ProjetoRepository;
import com.edifica.bioedifica.repository.UsuarioRepository;
import com.edifica.bioedifica.service.serviceImpl.MockMaterialService;
import com.edifica.bioedifica.service.serviceImpl.ProjetoService;

/**
 * Testes unitários para ProjetoService
 * Testa as operações de CRUD de projetos de edificação
 */
@ExtendWith(MockitoExtension.class)
class ProjetoServiceTest {

    @Mock
    private ProjetoRepository projetoRepository;

    @Mock
    private UsuarioRepository usuarioRepository;

    @Mock
    private CidadeRepository cidadeRepository;

    @Mock
    private MaterialProjetoRepository materialProjetoRepository;

    @Mock
    private MockMaterialService mockMaterialService;

    private ProjetoService projetoService;

    private ProjetoDTO projetoDTO;
    private Projeto projeto;
    private Usuario usuario;
    private Cidade cidade;
    private Estado estado;

    @BeforeEach
    void setUp() {
        // Criar o service manualmente passando o ProjetoRepository no construtor
        projetoService = new ProjetoService(projetoRepository);
        
        // Injetar as outras dependências usando ReflectionTestUtils
        ReflectionTestUtils.setField(projetoService, "cidadeRepository", cidadeRepository);
        ReflectionTestUtils.setField(projetoService, "mockMaterialService", mockMaterialService);
        
        usuario = new Usuario();
        usuario.setId(1L);
        usuario.setNome("João Silva");

        estado = new Estado();
        estado.setId(1L);
        estado.setUf("MG");
        estado.setNome("Minas Gerais");

        cidade = new Cidade();
        cidade.setId(1L);
        cidade.setNome("Belo Horizonte");
        cidade.setEstado(estado);

        projetoDTO = new ProjetoDTO(
            1L,
            "Residencial Jardim",
            "Casa sustentável com materiais ecológicos",
            1L,
            1L,
            150.0
        );

        projeto = new Projeto();
        projeto.setId(1L);
        projeto.setNome("Residencial Jardim");
        projeto.setDescricao("Casa sustentável com materiais ecológicos");
        projeto.setUsuario(usuario);
        projeto.setCidade(cidade);
        projeto.setAreaTotalConstruida(150.0);
    }

    @Test
    @DisplayName("Deve criar projeto com sucesso")
    void testCriarProjeto() {
        when(cidadeRepository.findById(1L)).thenReturn(Optional.of(cidade));
        when(projetoRepository.save(any(Projeto.class))).thenReturn(projeto);

        ProjetoDetalhadoDTO resultado = projetoService.criarProjeto(projetoDTO);

        assertNotNull(resultado);
        assertEquals("Residencial Jardim", resultado.nome());
        assertEquals(150.0, resultado.areaTotalConstruida());
        verify(cidadeRepository, times(1)).findById(1L);
        verify(projetoRepository, times(1)).save(any(Projeto.class));
    }

    @Test
    @DisplayName("Deve buscar projeto por ID")
    void testBuscarProjetoPorId() {
        projeto.setMateriais(new ArrayList<>()); // Lista vazia de materiais
        when(projetoRepository.findById(1L)).thenReturn(Optional.of(projeto));
        when(mockMaterialService.getMaterialByProjeto(any())).thenReturn(new ArrayList<>());

        ProjetoDetalhadoDTO resultado = projetoService.getProjetoById(1L);

        assertNotNull(resultado);
        assertEquals("Residencial Jardim", resultado.nome());
        verify(projetoRepository, times(1)).findById(1L);
    }

    @Test
    @DisplayName("Deve listar projetos do usuário")
    void testListarProjetosDoUsuario() {
        Projeto projeto2 = new Projeto();
        projeto2.setId(2L);
        projeto2.setNome("Comercial Centro");
        projeto2.setUsuario(usuario);

        when(projetoRepository.findByUsuarioIdAndAtivo(1L, true)).thenReturn(Arrays.asList(projeto, projeto2));

        List<ProjetoDTO> resultado = projetoService.getProjetoByUsuario(1L);

        assertNotNull(resultado);
        assertEquals(2, resultado.size());
        assertEquals("Residencial Jardim", resultado.get(0).nome());
        verify(projetoRepository, times(1)).findByUsuarioIdAndAtivo(1L, true);
    }

    @Test
    @DisplayName("Deve lançar exceção quando projeto não existe")
    void testBuscarProjetoInexistente() {
        when(projetoRepository.findById(999L)).thenReturn(Optional.empty());

        assertThrows(org.springframework.web.server.ResponseStatusException.class, () -> {
            projetoService.getProjetoById(999L);
        });
        
        verify(projetoRepository, times(1)).findById(999L);
    }

    @Test
    @DisplayName("Deve deletar projeto")
    void testDeletarProjeto() {
        when(projetoRepository.findById(1L)).thenReturn(Optional.of(projeto));

        assertDoesNotThrow(() -> projetoService.deletarProjeto(1L, 1L));
        verify(projetoRepository, times(1)).findById(1L);
    }
}
