package com.crudpessoa.desafio.services;

import com.crudpessoa.desafio.dtos.JuridicaRecordDto;
import com.crudpessoa.desafio.models.JuridicaModel;
import com.crudpessoa.desafio.repositories.JuridicaRepository;
import com.crudpessoa.desafio.repositories.ProdutoRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class JuridicaService {

    private final JuridicaRepository juridicaRepository;
    private final ProdutoRepository produtoRepository;

    public JuridicaService(JuridicaRepository juridicaRepository, ProdutoRepository produtoRepository) {
        this.juridicaRepository = juridicaRepository;
        this.produtoRepository = produtoRepository;
    }

    public List<JuridicaModel> getAllJuridicas() {
        return juridicaRepository.findAll();
    }

    public JuridicaModel getOneJuridica(UUID id) {
        Optional<JuridicaModel> juridica = juridicaRepository.findById(id);
        return juridica.orElseThrow(() -> new RuntimeException("Pessoa Jurídica não encontrada."));
    }

    @Transactional
    public JuridicaModel saveJuridica(JuridicaRecordDto juridicaRecordDto) {
        JuridicaModel juridica = new JuridicaModel();
        juridica.setNome(juridicaRecordDto.nome());
        juridica.setCnpj(juridicaRecordDto.cnpj());
        juridica.setProdutos(produtoRepository.findAllById(juridicaRecordDto.produtoIds()).stream().collect(Collectors.toSet()));
        return juridicaRepository.save(juridica);
    }

    @Transactional
    public JuridicaModel updateJuridica(UUID id, JuridicaRecordDto juridicaRecordDto) {
        JuridicaModel juridica = juridicaRepository.findById(id).orElseThrow(() -> new RuntimeException("Pessoa Jurídica não encontrada."));
        juridica.setNome(juridicaRecordDto.nome());
        juridica.setCnpj(juridicaRecordDto.cnpj());
        juridica.setProdutos(produtoRepository.findAllById(juridicaRecordDto.produtoIds()).stream().collect(Collectors.toSet()));
        return juridicaRepository.save(juridica);
    }

    @Transactional
    public void deleteJuridica(UUID id) {
        juridicaRepository.deleteById(id);
    }
}
