package com.edifica.bioedifica.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.edifica.bioedifica.model.MaterialProjeto;

public interface MaterialProjetoRepository extends JpaRepository<MaterialProjeto, Long> {
  List<MaterialProjeto> findByProjetoId(Long idProjeto);
}
