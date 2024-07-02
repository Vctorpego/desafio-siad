package com.crudpessoa.desafio.services;

import com.crudpessoa.desafio.dtos.VendaRecordDto;
import com.crudpessoa.desafio.models.VendaModel;
import com.crudpessoa.desafio.repositories.FisicaRepository;
import com.crudpessoa.desafio.repositories.ProdutoRepository;
import com.crudpessoa.desafio.repositories.VendaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class VendaService {

    private final VendaRepository vendaRepository;
    private final FisicaRepository fisicaRepository;
    private final ProdutoRepository produtoRepository;

    public VendaService(VendaRepository vendaRepository, FisicaRepository fisicaRepository, ProdutoRepository produtoRepository) {
        this.vendaRepository = vendaRepository;
        this.fisicaRepository = fisicaRepository;
        this.produtoRepository = produtoRepository;
    }

    public List<VendaModel> getAllVendas() {
        return vendaRepository.findAll();
    }

    public VendaModel getOneVenda(UUID id) {
        Optional<VendaModel> venda = vendaRepository.findById(id);
        return venda.orElseThrow(() -> new RuntimeException("Venda não encontrada."));
    }

    @Transactional
    public VendaModel saveVenda(VendaRecordDto vendaRecordDto) {
        VendaModel venda = new VendaModel();
        venda.setValorTotal(vendaRecordDto.valorTotal());
        venda.setQuantidade(vendaRecordDto.quantidade());
        venda.setPessoaFisica(fisicaRepository.findById(vendaRecordDto.pessoaFisicaId()).orElseThrow(() -> new RuntimeException("Pessoa Física não encontrada.")));
        venda.setProdutos(produtoRepository.findAllById(vendaRecordDto.produtoIds()).stream().collect(Collectors.toSet()));
        return vendaRepository.save(venda);
    }

    @Transactional
    public VendaModel updateVenda(UUID id, VendaRecordDto vendaRecordDto) {
        VendaModel venda = vendaRepository.findById(id).orElseThrow(() -> new RuntimeException("Venda não encontrada."));
        venda.setValorTotal(vendaRecordDto.valorTotal());
        venda.setQuantidade(vendaRecordDto.quantidade());
        venda.setPessoaFisica(fisicaRepository.findById(vendaRecordDto.pessoaFisicaId()).orElseThrow(() -> new RuntimeException("Pessoa Física não encontrada.")));
        venda.setProdutos(produtoRepository.findAllById(vendaRecordDto.produtoIds()).stream().collect(Collectors.toSet()));
        return vendaRepository.save(venda);
    }

    @Transactional
    public void deleteVenda(UUID id) {
        vendaRepository.deleteById(id);
    }
}

