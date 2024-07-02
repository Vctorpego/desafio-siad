package com.crudpessoa.desafio.controllers;

import com.crudpessoa.desafio.dtos.JuridicaRecordDto;
import com.crudpessoa.desafio.models.JuridicaModel;
import com.crudpessoa.desafio.services.JuridicaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/juridicas")
public class JuridicaController {

    private final JuridicaService juridicaService;

    public JuridicaController(JuridicaService juridicaService) {
        this.juridicaService = juridicaService;
    }

    @GetMapping
    public ResponseEntity<List<JuridicaModel>> getAllJuridicas() {
        return ResponseEntity.status(HttpStatus.OK).body(juridicaService.getAllJuridicas());
    }

    @GetMapping("/{id}")
    public ResponseEntity<JuridicaModel> getOneJuridica(@PathVariable UUID id) {
        return ResponseEntity.status(HttpStatus.OK).body(juridicaService.getOneJuridica(id));
    }

    @PostMapping
    public ResponseEntity<JuridicaModel> saveJuridica(@RequestBody JuridicaRecordDto juridicaRecordDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(juridicaService.saveJuridica(juridicaRecordDto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<JuridicaModel> updateJuridica(@PathVariable UUID id, @RequestBody JuridicaRecordDto juridicaRecordDto) {
        return ResponseEntity.status(HttpStatus.OK).body(juridicaService.updateJuridica(id, juridicaRecordDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteJuridica(@PathVariable UUID id) {
        juridicaService.deleteJuridica(id);
        return ResponseEntity.status(HttpStatus.OK).body("Pessoa Jurídica deletada com sucesso.");
    }
}

