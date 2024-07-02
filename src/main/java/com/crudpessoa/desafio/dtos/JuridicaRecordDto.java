package com.crudpessoa.desafio.dtos;

import java.util.Set;
import java.util.UUID;

public record JuridicaRecordDto(UUID id,
                                String nome,
                                String cnpj,
                                Set<UUID> produtoIds) {
}
