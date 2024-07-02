package com.crudpessoa.desafio.dtos;

import java.util.Set;
import java.util.UUID;

public record VendaRecordDto(UUID id,
                             Double valorTotal,
                             Integer quantidade,
                             UUID pessoaFisicaId,
                             Set<UUID> produtoIds) {
}
