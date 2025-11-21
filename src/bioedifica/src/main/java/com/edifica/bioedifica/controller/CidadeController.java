package com.edifica.bioedifica.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.edifica.bioedifica.dto.cidade.CidadeDTO;
import com.edifica.bioedifica.dto.cidade.CidadeUsuarioDTO;
import com.edifica.bioedifica.service.ICidadeService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/api/cidades")
@CrossOrigin(origins = "*")
@Tag(name = "Cidade", description = "API para gerenciamento de cidades brasileiras")
public class CidadeController {
    
    @Autowired
    private ICidadeService cidadeService;

    @PostMapping("/usuario/{usuarioId}")
    @Operation(summary = "Criar cidade personalizada", description = "Permite ao usuário criar uma cidade personalizada")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "201", description = "Cidade personalizada criada com sucesso"),
        @ApiResponse(responseCode = "400", description = "Dados inválidos"),
        @ApiResponse(responseCode = "409", description = "Cidade já existe para este usuário")
    })
    public ResponseEntity<CidadeDTO> criarCidadeUsuario(
            @PathVariable @Parameter(description = "ID do usuário") Long usuarioId,
            @RequestBody @Parameter(
                description = "Dados da cidade personalizada",
                examples = {
                    @ExampleObject(
                        name = "Cidade simples",
                        description = "Exemplo básico de cidade personalizada apenas com nome e estado",
                        value = """
                            {
                              "nome": "Nova Vila Sustentável",
                              "estadoId": 2
                            }
                            """
                    ),
                    @ExampleObject(
                        name = "Cidade com zoneamento completo",
                        description = "Exemplo completo com dados de zoneamento bioclimático",
                        value = """
                            {
                              "nome": "EcoVila dos Ipês",
                              "estadoId": 2,
                              "zoneamentoBioclimatico": {
                                "zonaBioclimatica": "3B",
                                "latitude": -19.9167,
                                "longitude": -43.9345,
                                "altitude": 852,
                                "temperaturaBulboSeco": 21.1,
                                "umidadeRelativa": 70.5,
                                "radiacaoHorizontalGlobal": 4650.0,
                                "velocidadeVento": 2.1,
                                "amplitudeTermica": 9.1
                              }
                            }
                            """
                    )
                }
            ) CidadeUsuarioDTO cidadeUsuarioDTO) {
        var cidadeCriada = cidadeService.criarCidadeUsuario(usuarioId, cidadeUsuarioDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(cidadeCriada);
    }

    @GetMapping("/usuario/{usuarioId}")
    @Operation(summary = "Listar cidades do usuário", description = "Retorna todas as cidades criadas por um usuário específico")
    @ApiResponse(responseCode = "200", description = "Lista de cidades do usuário retornada com sucesso")
    public ResponseEntity<List<CidadeDTO>> listarCidadesDoUsuario(
            @PathVariable @Parameter(description = "ID do usuário") Long usuarioId) {
        var cidades = cidadeService.buscarPorUsuarioCriador(usuarioId);
        return ResponseEntity.ok(cidades);
    }

    @PostMapping
    @Operation(summary = "Criar nova cidade", description = "Cria uma nova cidade no sistema")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "201", description = "Cidade criada com sucesso"),
        @ApiResponse(responseCode = "400", description = "Dados inválidos")
    })
    public ResponseEntity<CidadeDTO> criarCidade(
            @RequestBody @Parameter(description = "Dados da cidade a ser criada") CidadeDTO cidadeDTO) {
        var cidadeCriada = cidadeService.salvar(cidadeDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(cidadeCriada);
    }

    @GetMapping
    @Operation(summary = "Listar todas as cidades", description = "Retorna todas as cidades cadastradas, filtrando por tipo (padrão: OFICIAL) e opcionalmente incluindo cidades do usuário")
    @ApiResponse(responseCode = "200", description = "Lista de cidades retornada com sucesso")
    public ResponseEntity<List<CidadeDTO>> listarTodos(
            @RequestParam(required = false, defaultValue = "OFICIAL") 
            @Parameter(description = "Tipo de cidade (OFICIAL ou USUARIO)") String tipo,
            @RequestParam(required = false)
            @Parameter(description = "ID do usuário para incluir suas cidades personalizadas") Long usuarioId) {
        var tipoCidade = com.edifica.bioedifica.enums.cidade.TipoCidade.valueOf(tipo.toUpperCase());
        var cidades = cidadeService.listarPorTipo(tipoCidade, usuarioId);
        return ResponseEntity.ok(cidades);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Buscar cidade por ID", description = "Retorna uma cidade específica pelo ID")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Cidade encontrada"),
        @ApiResponse(responseCode = "404", description = "Cidade não encontrada")
    })
    public ResponseEntity<CidadeDTO> buscarPorId(
            @PathVariable @Parameter(description = "ID da cidade") Long id) {
        return cidadeService.buscarPorId(id)
                .map(cidade -> ResponseEntity.ok(cidade))
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/uf/{uf}")
    @Operation(summary = "Buscar cidades por UF", description = "Retorna todas as cidades de um estado espec\u00edfico, filtrando por tipo (padr\u00e3o: OFICIAL)")
    @ApiResponse(responseCode = "200", description = "Lista de cidades retornada com sucesso")
    public ResponseEntity<List<CidadeDTO>> buscarPorUf(
            @PathVariable @Parameter(description = "Sigla UF do estado") String uf,
            @RequestParam(required = false, defaultValue = "OFICIAL") 
            @Parameter(description = "Tipo de cidade (OFICIAL ou USUARIO)") String tipo) {
        var tipoCidade = com.edifica.bioedifica.enums.cidade.TipoCidade.valueOf(tipo.toUpperCase());
        var cidades = cidadeService.buscarPorUfETipo(uf, tipoCidade);
        return ResponseEntity.ok(cidades);
    }

    @GetMapping("/buscar")
    @Operation(summary = "Buscar cidade por nome e UF", description = "Retorna uma cidade específica pelo nome e UF")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Cidade encontrada"),
        @ApiResponse(responseCode = "404", description = "Cidade não encontrada")
    })
    public ResponseEntity<CidadeDTO> buscarPorNomeEUf(
            @RequestParam @Parameter(description = "Nome da cidade") String nome,
            @RequestParam @Parameter(description = "Sigla UF do estado") String uf) {
        return cidadeService.buscarPorNomeEUf(nome, uf)
                .map(cidade -> ResponseEntity.ok(cidade))
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/buscar-nome")
    @Operation(summary = "Buscar cidades por nome", description = "Retorna cidades que contenham o nome informado, filtrando por tipo (padr\u00e3o: OFICIAL)")
    @ApiResponse(responseCode = "200", description = "Lista de cidades retornada com sucesso")
    public ResponseEntity<List<CidadeDTO>> buscarPorNome(
            @RequestParam @Parameter(description = "Nome ou parte do nome da cidade") String nome,
            @RequestParam(required = false, defaultValue = "OFICIAL") 
            @Parameter(description = "Tipo de cidade (OFICIAL ou USUARIO)") String tipo) {
        var tipoCidade = com.edifica.bioedifica.enums.cidade.TipoCidade.valueOf(tipo.toUpperCase());
        var cidades = cidadeService.buscarPorNomeETipo(nome, tipoCidade);
        return ResponseEntity.ok(cidades);
    }

    @GetMapping("/buscar-uf-nome")
    @Operation(summary = "Buscar cidades por UF e nome", description = "Retorna cidades de um estado que contenham o nome informado, filtrando por tipo (padr\u00e3o: OFICIAL)")
    @ApiResponse(responseCode = "200", description = "Lista de cidades retornada com sucesso")
    public ResponseEntity<List<CidadeDTO>> buscarPorUfENome(
            @RequestParam @Parameter(description = "Sigla UF do estado") String uf,
            @RequestParam @Parameter(description = "Nome ou parte do nome da cidade") String nome,
            @RequestParam(required = false, defaultValue = "OFICIAL") 
            @Parameter(description = "Tipo de cidade (OFICIAL ou USUARIO)") String tipo) {
        var tipoCidade = com.edifica.bioedifica.enums.cidade.TipoCidade.valueOf(tipo.toUpperCase());
        var cidades = cidadeService.buscarPorUfENomeETipo(uf, nome, tipoCidade);
        return ResponseEntity.ok(cidades);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Atualizar cidade", description = "Atualiza os dados de uma cidade existente")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Cidade atualizada com sucesso"),
        @ApiResponse(responseCode = "404", description = "Cidade não encontrada"),
        @ApiResponse(responseCode = "400", description = "Dados inválidos")
    })
    public ResponseEntity<CidadeDTO> atualizarCidade(
            @PathVariable @Parameter(description = "ID da cidade") Long id,
            @RequestBody @Parameter(description = "Novos dados da cidade") CidadeDTO cidadeDTO) {
        var cidadeAtualizada = cidadeService.atualizar(id, cidadeDTO);
        return ResponseEntity.ok(cidadeAtualizada);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Deletar cidade", description = "Remove uma cidade do sistema")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "204", description = "Cidade deletada com sucesso"),
        @ApiResponse(responseCode = "404", description = "Cidade não encontrada")
    })
    public ResponseEntity<Void> deletarCidade(
            @PathVariable @Parameter(description = "ID da cidade") Long id) {
        cidadeService.deletar(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/existe")
    @Operation(summary = "Verificar se cidade existe", description = "Verifica se já existe uma cidade com o nome e UF informados")
    @ApiResponse(responseCode = "200", description = "Resultado da verificação retornado")
    public ResponseEntity<Boolean> existePorNomeEUf(
            @RequestParam @Parameter(description = "Nome da cidade") String nome,
            @RequestParam @Parameter(description = "Sigla UF do estado") String uf) {
        boolean existe = cidadeService.existePorNomeEUf(nome, uf);
        return ResponseEntity.ok(existe);
    }
}