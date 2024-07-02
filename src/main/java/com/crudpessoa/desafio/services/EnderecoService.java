package com.crudpessoa.desafio.services;

import com.crudpessoa.desafio.dtos.EnderecoRecordDto;
import com.crudpessoa.desafio.models.EnderecoModel;
import com.crudpessoa.desafio.repositories.EnderecoRepository;
import com.crudpessoa.desafio.repositories.FisicaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class EnderecoService {

    private final EnderecoRepository enderecoRepository;
    private final FisicaRepository fisicaRepository;

    public EnderecoService(EnderecoRepository enderecoRepository, FisicaRepository fisicaRepository) {
        this.enderecoRepository = enderecoRepository;
        this.fisicaRepository = fisicaRepository;
    }

    public List<EnderecoModel> getAllEnderecos() {
        return enderecoRepository.findAll();
    }

    public EnderecoModel getOneEndereco(UUID id) {
        Optional<EnderecoModel> endereco = enderecoRepository.findById(id);
        return endereco.orElseThrow(() -> new RuntimeException("Endereço não encontrado."));
    }

    @Transactional
    public EnderecoModel saveEndereco(EnderecoRecordDto enderecoRecordDto) {
        EnderecoModel endereco = new EnderecoModel();
        endereco.setNumero(enderecoRecordDto.numero());
        endereco.setRua(enderecoRecordDto.rua());
        endereco.setBairro(enderecoRecordDto.bairro());
        endereco.setCidade(enderecoRecordDto.cidade());
        endereco.setCep(enderecoRecordDto.cep());
        endereco.setPessoaFisica(fisicaRepository.findById(enderecoRecordDto.pessoaFisicaId()).orElseThrow(() -> new RuntimeException("Pessoa Física não encontrada.")));
        return enderecoRepository.save(endereco);
    }

    @Transactional
    public EnderecoModel updateEndereco(UUID id, EnderecoRecordDto enderecoRecordDto) {
        EnderecoModel endereco = enderecoRepository.findById(id).orElseThrow(() -> new RuntimeException("Endereço não encontrado."));
        endereco.setNumero(enderecoRecordDto.numero());
        endereco.setRua(enderecoRecordDto.rua());
        endereco.setBairro(enderecoRecordDto.bairro());
        endereco.setCidade(enderecoRecordDto.cidade());
        endereco.setCep(enderecoRecordDto.cep());
        endereco.setPessoaFisica(fisicaRepository.findById(enderecoRecordDto.pessoaFisicaId()).orElseThrow(() -> new RuntimeException("Pessoa Física não encontrada.")));
        return enderecoRepository.save(endereco);
    }

    @Transactional
    public void deleteEndereco(UUID id) {
        enderecoRepository.deleteById(id);
    }
}

