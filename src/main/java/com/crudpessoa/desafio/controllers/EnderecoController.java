package com.crudpessoa.desafio.controllers;

import com.crudpessoa.desafio.dtos.EnderecoRecordDto;
import com.crudpessoa.desafio.models.EnderecoModel;
import com.crudpessoa.desafio.services.EnderecoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/enderecos")
public class EnderecoController {

    private final EnderecoService enderecoService;

    public EnderecoController(EnderecoService enderecoService) {
        this.enderecoService = enderecoService;
    }

    @GetMapping
    public ResponseEntity<List<EnderecoModel>> getAllEnderecos() {
        return ResponseEntity.status(HttpStatus.OK).body(enderecoService.getAllEnderecos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<EnderecoModel> getOneEndereco(@PathVariable UUID id) {
        return ResponseEntity.status(HttpStatus.OK).body(enderecoService.getOneEndereco(id));
    }

    @PostMapping
    public ResponseEntity<EnderecoModel> saveEndereco(@RequestBody EnderecoRecordDto enderecoRecordDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(enderecoService.saveEndereco(enderecoRecordDto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<EnderecoModel> updateEndereco(@PathVariable UUID id, @RequestBody EnderecoRecordDto enderecoRecordDto) {
        return ResponseEntity.status(HttpStatus.OK).body(enderecoService.updateEndereco(id, enderecoRecordDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteEndereco(@PathVariable UUID id) {
        enderecoService.deleteEndereco(id);
        return ResponseEntity.status(HttpStatus.OK).body("Endereço deletado com sucesso.");
    }
}
