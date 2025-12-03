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

import com.edifica.bioedifica.dto.UsuarioDTO;
import com.edifica.bioedifica.dto.usuario.UsuarioCadastroDTO;
import com.edifica.bioedifica.enums.usuario.RoleUsuario;
import com.edifica.bioedifica.exception.EmailJaCadastradoException;
import com.edifica.bioedifica.model.Usuario;
import com.edifica.bioedifica.repository.UsuarioRepository;
import com.edifica.bioedifica.service.serviceImpl.UsuarioService;

/**
 * Testes unitários para UsuarioService
 * Testa as operações de CRUD e autenticação de usuários
 */
@ExtendWith(MockitoExtension.class)
class UsuarioServiceTest {

    @Mock
    private UsuarioRepository usuarioRepository;

    @InjectMocks
    private UsuarioService usuarioService;

    private UsuarioCadastroDTO usuarioCadastroDTO;
    private Usuario usuario;
    private UsuarioDTO usuarioDTO;

    @BeforeEach
    void setUp() {
        usuarioCadastroDTO = new UsuarioCadastroDTO(
            "João Silva",
            "joao@email.com",
            "senha123",
            RoleUsuario.ADMIN
        );

        usuario = new Usuario();
        usuario.setId(1L);
        usuario.setNome("João Silva");
        usuario.setEmail("joao@email.com");
        usuario.setSenha("senha123");
        usuario.setPerfil(RoleUsuario.ADMIN);

        usuarioDTO = new UsuarioDTO(
            1L,
            "João Silva",
            "joao@email.com",
            RoleUsuario.ADMIN,
            "senha123"
        );
    }

    @Test
    @DisplayName("Deve salvar usuário com sucesso")
    void testSalvarUsuario() {
        when(usuarioRepository.existsByEmail("joao@email.com")).thenReturn(false);
        when(usuarioRepository.save(any(Usuario.class))).thenReturn(usuario);

        UsuarioDTO resultado = usuarioService.salvar(usuarioCadastroDTO);

        assertNotNull(resultado);
        assertEquals("João Silva", resultado.nome());
        assertEquals("joao@email.com", resultado.email());
        assertEquals(RoleUsuario.ADMIN, resultado.perfil());
        verify(usuarioRepository, times(1)).existsByEmail("joao@email.com");
        verify(usuarioRepository, times(1)).save(any(Usuario.class));
    }

    @Test
    @DisplayName("Deve lançar exceção ao salvar usuário com email já cadastrado")
    void testSalvarUsuarioEmailDuplicado() {
        when(usuarioRepository.existsByEmail("joao@email.com")).thenReturn(true);

        assertThrows(EmailJaCadastradoException.class, () -> {
            usuarioService.salvar(usuarioCadastroDTO);
        });

        verify(usuarioRepository, times(1)).existsByEmail("joao@email.com");
        verify(usuarioRepository, never()).save(any(Usuario.class));
    }

    @Test
    @DisplayName("Deve listar todos os usuários")
    void testListarTodosUsuarios() {
        Usuario usuario2 = new Usuario();
        usuario2.setId(2L);
        usuario2.setNome("Maria Santos");
        usuario2.setEmail("maria@email.com");

        when(usuarioRepository.findAll()).thenReturn(Arrays.asList(usuario, usuario2));

        List<UsuarioDTO> resultado = usuarioService.listarTodos();

        assertNotNull(resultado);
        assertEquals(2, resultado.size());
        assertEquals("João Silva", resultado.get(0).nome());
        assertEquals("Maria Santos", resultado.get(1).nome());
        verify(usuarioRepository, times(1)).findAll();
    }

    @Test
    @DisplayName("Deve buscar usuário por ID")
    void testBuscarUsuarioPorId() {
        when(usuarioRepository.findById(1L)).thenReturn(Optional.of(usuario));

        Optional<UsuarioDTO> resultado = usuarioService.buscarPorId(1L);

        assertTrue(resultado.isPresent());
        assertEquals("João Silva", resultado.get().nome());
        assertEquals("joao@email.com", resultado.get().email());
        verify(usuarioRepository, times(1)).findById(1L);
    }

