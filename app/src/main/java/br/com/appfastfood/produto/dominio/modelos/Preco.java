package br.com.appfastfood.produto.dominio.modelos;

import br.com.appfastfood.produto.exceptions.PrecoObrigatorioException;

import java.math.BigDecimal;

public class Preco {
    private BigDecimal preco;
    public Preco(BigDecimal preco) {
        this.isValid(preco);
        this.preco = preco;
    }
    public BigDecimal getPreco() {
        return preco;
    }
    private void isValid(BigDecimal preco) {
        if(preco == null) {
            throw new PrecoObrigatorioException();
        }
    }
}
