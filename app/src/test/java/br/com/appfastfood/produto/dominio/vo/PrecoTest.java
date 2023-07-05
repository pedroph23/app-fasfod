package br.com.appfastfood.produto.dominio.vo;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class PrecoTest {

    @Test
    void getPreco_DeveRetornarPrecoCorreto() {
        BigDecimal preco = new BigDecimal("19.99");
        Preco objetoPreco = new Preco(preco);

        assertEquals(preco, objetoPreco.getPreco());
    }
}
