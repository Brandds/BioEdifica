package com.edifica.bioedifica.service;

import java.util.List;
import java.util.Optional;

import com.edifica.bioedifica.dto.cidade.ZoneamentoBioclimaticoDTO;
import com.edifica.bioedifica.model.ZoneamentoBioclimatico;

public interface IZoneamentoBioclimaticoService {
    ZoneamentoBioclimaticoDTO salvar(ZoneamentoBioclimaticoDTO zoneamentoDTO);
    List<ZoneamentoBioclimaticoDTO> listarTodos();
    Optional<ZoneamentoBioclimaticoDTO> buscarPorId(Long id);
    List<ZoneamentoBioclimaticoDTO> buscarPorUf(String uf);
    Optional<ZoneamentoBioclimaticoDTO> buscarPorNomeCidadeEUf(String nomeCidade, String uf);
    List<ZoneamentoBioclimaticoDTO> buscarPorZonaBioclimatica(String zonaBioclimatica);
    List<ZoneamentoBioclimaticoDTO> buscarPorNomeCidade(String nomeCidade);
    Optional<ZoneamentoBioclimaticoDTO> buscarPorCidadeId(Long cidadeId);
    void deletar(Long id);
    ZoneamentoBioclimaticoDTO atualizar(Long id, ZoneamentoBioclimaticoDTO zoneamentoAtualizado);
    public ZoneamentoBioclimatico salvar(ZoneamentoBioclimatico zoneamento);
}