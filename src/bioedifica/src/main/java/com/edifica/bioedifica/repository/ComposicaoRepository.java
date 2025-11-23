package com.edifica.bioedifica.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.edifica.bioedifica.model.Composicao;

@Repository
public interface ComposicaoRepository extends JpaRepository<Composicao, Long> {
    
    List<Composicao> findByCamadaIdOrderByOrdemAsc(Long camadaId);
}
