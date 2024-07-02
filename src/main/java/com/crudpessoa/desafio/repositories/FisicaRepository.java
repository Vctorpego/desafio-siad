package com.crudpessoa.desafio.repositories;

import com.crudpessoa.desafio.models.FisicaModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface FisicaRepository extends JpaRepository<FisicaModel, UUID> {
}
