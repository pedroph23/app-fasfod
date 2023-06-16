package br.com.appfastfood.produto.infraestrutura.entidades;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.math.BigDecimal;
@Entity
public class ProdutoEntidade {
    @Id
    private Long id;

    protected ProdutoEntidade() {
    }

    private String nome;
    private BigDecimal preco;
    private String uriImagem;
    private String categoria;
    private String descricao;

    public ProdutoEntidade(Long id, String nome, BigDecimal preco, String uriImagem, String categoria, String descricao) {
        this.id = id;
        this.nome = nome;
        this.preco = preco;
        this.uriImagem = uriImagem;
        this.categoria = categoria;
        this.descricao = descricao;
    }
}
