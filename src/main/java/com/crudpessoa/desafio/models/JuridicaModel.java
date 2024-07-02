package com.crudpessoa.desafio.models;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "TB_PESSOA_JURIDICA")
public class JuridicaModel extends PessoaModel implements Serializable {
    private static final long serialVersionUID = 1L;

    @Column(nullable = false, unique = true)
    private String cnpj;

    @OneToMany(mappedBy = "pessoaJuridica", cascade = CascadeType.ALL)
    private Set<ProdutoModel> produtos = new HashSet<>();

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public Set<ProdutoModel> getProdutos() {
        return produtos;
    }

    public void setProdutos(Set<ProdutoModel> produtos) {
        this.produtos = produtos;
    }
}
