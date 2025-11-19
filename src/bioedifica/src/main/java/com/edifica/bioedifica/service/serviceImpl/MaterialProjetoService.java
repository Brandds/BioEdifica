package com.edifica.bioedifica.service.serviceImpl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.edifica.bioedifica.dto.MaterialProjetoDTO;
import com.edifica.bioedifica.dto.material.MaterialVisualizacaoDTO;
import com.edifica.bioedifica.model.MaterialProjeto;
import com.edifica.bioedifica.model.Projeto;
import com.edifica.bioedifica.repository.MaterialProjetoRepository;
import com.edifica.bioedifica.repository.ProjetoRepository;
import com.edifica.bioedifica.service.IMaterialProjetoService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MaterialProjetoService implements IMaterialProjetoService {

    private final MaterialProjetoRepository materialProjetoRepository;
    private final ProjetoRepository projetoRepository;
    private final MockMaterialService mockMaterialService;

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
    public MaterialProjetoDTO adicionarMaterialDoMock(Long projetoId, Long idMaterialExterno, Double espessura) {
        Projeto projeto = projetoRepository.findById(projetoId)
            .orElseThrow(() -> new RuntimeException("Projeto não encontrado"));

        // Verificar se o material existe no mock
        if (!mockMaterialService.materialExists(idMaterialExterno)) {
            throw new RuntimeException("Material não encontrado no catálogo");
        }

        // Obter dados do material do mock
        String nomeMaterial = mockMaterialService.getMaterialName(idMaterialExterno);
        Double densidade = mockMaterialService.getMaterialDensity(idMaterialExterno);
        String materialType = mockMaterialService.getMaterialType(idMaterialExterno);
        
        // Determinar tipo de aplicação baseado no material_type
        String tipoAplicacao = mockMaterialService.determineTipoAplicacao(materialType);
        
        // Obter propriedades térmicas baseadas no material_type e tipo de aplicação
        Double condutividadeTermica = mockMaterialService.getCondutividadeTermica(materialType, tipoAplicacao);
        Double calorEspecifico = mockMaterialService.getCalorEspecifico(materialType, tipoAplicacao);
        // Obter densidade também da tabela ABNT
        densidade = mockMaterialService.getDensidade(materialType, tipoAplicacao);

        MaterialProjeto material = new MaterialProjeto(
            projeto,
            idMaterialExterno,
            densidade,
            calorEspecifico,
            condutividadeTermica,
            espessura,
            nomeMaterial,
            tipoAplicacao
        );

        MaterialProjeto materialSalvo = materialProjetoRepository.save(material);
        return convertToDTO(materialSalvo);
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