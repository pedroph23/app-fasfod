package br.com.appfastfood.produto.dominio.modelo;

import br.com.appfastfood.produto.dominio.modelos.Preco;
import br.com.appfastfood.produto.exceptions.PrecoObrigatorioException;
import org.junit.jupiter.api.Test;
import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;


public class PrecoTest {
    @Test
    public void testConstrutorComPrecoValido() {
        BigDecimal preco = new BigDecimal("10.99");
        Preco precoObjeto = new Preco(preco);
        assertEquals(preco, precoObjeto.getPreco());
    }

    @Test
    public void testConstrutorComPrecoNulo() {
        assertThrows(PrecoObrigatorioException.class, () -> new Preco(null));
    }
}
