package com.edifica.bioedifica.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.edifica.bioedifica.model.Camada;

@Repository
public interface CamadaRepository extends JpaRepository<Camada, Long> {
    
    List<Camada> findByProjetoId(Long projetoId);
}
