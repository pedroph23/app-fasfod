package br.com.appfastfood.produto.dominio.modelo;

import br.com.appfastfood.produto.dominio.modelos.Descricao;
import br.com.appfastfood.produto.exceptions.DescricaoObrigatorioException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class DescricaoTest {

    @Test
    public void testConstrutorComDescricaoValida() {
        String descricao = "Descrição do produto";
        Descricao descricaoObjeto = new Descricao(descricao);
        assertEquals(descricao, descricaoObjeto.getDescricao());
    }

    @Test
    public void testConstrutorComDescricaoNula() {
        assertThrows(DescricaoObrigatorioException.class, () -> new Descricao(null));
    }

    @Test
    public void testConstrutorComDescricaoVazia() {
        assertThrows(DescricaoObrigatorioException.class, () -> new Descricao(""));
    }
}
