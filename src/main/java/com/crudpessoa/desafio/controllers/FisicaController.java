package com.crudpessoa.desafio.controllers;

import com.crudpessoa.desafio.dtos.FisicaRecordDto;
import com.crudpessoa.desafio.models.FisicaModel;
import com.crudpessoa.desafio.services.FisicaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/fisicas")
public class FisicaController {

    private final FisicaService fisicaService;

    public FisicaController(FisicaService fisicaService) {
        this.fisicaService = fisicaService;
    }

    @GetMapping
    public ResponseEntity<List<FisicaModel>> getAllFisicas() {
        return ResponseEntity.status(HttpStatus.OK).body(fisicaService.getAllFisicas());
    }

    @GetMapping("/{id}")
    public ResponseEntity<FisicaModel> getOneFisica(@PathVariable UUID id) {
        return ResponseEntity.status(HttpStatus.OK).body(fisicaService.getOneFisica(id));
    }

    @PostMapping
    public ResponseEntity<FisicaModel> saveFisica(@RequestBody FisicaRecordDto fisicaRecordDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(fisicaService.saveFisica(fisicaRecordDto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<FisicaModel> updateFisica(@PathVariable UUID id, @RequestBody FisicaRecordDto fisicaRecordDto) {
        return ResponseEntity.status(HttpStatus.OK).body(fisicaService.updateFisica(id, fisicaRecordDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteFisica(@PathVariable UUID id) {
        fisicaService.deleteFisica(id);
        return ResponseEntity.status(HttpStatus.OK).body("Pessoa Física deletada com sucesso.");
    }
}

