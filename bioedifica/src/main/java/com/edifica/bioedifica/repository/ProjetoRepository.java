package com.edifica.bioedifica.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.edifica.bioedifica.model.Projeto;

@Repository
public interface ProjetoRepository extends JpaRepository<Projeto, Long> {
  List<Projeto> findByUsuarioIdAndAtivo(Long usuarioId, boolean ativo);
}
