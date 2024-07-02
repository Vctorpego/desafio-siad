package com.crudpessoa.desafio.repositories;

import com.crudpessoa.desafio.models.JuridicaModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface JuridicaRepository extends JpaRepository<JuridicaModel, UUID> {
}
