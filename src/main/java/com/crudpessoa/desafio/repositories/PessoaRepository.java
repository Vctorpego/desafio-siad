package com.crudpessoa.desafio.repositories;

import com.crudpessoa.desafio.models.PessoaModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface PessoaRepository extends JpaRepository<PessoaModel, UUID> {
}
