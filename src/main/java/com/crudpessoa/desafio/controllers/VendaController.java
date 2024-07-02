package com.crudpessoa.desafio.controllers;

import com.crudpessoa.desafio.dtos.VendaRecordDto;
import com.crudpessoa.desafio.models.VendaModel;
import com.crudpessoa.desafio.services.VendaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/vendas")
public class VendaController {

    private final VendaService vendaService;

    public VendaController(VendaService vendaService) {
        this.vendaService = vendaService;
    }

    @GetMapping
    public ResponseEntity<List<VendaModel>> getAllVendas() {
        return ResponseEntity.status(HttpStatus.OK).body(vendaService.getAllVendas());
    }

    @GetMapping("/{id}")
    public ResponseEntity<VendaModel> getOneVenda(@PathVariable UUID id) {
        return ResponseEntity.status(HttpStatus.OK).body(vendaService.getOneVenda(id));
    }

    @PostMapping
    public ResponseEntity<VendaModel> saveVenda(@RequestBody VendaRecordDto vendaRecordDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(vendaService.saveVenda(vendaRecordDto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<VendaModel> updateVenda(@PathVariable UUID id, @RequestBody VendaRecordDto vendaRecordDto) {
        return ResponseEntity.status(HttpStatus.OK).body(vendaService.updateVenda(id, vendaRecordDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteVenda(@PathVariable UUID id) {
        vendaService.deleteVenda(id);
        return ResponseEntity.status(HttpStatus.OK).body("Venda deletada com sucesso.");
    }
}

