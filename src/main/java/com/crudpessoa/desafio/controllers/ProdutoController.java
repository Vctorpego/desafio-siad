package com.crudpessoa.desafio.controllers;

import com.crudpessoa.desafio.dtos.ProdutoRecordDto;
import com.crudpessoa.desafio.models.ProdutoModel;
import com.crudpessoa.desafio.services.ProdutoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    private final ProdutoService produtoService;

    public ProdutoController(ProdutoService produtoService) {
        this.produtoService = produtoService;
    }

    @GetMapping
    public ResponseEntity<List<ProdutoModel>> getAllProdutos() {
        return ResponseEntity.status(HttpStatus.OK).body(produtoService.getAllProdutos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProdutoModel> getOneProduto(@PathVariable UUID id) {
        return ResponseEntity.status(HttpStatus.OK).body(produtoService.getOneProduto(id));
    }

    @PostMapping
    public ResponseEntity<ProdutoModel> saveProduto(@RequestBody ProdutoRecordDto produtoRecordDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(produtoService.saveProduto(produtoRecordDto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProdutoModel> updateProduto(@PathVariable UUID id, @RequestBody ProdutoRecordDto produtoRecordDto) {
        return ResponseEntity.status(HttpStatus.OK).body(produtoService.updateProduto(id, produtoRecordDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteProduto(@PathVariable UUID id) {
        produtoService.deleteProduto(id);
        return ResponseEntity.status(HttpStatus.OK).body("Produto deletado com sucesso.");
    }
}
