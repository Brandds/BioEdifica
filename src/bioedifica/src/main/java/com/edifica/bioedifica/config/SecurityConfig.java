package com.edifica.bioedifica.config;

import java.util.Arrays;

import javax.crypto.spec.SecretKeySpec;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.oauth2.jwt.JwtDecoder;
import org.springframework.security.oauth2.jwt.NimbusJwtDecoder;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationConverter;
import org.springframework.security.oauth2.server.resource.authentication.JwtGrantedAuthoritiesConverter;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

/**
 * Configuração de segurança para autenticação JWT.
 * Utiliza propriedades e recursos do Java 17.
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig {
    @Value("${spring.security.oauth2.resourceserver.jwt.secret}")
    private String jwtSecret;
    
    @Value("${cors.allowed-origins:http://localhost:5174,http://localhost:3000}")
    private String[] allowedOrigins;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
            JwtAuthenticationConverter jwtAuthenticationConverter = new JwtAuthenticationConverter();
            JwtGrantedAuthoritiesConverter grantedAuthoritiesConverter = new JwtGrantedAuthoritiesConverter();
            grantedAuthoritiesConverter.setAuthorityPrefix(""); // Não adiciona 'ROLE_'
            grantedAuthoritiesConverter.setAuthoritiesClaimName("role"); // Usa claim 'role' como autoridade
            jwtAuthenticationConverter.setJwtGrantedAuthoritiesConverter(grantedAuthoritiesConverter);

            http
                .csrf(csrf -> csrf.disable())
                .cors(cors -> cors.configurationSource(corsConfigurationSource()))
                .headers(headers -> headers
                    .frameOptions(frameOptions -> frameOptions.disable()) // Para H2 Console
                )
                .authorizeHttpRequests(auth -> auth
                    // Permitir acesso aos recursos públicos
                    .requestMatchers("/swagger-ui/**", "/swagger-ui.html", "/v3/api-docs/**", "/v3/api-docs.yaml").permitAll()
                    .requestMatchers("/h2-console/**").permitAll()
                    // Permitir OPTIONS para CORS preflight
                    .requestMatchers(HttpMethod.OPTIONS, "/**").permitAll()
                    // Endpoints de autenticação - permitir criação de usuário e login
                    .requestMatchers(HttpMethod.POST, "/api/usuarios/**").permitAll()
                    .requestMatchers(HttpMethod.POST, "/api/usuarios/login/**").permitAll()
                    // Todos os outros endpoints precisam de autenticação
                    .anyRequest().authenticated()
                )
                .oauth2ResourceServer(oauth2 -> oauth2
                    .jwt(jwt -> jwt.jwtAuthenticationConverter(jwtAuthenticationConverter))
                );
            return http.build();
    }

    @Bean
    public CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration configuration = new CorsConfiguration();
        
        // Origens permitidas por configuração
        configuration.setAllowedOrigins(Arrays.asList(allowedOrigins));
        
        // Métodos HTTP permitidos (apenas os necessários)
        configuration.setAllowedMethods(Arrays.asList(
            "GET", "POST", "PUT", "DELETE", "OPTIONS", "PATCH"
        ));
        
        // Headers permitidos (específicos)
        configuration.setAllowedHeaders(Arrays.asList(
            "Content-Type", 
            "Authorization", 
            "X-Requested-With",
            "Accept",
            "Origin"
        ));
        
        // Permitir credenciais (necessário para cookies/tokens)
        configuration.setAllowCredentials(true);
        
        // Headers expostos para o frontend acessar
        configuration.setExposedHeaders(Arrays.asList("Authorization"));
        
        // Cache do preflight por 1 hora
        configuration.setMaxAge(3600L);
        
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);
        
        return source;
    }

    @Bean
    public JwtDecoder jwtDecoder() {
        SecretKeySpec secretKey = new SecretKeySpec(jwtSecret.getBytes(), "HmacSHA256");
        return NimbusJwtDecoder.withSecretKey(secretKey).build();
    }
}
