package com.crudpessoa.desafio.repositories;

import com.crudpessoa.desafio.models.VendaModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface VendaRepository extends JpaRepository<VendaModel, UUID> {
}
