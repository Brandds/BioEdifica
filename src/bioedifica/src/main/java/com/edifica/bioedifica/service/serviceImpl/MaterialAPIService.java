package com.edifica.bioedifica.service.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.edifica.bioedifica.service.IMaterialAPIService;

@Service
public class MaterialAPIService implements IMaterialAPIService {
  @Value("${material.api.token}")
  private String chaveApi;


  @Autowired
  private MaterialApiTokenService materialApiTokenService;

  @Override
  public String getApiTokenDeveloper() {
  String response = materialApiTokenService.getApiToken(chaveApi).block();
    if (response == null) return null;
    try {
      com.fasterxml.jackson.databind.JsonNode node = new com.fasterxml.jackson.databind.ObjectMapper().readTree(response);
      return node.has("api_token") ? node.get("api_token").asText() : null;
    } catch (Exception e) {
      throw new RuntimeException("Erro ao extrair api_token", e);
    }
  }
  
}
