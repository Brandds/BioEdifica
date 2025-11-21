package com.edifica.bioedifica.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.edifica.bioedifica.enums.cidade.TipoCidade;
import com.edifica.bioedifica.model.Cidade;

@Repository
public interface CidadeRepository extends JpaRepository<Cidade, Long> {
    
    List<Cidade> findByTipo(TipoCidade tipo);
    
    List<Cidade> findByEstadoUf(String uf);
    
    List<Cidade> findByEstadoUfAndTipo(String uf, TipoCidade tipo);
    
    Optional<Cidade> findByNomeAndEstadoUf(String nome, String uf);
    
    List<Cidade> findByNomeContainingIgnoreCase(String nome);
    
    List<Cidade> findByNomeContainingIgnoreCaseAndTipo(String nome, TipoCidade tipo);
    
    @Query("SELECT c FROM Cidade c WHERE c.estado.uf = :uf AND c.nome LIKE %:nome%")
    List<Cidade> findByUfAndNomeContaining(@Param("uf") String uf, @Param("nome") String nome);
    
    List<Cidade> findByEstadoUfAndNomeContainingIgnoreCaseAndTipo(String uf, String nome, TipoCidade tipo);
    
    boolean existsByNomeAndEstadoUf(String nome, String uf);
    
    List<Cidade> findByUsuarioCriadorId(Long usuarioCriadorId);
    
    @Query("SELECT c FROM Cidade c WHERE c.tipo = :tipoOficial OR c.usuarioCriador.id = :usuarioId")
    List<Cidade> findByTipoOrUsuarioCriador(@Param("tipoOficial") TipoCidade tipoOficial, @Param("usuarioId") Long usuarioId);
}