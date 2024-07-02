package com.crudpessoa.desafio.services;

import com.crudpessoa.desafio.dtos.ProdutoRecordDto;
import com.crudpessoa.desafio.models.ProdutoModel;
import com.crudpessoa.desafio.models.VendaModel;
import com.crudpessoa.desafio.repositories.JuridicaRepository;
import com.crudpessoa.desafio.repositories.ProdutoRepository;
import com.crudpessoa.desafio.repositories.VendaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class ProdutoService {

    private final ProdutoRepository produtoRepository;
    private final JuridicaRepository juridicaRepository;
    private final VendaRepository vendaRepository;

    public ProdutoService(ProdutoRepository produtoRepository, JuridicaRepository juridicaRepository, VendaRepository vendaRepository) {
        this.produtoRepository = produtoRepository;
        this.juridicaRepository = juridicaRepository;
        this.vendaRepository = vendaRepository;
    }

    public List<ProdutoModel> getAllProdutos() {
        return produtoRepository.findAll();
    }

    public ProdutoModel getOneProduto(UUID id) {
        Optional<ProdutoModel> produto = produtoRepository.findById(id);
        return produto.orElseThrow(() -> new RuntimeException("Produto não encontrado."));
    }

    @Transactional
    public ProdutoModel saveProduto(ProdutoRecordDto produtoRecordDto) {
        ProdutoModel produto = new ProdutoModel();
        produto.setNome(produtoRecordDto.nome());
        produto.setPreco(produtoRecordDto.preco());
        produto.setPessoaJuridica(juridicaRepository.findById(produtoRecordDto.pessoaJuridicaId()).orElseThrow(() -> new RuntimeException("Pessoa Jurídica não encontrada.")));
        produto.setVendas(vendaRepository.findAllById(produtoRecordDto.vendaIds()).stream().collect(Collectors.toSet()));
        return produtoRepository.save(produto);
    }

    @Transactional
    public ProdutoModel updateProduto(UUID id, ProdutoRecordDto produtoRecordDto) {
        ProdutoModel produto = produtoRepository.findById(id).orElseThrow(() -> new RuntimeException("Produto não encontrado."));
        produto.setNome(produtoRecordDto.nome());
        produto.setPreco(produtoRecordDto.preco());
        produto.setPessoaJuridica(juridicaRepository.findById(produtoRecordDto.pessoaJuridicaId()).orElseThrow(() -> new RuntimeException("Pessoa Jurídica não encontrada.")));
        produto.setVendas(vendaRepository.findAllById(produtoRecordDto.vendaIds()).stream().collect(Collectors.toSet()));
        return produtoRepository.save(produto);
    }

    @Transactional
    public void deleteProduto(UUID id) {
        produtoRepository.deleteById(id);
    }
}
