package com.edifica.bioedifica.service.serviceImpl;

import java.io.InputStream;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.edifica.bioedifica.dto.FiltroDinamico;
import com.edifica.bioedifica.dto.material.MaterialCategoriaDTO;
import com.edifica.bioedifica.dto.material.MaterialDTO;
import com.edifica.bioedifica.dto.material.MaterialVisualizacaoDTO;
import com.edifica.bioedifica.mapper.MaterialMapper;
import com.edifica.bioedifica.service.IMockMaterialService;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class MockMaterialService implements IMockMaterialService {
    
    private final MaterialMapper materialMapper;

    public MockMaterialService(MaterialMapper materialMapper) {
        this.materialMapper = materialMapper;
    }
    private static final String MOCK_FILE = "/mock_generic_materials.json";

    public List<MaterialDTO> getAllMaterials() {
        try {
            ObjectMapper mapper = new ObjectMapper();
            InputStream is = getClass().getResourceAsStream(MOCK_FILE);
            if (is == null) {
                throw new RuntimeException("Arquivo mock_generic_materials.json não encontrado no classpath. Verifique se está em src/main/resources e foi copiado para target/classes.");
            }
            JsonNode root = mapper.readTree(is);
            JsonNode results = root.get("results");
            List<MaterialDTO> materials = new ArrayList<>();
            for (JsonNode node : results) {
                MaterialDTO dto = mapper.treeToValue(node, MaterialDTO.class);
                materials.add(dto);
            }
            return materials;
        } catch (Exception e) {
            throw new RuntimeException("Erro ao ler mock_generic_materials.json: " + e.getMessage(), e);
        }
    }

    @Override
    public List<MaterialCategoriaDTO> getMaterialCategorias() {
        var materiais = getAllMaterials();
        return agruparPorCategoria(materiais);
    }

    private List<MaterialCategoriaDTO> agruparPorCategoria(List<MaterialDTO> materiais) {
        var agrupandoPorCategoria = materiais.stream()
            .collect(java.util.stream.Collectors.groupingBy(MaterialDTO::materialType));
        return agrupandoPorCategoria.entrySet().stream()
            .map(entry -> {
                String tipo = entry.getKey();
                List<MaterialDTO> lista = entry.getValue();
                String dataSourceUrl = lista.get(0).dataSourceUrl();
                int count = lista.size();
                String tipoFamiliaMaterial = lista.get(0).groupElementsNrm1() != null && !lista.get(0).groupElementsNrm1().isEmpty()
                    ? lista.get(0).groupElementsNrm1().get(0)
                    : "Desconhecido";
                String tipoProduto = lista.get(0).productType() != null ? lista.get(0).productType() : "Desconhecido";
                return new MaterialCategoriaDTO(tipo, dataSourceUrl, count, tipoFamiliaMaterial, tipoProduto);
            })
            .toList();
    }

    @Override
    public List<MaterialDTO> filtrarMateriais(List<FiltroDinamico> filtros) {
        List<MaterialDTO> materiais = getAllMaterials();
        return materiais.stream()
            .filter(material -> {
                for (FiltroDinamico filtro : filtros) {
                    String campo = filtro.campo();
                    Object valor = filtro.valor();
                    try {
                        Method method = MaterialDTO.class.getMethod(campo);
                        Object campoValor = method.invoke(material);
                        if (campoValor == null || valor == null) return false;
                        if (campoValor instanceof Number && valor instanceof Number) {
                            double v1 = ((Number) campoValor).doubleValue();
                            double v2 = ((Number) valor).doubleValue();
                            if (Double.compare(v1, v2) != 0) return false;
                        } else {
                            if (!campoValor.toString().equalsIgnoreCase(valor.toString())) return false;
                        }
                    } catch (Exception e) {
                        return false;
                    }
                }
                return true;
            })
            .collect(java.util.stream.Collectors.toList());
    }

    @Override
    public List<MaterialDTO> getMaterialByProjeto(List<Long> idsMateriais) {
        var allMaterials = getAllMaterials();
        var materiaisDoProjeto = allMaterials.stream()
            .filter(m -> idsMateriais.contains(m.id()))
            .toList();
        return materiaisDoProjeto;
    }

    @Override
    public MaterialDTO getMaterialById(Long id) {
        var allMaterials = getAllMaterials();

        return allMaterials.stream()
            .filter(m -> m.id().equals(id))
            .findFirst()
            .orElse(null);
    }

    // Novos métodos para propriedades térmicas
    public String getMaterialName(Long id) {
        MaterialDTO material = getMaterialById(id);
        return material != null ? material.materialName() : "Material desconhecido";
    }

    public Double getMaterialDensity(Long id) {
        MaterialDTO material = getMaterialById(id);
        return material != null ? material.density() : null;
    }

    public String getMaterialType(Long id) {
        MaterialDTO material = getMaterialById(id);
        return material != null ? material.materialType() : "";
    }

    public String determineTipoAplicacao(String materialType) {
        if (materialType == null) return "PAREDE";
        
        return switch (materialType.toLowerCase()) {
            case "steel", "concrete", "brick", "stone" -> "PAREDE";
            case "glass", "polymer", "plastic" -> "COBERTURA";
            case "timber", "wood" -> "PAREDE";
            case "aluminium" -> "COBERTURA";
            default -> "PAREDE"; // Padrão
        };
    }

    public Double getCondutividadeTermica(String materialType, String tipoAplicacao) {
        if (materialType == null || tipoAplicacao == null) return 1.0;
        
        String key = materialType.toLowerCase() + "_" + tipoAplicacao.toLowerCase();
        
        // Valores da tabela ABNT (2005) - Condutividade térmica (W/m.K)
        return switch (key) {
            // PAREDES - Tabela A.1
            case "concrete_parede" -> 1.75; // Concreto (bloco e parede)
            case "brick_parede" -> 0.90; // Tijolo cerâmico
            case "steel_parede" -> 55.0; // Aço (valor típico para paredes)
            case "timber_parede", "wood_parede" -> 0.14; // Madeira para paredes
            
            // COBERTURAS - Tabela A.2
            case "concrete_cobertura" -> 1.75; // Concreto (laje)
            case "steel_cobertura" -> 55.0; // Telha metálica de aço
            case "timber_cobertura", "wood_cobertura" -> 0.96; // Madeira para cobertura
            case "glass_cobertura" -> 0.35; // Gesso
            case "plastic_cobertura", "polymer_cobertura" -> 0.20; // PVC
            case "aluminium_cobertura" -> 0.15; // Madeira (cobertura)
            
            // Materiais específicos por nome (argamassa, reboco, cerâmica)
            case "mortar_parede", "cement_parede" -> 1.15; // Argamassa de assentamento
            case "mortar_cobertura", "cement_cobertura" -> 1.15; // Argamassa de reboco
            case "ceramic_parede" -> 0.90; // Tijolo cerâmico
            case "ceramic_cobertura" -> 1.05; // Cerâmica
            case "plaster_parede" -> 1.15; // Reboco
            
            default -> 1.0; // Valor padrão
        };
    }

    public Double getCalorEspecifico(String materialType, String tipoAplicacao) {
        if (materialType == null || tipoAplicacao == null) return 1.0;
        
        String key = materialType.toLowerCase() + "_" + tipoAplicacao.toLowerCase();
        
        // Valores da tabela ABNT (2005) - Calor específico (J/kg.K)
        return switch (key) {
            // PAREDES - Tabela A.1
            case "concrete_parede" -> 1.00; // Concreto (bloco e parede)
            case "brick_parede" -> 0.92; // Tijolo cerâmico
            case "steel_parede" -> 0.46; // Aço
            case "timber_parede", "wood_parede" -> 1.34; // Madeira
            
            // COBERTURAS - Tabela A.2
            case "concrete_cobertura" -> 1.00; // Concreto (laje)
            case "steel_cobertura" -> 0.46; // Telha metálica de aço
            case "timber_cobertura", "wood_cobertura" -> 0.96; // Madeira (cobertura)
            case "glass_cobertura" -> 0.84; // Gesso
            case "plastic_cobertura", "polymer_cobertura" -> 1.34; // PVC
            case "aluminium_cobertura" -> 0.84; // Madeira (cobertura)
            
            // Materiais específicos por nome
            case "mortar_parede", "cement_parede" -> 1.00; // Argamassa de assentamento
            case "mortar_cobertura", "cement_cobertura" -> 1.00; // Argamassa de reboco
            case "ceramic_parede" -> 0.92; // Tijolo cerâmico
            case "ceramic_cobertura" -> 0.92; // Cerâmica
            case "plaster_parede" -> 1.00; // Reboco
            
            default -> 1.0; // Valor padrão
        };
    }

    public Double getDensidade(String materialType, String tipoAplicacao) {
        if (materialType == null || tipoAplicacao == null) return 2000.0;
        
        String key = materialType.toLowerCase() + "_" + tipoAplicacao.toLowerCase();
        
        // Valores da tabela ABNT (2005) - Densidade (kg/m³)
        return switch (key) {
            // PAREDES - Tabela A.1
            case "concrete_parede" -> 2400.0; // Concreto (bloco e parede)
            case "brick_parede" -> 1600.0; // Tijolo cerâmico
            case "steel_parede" -> 7800.0; // Aço
            case "timber_parede", "wood_parede" -> 600.0; // Madeira
            
            // COBERTURAS - Tabela A.2
            case "concrete_cobertura" -> 2200.0; // Concreto (laje)
            case "steel_cobertura" -> 7800.0; // Telha metálica de aço
            case "timber_cobertura", "wood_cobertura" -> 600.0; // Madeira
            case "glass_cobertura" -> 750.0; // Gesso
            case "plastic_cobertura", "polymer_cobertura" -> 1000.0; // PVC
            case "aluminium_cobertura" -> 600.0; // Madeira (cobertura)
            
            // Materiais específicos por nome
            case "mortar_parede", "cement_parede" -> 2000.0; // Argamassa de assentamento
            case "mortar_cobertura", "cement_cobertura" -> 2000.0; // Argamassa de reboco
            case "ceramic_parede" -> 1600.0; // Tijolo cerâmico
            case "ceramic_cobertura" -> 2000.0; // Cerâmica
            case "plaster_parede" -> 2000.0; // Reboco
            
            default -> 2000.0; // Valor padrão
        };
    }

    // Métodos de compatibilidade (deprecated - usar os novos métodos com tipoAplicacao)
    @Deprecated
    public Double getCondutividadeTermica(String materialType) {
        return getCondutividadeTermica(materialType, "PAREDE");
    }

    @Deprecated  
    public Double getCalorEspecifico(String materialType) {
        return getCalorEspecifico(materialType, "PAREDE");
    }

    public boolean materialExists(Long id) {
        return getMaterialById(id) != null;
    }

    public String getDataSourceUrl(Long id) {
        MaterialDTO material = getMaterialById(id);
        return material != null ? material.dataSourceUrl() : null;
    }

    public String getMaterialTypeFamily(Long id) {
        MaterialDTO material = getMaterialById(id);
        if (material != null && material.groupElementsNrm1() != null && !material.groupElementsNrm1().isEmpty()) {
            return material.groupElementsNrm1().get(0);
        }
        return "Desconhecido";
    }

    @Override
    public List<MaterialVisualizacaoDTO> getMaterialsByCategory(String category) {
        var allMaterials = getAllMaterials();
        var filteredMaterials = allMaterials.stream()
            .filter(m -> m.materialType() != null && m.materialType().equalsIgnoreCase(category))
            .toList();
        
        return materialMapper.toVisualizacaoDTOList(filteredMaterials);
    }

    @Override
    public List<MaterialVisualizacaoDTO> getMaterialsBytipoProduto(String tipoProduto) {
        var allMaterials = getAllMaterials();
        var filteredMaterials = allMaterials.stream()
            .filter(m -> m.productType() != null && m.productType().equalsIgnoreCase(tipoProduto))
            .toList();
        
        return materialMapper.toVisualizacaoDTOList(filteredMaterials);
    }
}