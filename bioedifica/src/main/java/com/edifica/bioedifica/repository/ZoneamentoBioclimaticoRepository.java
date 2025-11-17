package com.edifica.bioedifica.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.edifica.bioedifica.model.ZoneamentoBioclimatico;

@Repository
public interface ZoneamentoBioclimaticoRepository extends JpaRepository<ZoneamentoBioclimatico, Long> {
    
    @Query("SELECT z FROM ZoneamentoBioclimatico z JOIN z.cidade c WHERE c.estado.uf = :uf")
    List<ZoneamentoBioclimatico> findByUf(@Param("uf") String uf);
    
    @Query("SELECT z FROM ZoneamentoBioclimatico z JOIN z.cidade c WHERE c.nome = :nomeCidade AND c.estado.uf = :uf")
    Optional<ZoneamentoBioclimatico> findByNomeCidadeAndUf(@Param("nomeCidade") String nomeCidade, @Param("uf") String uf);
    
    List<ZoneamentoBioclimatico> findByZonaBioclimatica(String zonaBioclimatica);
    
    @Query("SELECT z FROM ZoneamentoBioclimatico z JOIN z.cidade c WHERE c.nome LIKE %:nomeCidade%")
    List<ZoneamentoBioclimatico> findByCidadeNomeContaining(@Param("nomeCidade") String nomeCidade);
    
    Optional<ZoneamentoBioclimatico> findByCidadeId(Long cidadeId);
}