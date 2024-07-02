package com.crudpessoa.desafio.dtos;

import java.util.Set;
import java.util.UUID;

public record ProdutoRecordDto(UUID id,
                               String nome,
                               Double preco,
                               Set<UUID> vendaIds,
                               UUID pessoaJuridicaId) {
}
