package com.edifica.bioedifica.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.edifica.bioedifica.dto.FiltroDinamico;
import com.edifica.bioedifica.dto.material.MaterialCategoriaDTO;
import com.edifica.bioedifica.dto.material.MaterialDTO;
import com.edifica.bioedifica.dto.material.MaterialVisualizacaoDTO;
import com.edifica.bioedifica.service.serviceImpl.MockMaterialService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;




@RestController
@RequestMapping("/api/mock-materials")
public class MockMaterialController {

    @Autowired
    private MockMaterialService mockMaterialService;

    @Operation(summary = "Obter todos os materiais", description = "Retorna uma lista de todos os materiais disponíveis.(JSON)")
    @GetMapping
    public List<MaterialDTO> getAllMaterials() {
        return mockMaterialService.getAllMaterials();
    }

    @Operation(summary = "Obter todas as categorias de materiais", description = "Retorna uma lista de todas as categorias de materiais disponíveis.")
    @GetMapping("/materialCategorias")
    public List<MaterialCategoriaDTO> getMaterialCategorias() {
        return mockMaterialService.getMaterialCategorias();
    }

    @Operation(
        summary = "Filtra materiais dinamicamente pelo campo e valor",
        description = "Recebe uma lista de filtros dinâmicos (campo, valor) e retorna os materiais que atendem aos critérios.",
        requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(
            required = true,
            content = @Content(
                schema = @Schema(implementation = FiltroDinamico.class),
                examples = {
                    @ExampleObject(
                        name = "Exemplo de filtro",
                        value = "[\n  {\n    \"campo\": \"materialType\",\n    \"valor\": \"Concrete\"\n  },\n  {\n    \"campo\": \"density\",\n    \"valor\": 2360\n  }\n]"
                    )
                }
            )
        ),
        responses = {
            @ApiResponse(
                responseCode = "200",
                description = "Lista de materiais filtrados",
                content = @Content(
                    mediaType = "application/json",
                    examples = {
                        @ExampleObject(
                            name = "Exemplo de resposta",
                            value = "[\n  {\n    \"id\": 323,\n    \"sourceUuid\": \"8207d167-0d67-497a-bd0a-6ee66a959482\",\n    \"materialName\": \"Concrete GEN 2 with 25% GGBS cement (per m3)\",\n    \"materialType\": \"Concrete\",\n    \"density\": 2360\n    // ...outros campos...\n  }\n]"
                        )
                    }
                )
            )
        }
    )
    @PostMapping("/filtrarMateriais")
    public List<MaterialDTO> filtrarMateriais(@RequestBody List<FiltroDinamico> filtros) {
        return mockMaterialService.filtrarMateriais(filtros);   
    }


    @Operation(summary = "Obter material pelo ID", description = "Retorna um material específico com base no ID fornecido.")
    @ApiResponse(responseCode = "200", description = "Material retornado com sucesso.", content = @Content(schema = @Schema(implementation = MaterialDTO.class)))
    @ApiResponse(responseCode = "404", description = "Material não encontrado.")
    @GetMapping("/getMaterialById/{id}")
    public org.springframework.http.ResponseEntity<MaterialDTO> getMaterialById(@Parameter(description = "ID do material", example = "1") @PathVariable Long id) {
        MaterialDTO material = mockMaterialService.getMaterialById(id);
        if (material == null) {
            return org.springframework.http.ResponseEntity.notFound().build();
        }
        return org.springframework.http.ResponseEntity.ok(material);
    }


    @Operation(summary = "Obter materiais por categoria", description = "Retorna uma lista simplificada de materiais pertencentes a uma categoria específica, contendo apenas informações essenciais para visualização.")
    @GetMapping("/getMaterialsByCategory/{category}")
    public List<MaterialVisualizacaoDTO> getMaterialsByCategory(@Parameter(description = "Categoria do material", example = "Concrete") @PathVariable String category) {
        return mockMaterialService.getMaterialsByCategory(category);
    }

    @Operation(summary = "Obter materiais por tipo produto", description = "Retorna uma lista simplificada de materiais pertencentes a um tipo de produto específica, contendo apenas informações essenciais para visualização.")
    @GetMapping("/getMaterialsBytipoProduto/{tipoProduto}")
    public List<MaterialVisualizacaoDTO> getMaterialsBytipoProduto(@Parameter(description = "Tipo de produto do material", example = "In situ") @PathVariable String tipoProduto) {
        return mockMaterialService.getMaterialsBytipoProduto(tipoProduto);
    }
}
