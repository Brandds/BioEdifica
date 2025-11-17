package com.edifica.bioedifica.service.serviceImpl;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import reactor.core.publisher.Mono;

@Service
public class MaterialApiTokenService {
    private final WebClient webClient;

    public MaterialApiTokenService() {
        this.webClient = WebClient.builder()
            .baseUrl("https://app.2050-materials.com")
            .build();
    }

    public Mono<String> getApiToken(String bearerToken) {
        return webClient.get()
            .uri("/developer/api/token/getapitoken/")
            .header("accept", "application/json")
            .header("Authorization", "Bearer " + bearerToken)
            .retrieve()
            .bodyToMono(String.class);
    }
}
