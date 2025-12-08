package com.edifica.bioedifica.service.serviceImpl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edifica.bioedifica.dto.AdicionarMaterialSimplificadoDTO;
import com.edifica.bioedifica.dto.CalculoTermicoRequestDTO;
import com.edifica.bioedifica.dto.CalculoTermicoResponseDTO;
import com.edifica.bioedifica.dto.MaterialCalculoDTO;
import com.edifica.bioedifica.dto.MaterialProjetoDTO;
import com.edifica.bioedifica.dto.material.MaterialDTO;
import com.edifica.bioedifica.dto.material.MaterialVisualizacaoDTO;
import com.edifica.bioedifica.model.CalculoTermico;
import com.edifica.bioedifica.model.Camada;
import com.edifica.bioedifica.model.Composicao;
import com.edifica.bioedifica.model.MaterialProjeto;
import com.edifica.bioedifica.model.Projeto;
import com.edifica.bioedifica.model.TipoCamada;
import com.edifica.bioedifica.repository.CamadaRepository;
import com.edifica.bioedifica.repository.ComposicaoRepository;
import com.edifica.bioedifica.repository.MaterialProjetoRepository;
import com.edifica.bioedifica.repository.ProjetoRepository;
import com.edifica.bioedifica.service.ICalculoTermicoService;
import com.edifica.bioedifica.service.IMaterialProjetoService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MaterialProjetoService implements IMaterialProjetoService {

    @Autowired
    private MaterialProjetoRepository materialProjetoRepository;
    @Autowired
    private ProjetoRepository projetoRepository;
    @Autowired
    private CamadaRepository camadaRepository;
    @Autowired
    private ComposicaoRepository composicaoRepository;
    @Autowired
    private MockMaterialService mockMaterialService;
    @Autowired
    private ICalculoTermicoService calculoTermicoService;
    
    @Override
    public List<MaterialVisualizacaoDTO> buscarMateriaisPorProjeto(Long projetoId) {
        List<MaterialProjeto> materiais = materialProjetoRepository.findByProjetoId(projetoId);
        return materiais.stream()
            .map(this::convertToVisualizacaoDTO)
            .collect(Collectors.toList());
    }
    
    @Override
    public MaterialProjetoDTO adicionarMaterialAoProjeto(Long projetoId, MaterialProjetoDTO materialDTO) {
        Projeto projeto = projetoRepository.findById(projetoId)
            .orElseThrow(() -> new RuntimeException("Projeto não encontrado"));

        MaterialProjeto material = new MaterialProjeto(
            projeto,
            materialDTO.getIdMaterialExterno(),
            materialDTO.getDensidade(),
            materialDTO.getCalorEspecifico(),
            materialDTO.getCondutividadeTermica(),
            materialDTO.getEspessura(),
            materialDTO.getNomeMaterial(),
            materialDTO.getTipoAplicacao()
        );

        MaterialProjeto materialSalvo = materialProjetoRepository.save(material);
        return convertToDTO(materialSalvo);
    }

    @Override
    public List<MaterialProjetoDTO> adicionarMaterialDoMock(Long projetoId, AdicionarMaterialSimplificadoDTO dto) {
        try {
            System.out.println("=== MaterialProjetoService.adicionarMaterialDoMock ===");
            System.out.println("ProjetoId: " + projetoId);
            
            Projeto projeto = projetoRepository.findById(projetoId)
                .orElseThrow(() -> new RuntimeException("Projeto não encontrado"));
            
            System.out.println("Projeto encontrado: " + projeto.getId());
            
            // Criar a camada
            System.out.println("Criando camada - TipoCamada: " + dto.getTipoCamada());
            TipoCamada tipoCamada = TipoCamada.valueOf(dto.getTipoCamada());
            String nomeCamada = dto.getNomeCamada() != null && !dto.getNomeCamada().isEmpty() 
                ? dto.getNomeCamada() 
                : "Camada " + dto.getTipoCamada();
            
            System.out.println("Nome da camada: " + nomeCamada);
            
            Camada camada = new Camada(nomeCamada, tipoCamada, projeto);
            Camada camadaSalva = camadaRepository.save(camada);
            
            System.out.println("Camada salva com ID: " + camadaSalva.getId());
            
            // Criar os materiais associados à camada
            System.out.println("Criando " + dto.getMateriais().size() + " materiais...");
            List<MaterialProjeto> novosMateriais = dto.getMateriais().stream()
                .map(material -> {
                    System.out.println("Processando material ID: " + material.getIdMaterialMock() + ", espessura: " + material.getEspessura());
                    return criarMaterialProjeto(projeto, camadaSalva, material, dto.getTipoCamada());
                })
                .collect(Collectors.toList());
            
            System.out.println("Salvando materiais no banco...");
            List<MaterialProjeto> materiaisSalvos = materialProjetoRepository.saveAll(novosMateriais);
            System.out.println("Materiais salvos: " + materiaisSalvos.size());
            
            // Criar as composições (ordem dos materiais na camada)
            System.out.println("Criando composições...");
            for (int i = 0; i < materiaisSalvos.size(); i++) {
                MaterialProjeto materialProjeto = materiaisSalvos.get(i);
                Integer ordem = dto.getMateriais().get(i).getOrdem() != null 
                    ? dto.getMateriais().get(i).getOrdem() 
                    : (i + 1);
            Composicao composicao = new Composicao(camadaSalva, materialProjeto, ordem);
            composicaoRepository.save(composicao);
        }
        
        // Calcular propriedades térmicas da camada
        System.out.println("Calculando propriedades térmicas da camada...");
        try {
            CalculoTermicoRequestDTO calculoRequest = new CalculoTermicoRequestDTO();
            calculoRequest.setTipoCamada(dto.getTipoCamada());
            
            List<com.edifica.bioedifica.dto.MaterialCalculoDTO> materiaisCalculo = dto.getMateriais();
            calculoRequest.setMateriais(materiaisCalculo);
            
            CalculoTermicoResponseDTO calculoResponse = calculoTermicoService.calcularPropriedadesTermicas(calculoRequest);
            
            // Converter DTO para entidade (usando apenas os campos disponíveis)
            CalculoTermico calculoTermico = new CalculoTermico();
            calculoTermico.setTransmitanciaTermica(calculoResponse.getTransmitanciaTermica());
            calculoTermico.setCapacidadeTermica(calculoResponse.getCapacidadeTermica());
            calculoTermico.setAtrasoTermico(calculoResponse.getAtrasoTermico());
            
            camadaSalva.setCalculoTermico(calculoTermico);
            camadaRepository.save(camadaSalva);
            
            System.out.println("Propriedades térmicas calculadas com sucesso!");
            System.out.println("Transmitância: " + calculoTermico.getTransmitanciaTermica());
            System.out.println("Capacidade Térmica: " + calculoTermico.getCapacidadeTermica());
            System.out.println("Atraso Térmico: " + calculoTermico.getAtrasoTermico());
        } catch (Exception e) {
            System.err.println("Erro ao calcular propriedades térmicas: " + e.getMessage());
            e.printStackTrace();
            // Não falha a operação, apenas não salva o cálculo
        }
        
        System.out.println("=== Processo concluído com sucesso ===");
        
        return materiaisSalvos.stream()
            .map(this::convertToDTO)
            .collect(Collectors.toList());
                
        } catch (Exception e) {
            System.err.println("=== ERRO em MaterialProjetoService.adicionarMaterialDoMock ===");
            System.err.println("Tipo de erro: " + e.getClass().getName());
            System.err.println("Mensagem: " + e.getMessage());
            System.err.println("Stack trace:");
            e.printStackTrace();
            throw e;
        }
    }
    
    private MaterialProjeto criarMaterialProjeto(Projeto projeto, Camada camada, MaterialCalculoDTO materialCalculo, String tipoCamada) {
        try {
            System.out.println("Buscando material no mock com ID: " + materialCalculo.getIdMaterialMock());
            
            MaterialDTO materialDTO = mockMaterialService.getMaterialById(materialCalculo.getIdMaterialMock());
            
            if (materialDTO == null) {
                System.err.println("Material não encontrado no mock: " + materialCalculo.getIdMaterialMock());
                throw new RuntimeException("Material não encontrado: " + materialCalculo.getIdMaterialMock());
            }
            
            System.out.println("Material encontrado: " + materialDTO.materialName());
            System.out.println("Densidade: " + materialDTO.density());
            System.out.println("Calor Específico: " + materialDTO.calorEspecifico());
            System.out.println("Condutividade: " + materialDTO.condutividadeTermica());
            
            MaterialProjeto materialProjeto = new MaterialProjeto(
                projeto,
                materialCalculo.getIdMaterialMock(),
                materialDTO.density(),
                materialDTO.calorEspecifico(),
                materialDTO.condutividadeTermica(),
                materialCalculo.getEspessura(),
                materialDTO.materialName(),
                tipoCamada
            );
            
            // Associar a camada ao material
            materialProjeto.setCamada(camada);
            
            System.out.println("MaterialProjeto criado para: " + materialDTO.materialName());
            
            return materialProjeto;
            
        } catch (Exception e) {
            System.err.println("=== ERRO em criarMaterialProjeto ===");
            System.err.println("Material ID: " + materialCalculo.getIdMaterialMock());
            System.err.println("Erro: " + e.getMessage());
            e.printStackTrace();
            throw e;
        }
    }
    
    @Override
    public MaterialProjetoDTO atualizarMaterial(Long materialId, MaterialProjetoDTO materialDTO) {
        MaterialProjeto material = materialProjetoRepository.findById(materialId)
            .orElseThrow(() -> new RuntimeException("Material não encontrado"));

        material.setDensidade(materialDTO.getDensidade());
        material.setCalorEspecifico(materialDTO.getCalorEspecifico());
        material.setCondutividadeTermica(materialDTO.getCondutividadeTermica());
        material.setEspessura(materialDTO.getEspessura());
        material.setNomeMaterial(materialDTO.getNomeMaterial());
        material.setTipoAplicacao(materialDTO.getTipoAplicacao());
        material.setIdMaterialExterno(materialDTO.getIdMaterialExterno());

        MaterialProjeto materialAtualizado = materialProjetoRepository.save(material);
        return convertToDTO(materialAtualizado);
    }

    @Override
    public void removerMaterial(Long materialId) {
        if (!materialProjetoRepository.existsById(materialId)) {
            throw new RuntimeException("Material não encontrado");
        }
        materialProjetoRepository.deleteById(materialId);
    }

    private MaterialProjetoDTO convertToDTO(MaterialProjeto material) {
        return new MaterialProjetoDTO(
            material.getId(),
            material.getIdMaterialExterno(),
            material.getNomeMaterial(),
            material.getTipoAplicacao(),
            material.getDensidade(),
            material.getCalorEspecifico(),
            material.getCondutividadeTermica(),
            material.getEspessura()
        );
    }

    private MaterialVisualizacaoDTO convertToVisualizacaoDTO(MaterialProjeto material) {
        // Buscar informações completas do material no mock usando o idMaterialExterno
        String materialType = material.getIdMaterialExterno() != null 
            ? mockMaterialService.getMaterialType(material.getIdMaterialExterno()) 
            : null;
        String dataSourceUrl = material.getIdMaterialExterno() != null 
            ? mockMaterialService.getDataSourceUrl(material.getIdMaterialExterno()) 
            : null;
        String materialTypeFamily = material.getIdMaterialExterno() != null 
            ? mockMaterialService.getMaterialTypeFamily(material.getIdMaterialExterno()) 
            : null;

        return new MaterialVisualizacaoDTO(
            material.getId(),
            material.getNomeMaterial(),
            materialType,
            dataSourceUrl,
            material.getDensidade(),
            materialTypeFamily,
            material.getIdMaterialExterno()
        );
    }
}