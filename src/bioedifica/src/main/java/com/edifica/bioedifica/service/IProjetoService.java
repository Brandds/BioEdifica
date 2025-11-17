package com.edifica.bioedifica.service;

import java.util.List;

import com.edifica.bioedifica.dto.projeto.ProjetoDTO;
import com.edifica.bioedifica.dto.projeto.ProjetoDetalhadoDTO;

public interface IProjetoService {
  ProjetoDetalhadoDTO criarProjeto(ProjetoDTO projetoDTO);
  ProjetoDetalhadoDTO getProjetoById(Long id);
  List<ProjetoDTO> getProjetoByUsuario(Long idUsuario);
  ProjetoDetalhadoDTO atualizarProjeto(ProjetoDetalhadoDTO projetoDTO, Long idUsuario);
  void deletarProjeto(Long idProjeto, Long idUsuario);
}
