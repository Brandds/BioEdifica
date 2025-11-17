package com.edifica.bioedifica.service.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edifica.bioedifica.dto.cidade.ZoneamentoBioclimaticoDTO;
import com.edifica.bioedifica.exception.EntityNotFoundException;
import com.edifica.bioedifica.mapper.ZoneamentoBioclimaticoMapper;
import com.edifica.bioedifica.model.ZoneamentoBioclimatico;
import com.edifica.bioedifica.repository.ZoneamentoBioclimaticoRepository;
import com.edifica.bioedifica.service.IZoneamentoBioclimaticoService;

@Service("zoneamentoBioclimaticoServiceImpl")
public class ZoneamentoBioclimaticoService implements IZoneamentoBioclimaticoService {
    
    @Autowired
    private ZoneamentoBioclimaticoRepository zoneamentoBioclimaticoRepository;

    @Override
    public ZoneamentoBioclimaticoDTO salvar(ZoneamentoBioclimaticoDTO zoneamentoDTO) {
        var zoneamento = ZoneamentoBioclimaticoMapper.toEntity(zoneamentoDTO);
        var salvo = zoneamentoBioclimaticoRepository.save(zoneamento);
        return ZoneamentoBioclimaticoMapper.toDTO(salvo);
    }

    @Override
    public List<ZoneamentoBioclimaticoDTO> listarTodos() {
        return zoneamentoBioclimaticoRepository.findAll().stream()
            .map(ZoneamentoBioclimaticoMapper::toDTO)
            .toList();
    }

    @Override
    public Optional<ZoneamentoBioclimaticoDTO> buscarPorId(Long id) {
        return zoneamentoBioclimaticoRepository.findById(id)
            .map(ZoneamentoBioclimaticoMapper::toDTO);
    }

    @Override
    public List<ZoneamentoBioclimaticoDTO> buscarPorUf(String uf) {
        return zoneamentoBioclimaticoRepository.findByUf(uf).stream()
            .map(ZoneamentoBioclimaticoMapper::toDTO)
            .toList();
    }

    @Override
    public Optional<ZoneamentoBioclimaticoDTO> buscarPorNomeCidadeEUf(String nomeCidade, String uf) {
        return zoneamentoBioclimaticoRepository.findByNomeCidadeAndUf(nomeCidade, uf)
            .map(ZoneamentoBioclimaticoMapper::toDTO);
    }

    @Override
    public List<ZoneamentoBioclimaticoDTO> buscarPorZonaBioclimatica(String zonaBioclimatica) {
        return zoneamentoBioclimaticoRepository.findByZonaBioclimatica(zonaBioclimatica).stream()
            .map(ZoneamentoBioclimaticoMapper::toDTO)
            .toList();
    }

    @Override
    public List<ZoneamentoBioclimaticoDTO> buscarPorNomeCidade(String nomeCidade) {
        return zoneamentoBioclimaticoRepository.findByCidadeNomeContaining(nomeCidade).stream()
            .map(ZoneamentoBioclimaticoMapper::toDTO)
            .toList();
    }

    @Override
    public Optional<ZoneamentoBioclimaticoDTO> buscarPorCidadeId(Long cidadeId) {
        return zoneamentoBioclimaticoRepository.findByCidadeId(cidadeId)
            .map(ZoneamentoBioclimaticoMapper::toDTO);
    }

    @Override
    public void deletar(Long id) {
        if (!zoneamentoBioclimaticoRepository.existsById(id)) {
            throw new EntityNotFoundException("Zoneamento Bioclimático não encontrado com ID: " + id);
        }
        zoneamentoBioclimaticoRepository.deleteById(id);
    }

    @Override
    public ZoneamentoBioclimaticoDTO atualizar(Long id, ZoneamentoBioclimaticoDTO zoneamentoAtualizado) {
        var zoneamentoExistente = zoneamentoBioclimaticoRepository.findById(id)
            .orElseThrow(() -> new EntityNotFoundException("Zoneamento Bioclimático não encontrado com ID: " + id));
        
        ZoneamentoBioclimaticoMapper.updateEntityFromDTO(zoneamentoExistente, zoneamentoAtualizado);
        var salvo = zoneamentoBioclimaticoRepository.save(zoneamentoExistente);
        return ZoneamentoBioclimaticoMapper.toDTO(salvo);
    }

    @Override
    public ZoneamentoBioclimatico salvar(ZoneamentoBioclimatico zoneamento) {
        var salvo = zoneamentoBioclimaticoRepository.save(zoneamento);
        return salvo;
    }
}