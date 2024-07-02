package com.crudpessoa.desafio.models;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "TB_PESSOA_FISICA")
public class FisicaModel extends PessoaModel implements Serializable {
    private static final long serialVersionUID = 1L;

    @Column(nullable = false, unique = true)
    private String cpf;

    @OneToMany(mappedBy = "pessoaFisica", cascade = CascadeType.ALL)
    private Set<VendaModel> vendas = new HashSet<>();

    @OneToMany(mappedBy = "pessoaFisica", cascade = CascadeType.ALL)
    private Set<EnderecoModel> enderecos = new HashSet<>();

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Set<VendaModel> getVendas() {
        return vendas;
    }

    public void setVendas(Set<VendaModel> vendas) {
        this.vendas = vendas;
    }

    public Set<EnderecoModel> getEnderecos() {
        return enderecos;
    }

    public void setEnderecos(Set<EnderecoModel> enderecos) {
        this.enderecos = enderecos;
    }
}
