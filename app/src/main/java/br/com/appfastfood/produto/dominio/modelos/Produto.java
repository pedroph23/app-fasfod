package br.com.appfastfood.produto.dominio.modelos;

import java.math.BigDecimal;

public class Produto {
    private Long id;
    private String nome;
    private BigDecimal preco;
    private String uriImagem;
    private Enum categoria;
    private String descricao;

    public Produto(Long id, String nome, BigDecimal preco, String uriImagem, Enum categoria, String descricao) {

        //Inserir validacoes dos campos
        this.nome = nome;
        this.id = id;
        this.preco = preco;
        this.uriImagem = uriImagem;
        this.categoria = categoria;
        this.descricao = descricao;
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public String getUriImagem() {
        return uriImagem;
    }

    public Enum getCategoria() {
        return categoria;
    }

    public String getDescricao() {
        return descricao;
    }
}
