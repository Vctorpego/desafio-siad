package com.crudpessoa.desafio.dtos;

import java.util.Set;
import java.util.UUID;

public record FisicaRecordDto(UUID id,
                              String nome,
                              String cpf,
                              Set<UUID> vendaIds,
                              Set<UUID> enderecoIds) {
}
