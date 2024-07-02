package com.crudpessoa.desafio.repositories;

import com.crudpessoa.desafio.models.ProdutoModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ProdutoRepository extends JpaRepository<ProdutoModel, UUID> {
}
