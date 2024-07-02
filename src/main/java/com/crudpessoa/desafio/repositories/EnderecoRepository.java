package com.crudpessoa.desafio.repositories;

import com.crudpessoa.desafio.models.EnderecoModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface EnderecoRepository extends JpaRepository<EnderecoModel, UUID> {
}
