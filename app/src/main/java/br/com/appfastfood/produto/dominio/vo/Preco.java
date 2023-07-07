package br.com.appfastfood.produto.dominio.vo;

import br.com.appfastfood.produto.exceptions.CamposObrigatorioException;

import java.math.BigDecimal;

public class Preco {
    private BigDecimal preco;
    public Preco(BigDecimal preco) {
        this.preco = preco;
    }
    public BigDecimal getPreco() {
        return preco;
    }
}
