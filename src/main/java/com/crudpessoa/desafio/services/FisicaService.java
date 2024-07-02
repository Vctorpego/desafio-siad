package com.crudpessoa.desafio.services;

import com.crudpessoa.desafio.dtos.FisicaRecordDto;
import com.crudpessoa.desafio.models.FisicaModel;
import com.crudpessoa.desafio.repositories.EnderecoRepository;
import com.crudpessoa.desafio.repositories.FisicaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class FisicaService {

    private final FisicaRepository fisicaRepository;
    private final EnderecoRepository enderecoRepository;

    public FisicaService(FisicaRepository fisicaRepository, EnderecoRepository enderecoRepository) {
        this.fisicaRepository = fisicaRepository;
        this.enderecoRepository = enderecoRepository;
    }

    public List<FisicaModel> getAllFisicas() {
        return fisicaRepository.findAll();
    }

    public FisicaModel getOneFisica(UUID id) {
        Optional<FisicaModel> fisica = fisicaRepository.findById(id);
        return fisica.orElseThrow(() -> new RuntimeException("Pessoa Física não encontrada."));
    }

    @Transactional
    public FisicaModel saveFisica(FisicaRecordDto fisicaRecordDto) {
        FisicaModel fisica = new FisicaModel();
        fisica.setNome(fisicaRecordDto.nome());
        fisica.setCpf(fisicaRecordDto.cpf());
        fisica.setEnderecos(enderecoRepository.findAllById(fisicaRecordDto.enderecoIds()).stream().collect(Collectors.toSet()));
        return fisicaRepository.save(fisica);
    }

    @Transactional
    public FisicaModel updateFisica(UUID id, FisicaRecordDto fisicaRecordDto) {
        FisicaModel fisica = fisicaRepository.findById(id).orElseThrow(() -> new RuntimeException("Pessoa Física não encontrada."));
        fisica.setNome(fisicaRecordDto.nome());
        fisica.setCpf(fisicaRecordDto.cpf());
        fisica.setEnderecos(enderecoRepository.findAllById(fisicaRecordDto.enderecoIds()).stream().collect(Collectors.toSet()));
        return fisicaRepository.save(fisica);
    }

    @Transactional
    public void deleteFisica(UUID id) {
        fisicaRepository.deleteById(id);
    }
}