    @Test
    @DisplayName("Deve retornar vazio quando usuário não existe")
    void testBuscarUsuarioInexistente() {
        when(usuarioRepository.findById(999L)).thenReturn(Optional.empty());

        Optional<UsuarioDTO> resultado = usuarioService.buscarPorId(999L);

        assertFalse(resultado.isPresent());
        verify(usuarioRepository, times(1)).findById(999L);
    }

    @Test
    @DisplayName("Deve buscar usuário por username (email)")
    void testBuscarPorUsername() {
        when(usuarioRepository.findAll()).thenReturn(Arrays.asList(usuario));

        Optional<UsuarioDTO> resultado = usuarioService.buscarPorUsername("joao@email.com");

        assertTrue(resultado.isPresent());
        assertEquals("João Silva", resultado.get().nome());
        assertEquals("joao@email.com", resultado.get().email());
        verify(usuarioRepository, times(1)).findAll();
    }

    @Test
    @DisplayName("Deve autenticar usuário com credenciais válidas")
    void testAutenticarUsuarioValido() {
        when(usuarioRepository.findAll()).thenReturn(Arrays.asList(usuario));

        boolean resultado = usuarioService.autenticar("joao@email.com", "senha123");

        assertTrue(resultado);
        verify(usuarioRepository, times(1)).findAll();
    }

    @Test
    @DisplayName("Não deve autenticar usuário com senha inválida")
    void testAutenticarSenhaInvalida() {
        when(usuarioRepository.findAll()).thenReturn(Arrays.asList(usuario));

        boolean resultado = usuarioService.autenticar("joao@email.com", "senhaErrada");

        assertFalse(resultado);
        verify(usuarioRepository, times(1)).findAll();
    }

    @Test
    @DisplayName("Não deve autenticar usuário inexistente")
    void testAutenticarUsuarioInexistente() {
        when(usuarioRepository.findAll()).thenReturn(Arrays.asList(usuario));

        boolean resultado = usuarioService.autenticar("inexistente@email.com", "senha123");

        assertFalse(resultado);
        verify(usuarioRepository, times(1)).findAll();
    }

    @Test
    @DisplayName("Deve atualizar usuário com sucesso")
    void testAtualizarUsuario() {
        UsuarioDTO usuarioAtualizado = new UsuarioDTO(
            1L,
            "João Silva Atualizado",
            "joao@email.com",
            RoleUsuario.ADMIN,
            "novaSenha123"
        );

        when(usuarioRepository.findById(1L)).thenReturn(Optional.of(usuario));
        when(usuarioRepository.save(any(Usuario.class))).thenReturn(usuario);

        UsuarioDTO resultado = usuarioService.atualizar(1L, usuarioAtualizado);

        assertNotNull(resultado);
        verify(usuarioRepository, times(1)).findById(1L);
        verify(usuarioRepository, times(1)).save(any(Usuario.class));
    }

    @Test
    @DisplayName("Deve lançar exceção ao atualizar usuário inexistente")
    void testAtualizarUsuarioInexistente() {
        when(usuarioRepository.findById(999L)).thenReturn(Optional.empty());

        assertThrows(RuntimeException.class, () -> {
            usuarioService.atualizar(999L, usuarioDTO);
        });

        verify(usuarioRepository, times(1)).findById(999L);
        verify(usuarioRepository, never()).save(any(Usuario.class));
    }

    @Test
    @DisplayName("Deve deletar usuário")
    void testDeletarUsuario() {
        doNothing().when(usuarioRepository).deleteById(1L);

        assertDoesNotThrow(() -> usuarioService.deletar(1L));
        verify(usuarioRepository, times(1)).deleteById(1L);
    }
}
