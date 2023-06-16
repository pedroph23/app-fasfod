package br.com.appfastfood.produto.dominio.modelos;

import br.com.appfastfood.produto.dominio.modelos.enums.CategoriaEnum;

import java.math.BigDecimal;

public class Produto {
    private Nome nome;
    private Preco preco;
    private UriImagem uriImagem;
    private CategoriaEnum categoria;
    private Descricao descricao;

    public Produto(Nome nome, Preco preco, UriImagem uriImagem, CategoriaEnum categoria, Descricao descricao) {
        this.nome = nome;
        this.preco = preco;
        this.uriImagem = uriImagem;
        this.categoria = categoria;
        this.descricao = descricao;
    }

    public Nome getNome() {
        return nome;
    }

    public Preco getPreco() {
        return preco;
    }

    public UriImagem getUriImagem() {
        return uriImagem;
    }

    public CategoriaEnum getCategoria() {
        return categoria;
    }

    public Descricao getDescricao() {
        return descricao;
    }
}
