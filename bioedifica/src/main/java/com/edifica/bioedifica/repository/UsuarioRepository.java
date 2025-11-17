package com.edifica.bioedifica.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.edifica.bioedifica.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
	Optional<Usuario> findByEmail(String email);
	boolean existsByEmail(String email);
}
