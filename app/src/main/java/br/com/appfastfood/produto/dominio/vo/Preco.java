package br.com.appfastfood.produto.dominio.vo;

import java.math.BigDecimal;

public class Preco {
    private Double preco;
    public Preco(Double preco) {
        this.preco = preco;
    }
    public Double getPreco() {
        return preco;
    }
}
