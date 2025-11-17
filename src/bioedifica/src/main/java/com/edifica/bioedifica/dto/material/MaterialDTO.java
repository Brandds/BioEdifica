package com.edifica.bioedifica.dto.material;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public record MaterialDTO(
    @JsonProperty("id") Long id,
    @JsonProperty("source_uuid") String sourceUuid,
    @JsonProperty("material_name") String materialName,
    @JsonProperty("group_elements_nrm_1") List<String> groupElementsNrm1,
    @JsonProperty("elements_nrm_1") List<String> elementsNrm1,
    @JsonProperty("product_type") String productType,
    @JsonProperty("product_type_family") List<String> productTypeFamily,
    @JsonProperty("uniclass_systems") List<String> uniclassSystems,
    @JsonProperty("uniclass_products") List<String> uniclassProducts,
    @JsonProperty("uniclass_materials") List<String> uniclassMaterials,
    @JsonProperty("material_type") String materialType,
    @JsonProperty("material_type_family") String materialTypeFamily,
    @JsonProperty("data_source") String dataSource,
    @JsonProperty("data_source_url") String dataSourceUrl,
    @JsonProperty("data_source_year") Integer dataSourceYear,
    @JsonProperty("data_source_country") String dataSourceCountry,
    @JsonProperty("functional_unit_quantity") String functionalUnitQuantity,
    @JsonProperty("functional_unit_unit") String functionalUnitUnit,
    @JsonProperty("total_co2e_kg_mf") Double totalCo2eKgMf,
    @JsonProperty("carbon_a1a3") Double carbonA1A3,
    @JsonProperty("density") Double density,
    @JsonProperty("density_estimated") Boolean densityEstimated,
    @JsonProperty("mass_per_piece") Double massPerPiece,
    @JsonProperty("mass_per_piece_estimated") Boolean massPerPieceEstimated,
    @JsonProperty("mass_per_declared_unit") Double massPerDeclaredUnit,
    @JsonProperty("mass_per_declared_unit_estimated") Boolean massPerDeclaredUnitEstimated,
    @JsonProperty("created") String created,
    @JsonProperty("updated") String updated,
    @JsonProperty("generic_api_url") String genericApiUrl
) {}
