package com.edifica.bioedifica.service.serviceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.edifica.bioedifica.dto.CalculoTermicoRequestDTO;
import com.edifica.bioedifica.dto.CalculoTermicoResponseDTO;
import com.edifica.bioedifica.dto.MaterialCalculoDTO;
import com.edifica.bioedifica.dto.camada.CamadaResponseDTO;
import com.edifica.bioedifica.dto.camada.CriarCamadaComCalculoDTO;
import com.edifica.bioedifica.dto.material.MaterialDTO;
import com.edifica.bioedifica.model.CalculoTermico;
import com.edifica.bioedifica.model.Camada;
import com.edifica.bioedifica.model.Composicao;
import com.edifica.bioedifica.model.MaterialProjeto;
import com.edifica.bioedifica.model.Projeto;
import com.edifica.bioedifica.repository.CamadaRepository;
import com.edifica.bioedifica.repository.ComposicaoRepository;
import com.edifica.bioedifica.repository.MaterialProjetoRepository;
import com.edifica.bioedifica.repository.ProjetoRepository;
import com.edifica.bioedifica.service.ICalculoTermicoService;
import com.edifica.bioedifica.service.ICamadaService;
import com.edifica.bioedifica.service.IMockMaterialService;

/**
 * Implementação do serviço de Camada
 */
@Service
public class CamadaService implements ICamadaService {

    private final CamadaRepository camadaRepository;
    private final ProjetoRepository projetoRepository;
    private final MaterialProjetoRepository materialProjetoRepository;
    private final ComposicaoRepository composicaoRepository;
    private final IMockMaterialService mockMaterialService;
    private final ICalculoTermicoService calculoTermicoService;

    public CamadaService(CamadaRepository camadaRepository,
                        ProjetoRepository projetoRepository,
                        MaterialProjetoRepository materialProjetoRepository,
                        ComposicaoRepository composicaoRepository,
                        IMockMaterialService mockMaterialService,
                        ICalculoTermicoService calculoTermicoService) {
        this.camadaRepository = camadaRepository;
        this.projetoRepository = projetoRepository;
        this.materialProjetoRepository = materialProjetoRepository;
        this.composicaoRepository = composicaoRepository;
        this.mockMaterialService = mockMaterialService;
        this.calculoTermicoService = calculoTermicoService;
    }

    @Override
    @Transactional
    public CamadaResponseDTO criarCamadaComCalculo(CriarCamadaComCalculoDTO dto) {
        // 1. Validar projeto
        Projeto projeto = projetoRepository.findById(dto.projetoId())
            .orElseThrow(() -> new RuntimeException("Projeto não encontrado: " + dto.projetoId()));

        // 2. Calcular propriedades térmicas
        CalculoTermicoRequestDTO calculoRequest = new CalculoTermicoRequestDTO();
        calculoRequest.setTipoCamada(dto.tipoCamada().name());
        
        List<MaterialCalculoDTO> materiaisCalculo = dto.materiais().stream()
            .map(m -> new MaterialCalculoDTO(
                m.idMaterialMock(),
                m.espessura(),
                m.ordem()
            ))
            .collect(Collectors.toList());
        
        calculoRequest.setMateriais(materiaisCalculo);
        
        CalculoTermicoResponseDTO calculoResponse = calculoTermicoService.calcularPropriedadesTermicas(calculoRequest);

        // 3. Criar a camada com cálculo
        Camada camada = new Camada();
        camada.setNome(dto.nome());
        camada.setTipoCamada(dto.tipoCamada());
        camada.setProjeto(projeto);
        
        CalculoTermico calculoTermico = new CalculoTermico(
            calculoResponse.getTransmitanciaTermica(),
            calculoResponse.getCapacidadeTermica(),
            calculoResponse.getAtrasoTermico()
        );
        camada.setCalculoTermico(calculoTermico);
        
        camada = camadaRepository.save(camada);

        // 4. Criar MaterialProjeto e Composicao para cada material
        List<MaterialProjeto> materiaisProjeto = new ArrayList<>();
        List<Composicao> composicoes = new ArrayList<>();
        
        for (CriarCamadaComCalculoDTO.MaterialCamadaDTO matDTO : dto.materiais()) {
            // Buscar dados do material no mock
            MaterialDTO materialMock = mockMaterialService.getMaterialById(matDTO.idMaterialMock());
            
            // Criar MaterialProjeto
            MaterialProjeto materialProjeto = new MaterialProjeto();
            materialProjeto.setProjeto(projeto);
            materialProjeto.setIdMaterialExterno(matDTO.idMaterialMock());
            materialProjeto.setNomeMaterial(materialMock.materialName());
            materialProjeto.setDensidade(materialMock.density());
            materialProjeto.setCalorEspecifico(materialMock.calorEspecifico());
            materialProjeto.setCondutividadeTermica(materialMock.condutividadeTermica());
            materialProjeto.setEspessura(matDTO.espessura());
            materialProjeto.setTipoAplicacao(dto.tipoCamada().name());
            materialProjeto.setCamada(camada);
            
            materialProjeto = materialProjetoRepository.save(materialProjeto);
            materiaisProjeto.add(materialProjeto);
            
            // Criar Composicao
            Composicao composicao = new Composicao(camada, materialProjeto, matDTO.ordem());
            composicao.setCamada(camada);
            composicao.setMaterialProjeto(materialProjeto);
            composicao.setEspessura(matDTO.espessura());
            composicao.setOrdem(matDTO.ordem());
            
            composicoes.add(composicaoRepository.save(composicao));
        }

        // 5. Retornar DTO de resposta
        return converterParaDTO(camada, materiaisProjeto, composicoes);
    }

