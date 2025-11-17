package com.edifica.bioedifica.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;

/**
 * Configuração do Swagger/OpenAPI para documentação automática da API REST.
 * 
 * Esta configuração reflete o contexto do projeto EcoMaterials, voltado para a construção civil sustentável.
 * A API auxilia arquitetos, engenheiros e gestores públicos na tomada de decisão sobre materiais e sistemas construtivos,
 * automatizando cálculos de desempenho térmico conforme as normas NBR 15220-2/3 e incorporando análise ambiental do ciclo de vida dos materiais.
 * 
 * O objetivo é democratizar o acesso à alta performance ambiental, promover escolhas conscientes e alinhar-se aos ODS da ONU.
 */
@Configuration
public class SwaggerConfig {
     @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
            .info(new Info().title("Bioedifica API").version("v1"))
            .addSecurityItem(new SecurityRequirement().addList("bearerAuth"))
            .components(new io.swagger.v3.oas.models.Components()
                .addSecuritySchemes("bearerAuth",
                    new SecurityScheme()
                        .type(SecurityScheme.Type.HTTP)
                        .scheme("bearer")
                        .bearerFormat("JWT")
                )
            );
    }
}
