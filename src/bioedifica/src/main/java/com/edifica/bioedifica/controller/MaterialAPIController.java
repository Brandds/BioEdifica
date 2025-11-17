package com.edifica.bioedifica.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.edifica.bioedifica.service.IMaterialAPIService;



@RestController
@RequestMapping("/api/material")
public class MaterialAPIController {
  
  @Autowired
  private IMaterialAPIService materialAPIService;

  @GetMapping("/buscarAPIKEYDEVELOPER")
  public String getApiToken() {
    String apiToken = materialAPIService.getApiTokenDeveloper();
    return apiToken;
  }
  
}
