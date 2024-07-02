package com.crudpessoa.desafio.models;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "TB_PRODUTO")
public class ProdutoModel implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private Double preco;

    @ManyToOne
    @JoinColumn(name = "juridica_id")
    private JuridicaModel pessoaJuridica;

    @ManyToMany(mappedBy = "produtos")
    private Set<VendaModel> vendas = new HashSet<>();

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public JuridicaModel getPessoaJuridica() {
        return pessoaJuridica;
    }

    public void setPessoaJuridica(JuridicaModel pessoaJuridica) {
        this.pessoaJuridica = pessoaJuridica;
    }

    public Set<VendaModel> getVendas() {
        return vendas;
    }

    public void setVendas(Set<VendaModel> vendas) {
        this.vendas = vendas;
    }
}
