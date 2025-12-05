package com.edifica.bioedifica.dto.material;

import java.util.List;

import com.edifica.bioedifica.util.FlexibleListDeserializer;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import lombok.Builder;

@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
public record MaterialDTO(
    @JsonProperty("id") Long id,
    @JsonProperty("source_uuid") String sourceUuid,
    @JsonProperty("material_name") String materialName,
    @JsonProperty("group_elements_nrm_1") 
    @JsonDeserialize(using = FlexibleListDeserializer.class)
    List<String> groupElementsNrm1,
    @JsonProperty("elements_nrm_1") 
    @JsonDeserialize(using = FlexibleListDeserializer.class)
    List<String> elementsNrm1,
    @JsonProperty("product_type") String productType,
    @JsonProperty("product_type_family") 
    @JsonDeserialize(using = FlexibleListDeserializer.class)
    List<String> productTypeFamily,
    @JsonProperty("uniclass_systems") 
    @JsonDeserialize(using = FlexibleListDeserializer.class)
    List<String> uniclassSystems,
    @JsonProperty("uniclass_products") 
    @JsonDeserialize(using = FlexibleListDeserializer.class)
    List<String> uniclassProducts,
    @JsonProperty("uniclass_materials") 
    @JsonDeserialize(using = FlexibleListDeserializer.class)
    List<String> uniclassMaterials,
    @JsonProperty("material_type") String materialType,
    @JsonProperty("material_type_family") String materialTypeFamily,
    @JsonProperty("data_source") String dataSource,
    @JsonProperty("data_source_url") String dataSourceUrl,
    @JsonProperty("data_source_year") Integer dataSourceYear,
    @JsonProperty("data_source_country") String dataSourceCountry,
    @JsonProperty("functional_unit_quantity") String functionalUnitQuantity,
    @JsonProperty("functional_unit_unit") String functionalUnitUnit,
    @JsonProperty("total_co2e_kg_mf") Double totalCo2eKgMf,
    @JsonProperty("total_biogenic_co2e") Double totalBiogenicCo2e,
    @JsonProperty("carbon_a1a3") Double carbonA1a3,
    @JsonProperty("carbon_c1c4") Double carbonC1c4,
    @JsonProperty("density") Double density,
    @JsonProperty("density_estimated") Boolean densityEstimated,
    @JsonProperty("mass_per_piece") Double massPerPiece,
    @JsonProperty("mass_per_piece_estimated") Boolean massPerPieceEstimated,
    @JsonProperty("mass_per_declared_unit") Double massPerDeclaredUnit,
    @JsonProperty("mass_per_declared_unit_estimated") Boolean massPerDeclaredUnitEstimated,
    @JsonProperty("created") String created,
    @JsonProperty("updated") String updated,
    @JsonProperty("generic_api_url") String genericApiUrl,
    @JsonProperty("calor_especifico") Double calorEspecifico,
    @JsonProperty("condutividade_termica") Double condutividadeTermica,
    @JsonProperty("espessura") Double espessura
) {}
