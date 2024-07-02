package com.crudpessoa.desafio.models;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;


@Entity
@Table(name = "TB_VENDA")
public class VendaModel implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(nullable = false)
    private Double valorTotal;

    @Column(nullable = false)
    private Integer quantidade;

    @ManyToOne
    @JoinColumn(name = "fisica_id")
    private FisicaModel pessoaFisica;

    @ManyToMany
    @JoinTable(
            name = "tb_venda_produto",
            joinColumns = @JoinColumn(name = "venda_id"),
            inverseJoinColumns = @JoinColumn(name = "produto_id")
    )
    private Set<ProdutoModel> produtos = new HashSet<>();

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(Double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public FisicaModel getPessoaFisica() {
        return pessoaFisica;
    }

    public void setPessoaFisica(FisicaModel pessoaFisica) {
        this.pessoaFisica = pessoaFisica;
    }

    public Set<ProdutoModel> getProdutos() {
        return produtos;
    }

    public void setProdutos(Set<ProdutoModel> produtos) {
        this.produtos = produtos;
    }
}