    @Override
    public List<CamadaResponseDTO> listarCamadasPorProjeto(Long projetoId) {
        List<Camada> camadas = camadaRepository.findByProjetoId(projetoId);
        
        return camadas.stream()
            .map(camada -> {
                List<Composicao> composicoes = composicaoRepository.findByCamadaIdOrderByOrdemAsc(camada.getId());
                List<MaterialProjeto> materiais = composicoes.stream()
                    .map(Composicao::getMaterialProjeto)
                    .collect(Collectors.toList());
                
                return converterParaDTO(camada, materiais, composicoes);
            })
            .collect(Collectors.toList());
    }

    @Override
    public CamadaResponseDTO buscarCamadaPorId(Long camadaId) {
        Camada camada = camadaRepository.findById(camadaId)
            .orElseThrow(() -> new RuntimeException("Camada não encontrada: " + camadaId));
        
        List<Composicao> composicoes = composicaoRepository.findByCamadaIdOrderByOrdemAsc(camadaId);
        List<MaterialProjeto> materiais = composicoes.stream()
            .map(Composicao::getMaterialProjeto)
            .collect(Collectors.toList());
        
        return converterParaDTO(camada, materiais, composicoes);
    }

    @Override
    @Transactional
    public void excluirCamada(Long camadaId) {
        Camada camada = camadaRepository.findById(camadaId)
            .orElseThrow(() -> new RuntimeException("Camada não encontrada: " + camadaId));
        
        // O cascade ALL na relação OneToMany já vai deletar as composições
        // Precisamos deletar os MaterialProjeto manualmente
        List<Composicao> composicoes = composicaoRepository.findByCamadaIdOrderByOrdemAsc(camadaId);
        List<Long> materialProjetoIds = composicoes.stream()
            .map(c -> c.getMaterialProjeto().getId())
            .collect(Collectors.toList());
        
        // Deletar a camada (cascade deleta composições)
        camadaRepository.delete(camada);
        
        // Deletar os materiais do projeto
        materialProjetoIds.forEach(materialProjetoRepository::deleteById);
    }

    private CamadaResponseDTO converterParaDTO(Camada camada, List<MaterialProjeto> materiais, List<Composicao> composicoes) {
        // Mapear composições por material para pegar a ordem
        Map<Long, Integer> ordemPorMaterial = composicoes.stream()
            .collect(Collectors.toMap(
                c -> c.getMaterialProjeto().getId(),
                Composicao::getOrdem
            ));
        
        List<CamadaResponseDTO.MaterialCamadaResponseDTO> materiaisDTO = materiais.stream()
            .map(mat -> new CamadaResponseDTO.MaterialCamadaResponseDTO(
                mat.getId(),
                mat.getIdMaterialExterno(),
                mat.getNomeMaterial(),
                mat.getEspessura(),
                ordemPorMaterial.get(mat.getId()),
                mat.getDensidade(),
                mat.getCalorEspecifico(),
                mat.getCondutividadeTermica()
            ))
            .sorted((a, b) -> a.ordem().compareTo(b.ordem()))
            .collect(Collectors.toList());
        
        return new CamadaResponseDTO(
            camada.getId(),
            camada.getNome(),
            camada.getTipoCamada(),
            camada.getProjeto().getId(),
            materiaisDTO,
            camada.getCalculoTermico()
        );
    }
}
