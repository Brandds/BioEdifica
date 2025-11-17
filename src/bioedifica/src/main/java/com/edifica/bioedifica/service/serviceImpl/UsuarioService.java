package com.edifica.bioedifica.service.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edifica.bioedifica.dto.UsuarioDTO;
import com.edifica.bioedifica.dto.usuario.UsuarioCadastroDTO;
import com.edifica.bioedifica.exception.EmailJaCadastradoException;
import com.edifica.bioedifica.mapper.UsuarioMapper;
import com.edifica.bioedifica.repository.UsuarioRepository;
import com.edifica.bioedifica.service.IUsuarioService;

@Service("usuarioServiceImpl")
public class UsuarioService implements IUsuarioService {
    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
        public UsuarioDTO salvar(UsuarioCadastroDTO usuarioDTO) {
            if(usuarioRepository.existsByEmail(usuarioDTO.email())) {
                throw new EmailJaCadastradoException(usuarioDTO.email());
            }
            var usuario = UsuarioMapper.toEntity(usuarioDTO);
            var salvo = usuarioRepository.save(usuario);
            return UsuarioMapper.toDTO(salvo);
        }

    @Override
    public List<UsuarioDTO> listarTodos() {
        return usuarioRepository.findAll().stream()
            .map(UsuarioMapper::toDTO)
            .toList();
    }

    @Override
    public Optional<UsuarioDTO> buscarPorId(Long id) {
        return usuarioRepository.findById(id).map(UsuarioMapper::toDTO);
    }

    @Override
    public void deletar(Long id) {
        usuarioRepository.deleteById(id);
    }

    @Override
        public UsuarioDTO atualizar(Long id, UsuarioDTO usuarioAtualizado) {
            return usuarioRepository.findById(id)
                    .map(usuario -> {
                        UsuarioMapper.updateEntityFromDTO(usuario, usuarioAtualizado);
                        var atualizado = usuarioRepository.save(usuario);
                        return UsuarioMapper.toDTO(atualizado);
                    })
                    .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));
        }

    @Override
    public Optional<UsuarioDTO> buscarPorUsername(String username) {
        return usuarioRepository.findAll().stream()
            .filter(u -> u.getEmail().equals(username))
            .findFirst()
            .map(UsuarioMapper::toDTO);
    }

    @Override
    public boolean autenticar(String username, String senha) {
        return usuarioRepository.findAll().stream()
                .filter(u -> u.getEmail().equals(username) && u.getSenha().equals(senha))
                .findFirst()
                .isPresent();
    }
}
