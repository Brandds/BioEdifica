package com.edifica.bioedifica.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.edifica.bioedifica.dto.AdicionarMaterialSimplificadoDTO;
import com.edifica.bioedifica.dto.MaterialProjetoDTO;
import com.edifica.bioedifica.service.IMaterialProjetoService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;



@RestController
@RequestMapping("/api/materialProjeto")
@Tag(name = "Material Projeto", description = "Gerenciamento dos materiais associados aos projetos")
public class MaterialProjetoController {
  
  @Autowired
  private IMaterialProjetoService materialProjetoService;


  // ==========================================
  // ENDPOINTS PARA PROPRIEDADES TÉRMICAS
  // ==========================================

  @Operation(
      summary = "Buscar materiais de um projeto com propriedades térmicas", 
      description = "Retorna todos os materiais associados a um projeto específico com suas propriedades térmicas"
  )
  @GetMapping("/propriedades-termicas/projeto/{projetoId}")
  public ResponseEntity<List<MaterialProjetoDTO>> buscarMateriaisComPropriedadesTermicas(
          @Parameter(description = "ID do projeto", required = true)
          @PathVariable Long projetoId) {
      try {
          List<MaterialProjetoDTO> materiais = materialProjetoService.buscarMateriaisPorProjeto(projetoId);
          return ResponseEntity.ok(materiais);
      } catch (Exception e) {
          return ResponseEntity.badRequest().build();
      }
  }

  @Operation(
      summary = "Adicionar material do catálogo ao projeto", 
      description = "Adiciona um material do catálogo ao projeto usando apenas ID e espessura. Propriedades térmicas e tipo são obtidos automaticamente do catálogo baseado no material_type."
  )
  @PostMapping("/propriedades-termicas/do-catalogo/{projetoId}")
  public ResponseEntity<MaterialProjetoDTO> adicionarMaterialDoCatalogo(
          @Parameter(description = "ID do projeto", required = true)
          @PathVariable Long projetoId,
          @RequestBody AdicionarMaterialSimplificadoDTO materialDTO) {
      try {
          MaterialProjetoDTO materialSalvo = materialProjetoService.adicionarMaterialDoMock(
              projetoId, 
              materialDTO.getIdMaterialExterno(), 
              materialDTO.getEspessura()
          );
          return ResponseEntity.status(HttpStatus.CREATED).body(materialSalvo);
      } catch (Exception e) {
          return ResponseEntity.badRequest().build();
      }
  }

  @Operation(
      summary = "Adicionar material com propriedades térmicas customizadas", 
      description = "Adiciona um material com propriedades térmicas definidas manualmente"
  )
  @PostMapping("/propriedades-termicas/customizado/{projetoId}")
  public ResponseEntity<MaterialProjetoDTO> adicionarMaterialCustomizado(
          @Parameter(description = "ID do projeto", required = true)
          @PathVariable Long projetoId,
          @RequestBody MaterialProjetoDTO materialDTO) {
      try {
          MaterialProjetoDTO materialSalvo = materialProjetoService.adicionarMaterialAoProjeto(projetoId, materialDTO);
          return ResponseEntity.status(HttpStatus.CREATED).body(materialSalvo);
      } catch (Exception e) {
          return ResponseEntity.badRequest().build();
      }
  }

  @Operation(
      summary = "Atualizar propriedades térmicas do material", 
      description = "Atualiza as propriedades térmicas de um material existente"
  )
  @PutMapping("/propriedades-termicas/{materialId}")
  public ResponseEntity<MaterialProjetoDTO> atualizarPropriedadesTermicas(
          @Parameter(description = "ID do material", required = true)
          @PathVariable Long materialId,
          @RequestBody MaterialProjetoDTO materialDTO) {
      try {
          MaterialProjetoDTO materialAtualizado = materialProjetoService.atualizarMaterial(materialId, materialDTO);
          return ResponseEntity.ok(materialAtualizado);
      } catch (Exception e) {
          return ResponseEntity.badRequest().build();
      }
  }

  @Operation(
      summary = "Remover material do projeto", 
      description = "Remove um material de um projeto"
  )
  @DeleteMapping("/propriedades-termicas/{materialId}")
  public ResponseEntity<Void> removerMaterialDoProjeto(
          @Parameter(description = "ID do material", required = true)
          @PathVariable Long materialId) {
      try {
          materialProjetoService.removerMaterial(materialId);
          return ResponseEntity.noContent().build();
      } catch (Exception e) {
          return ResponseEntity.badRequest().build();
      }
  }
  

}
