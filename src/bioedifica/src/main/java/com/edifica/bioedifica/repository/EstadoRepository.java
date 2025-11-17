package com.edifica.bioedifica.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.edifica.bioedifica.model.Estado;

@Repository
public interface EstadoRepository extends JpaRepository<Estado, Long> {
    
    Optional<Estado> findByUf(String uf);
    
    List<Estado> findByNomeContainingIgnoreCase(String nome);
    
    boolean existsByUf(String uf);
}