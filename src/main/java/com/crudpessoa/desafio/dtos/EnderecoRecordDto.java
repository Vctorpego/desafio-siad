package com.crudpessoa.desafio.dtos;

import java.util.UUID;

public record EnderecoRecordDto(UUID id,
                                Integer numero,
                                String rua,
                                String bairro,
                                String cidade,
                                String cep,
                                UUID pessoaFisicaId) {
}
