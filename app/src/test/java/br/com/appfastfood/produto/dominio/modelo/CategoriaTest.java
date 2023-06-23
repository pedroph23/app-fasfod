package br.com.appfastfood.produto.dominio.modelo;

import br.com.appfastfood.produto.dominio.modelos.Categoria;
import br.com.appfastfood.produto.dominio.modelos.UriImagem;
import br.com.appfastfood.produto.dominio.modelos.enums.CategoriaEnum;
import br.com.appfastfood.produto.exceptions.CategoriaNaoEncontradaException;
import br.com.appfastfood.produto.exceptions.CategoriaObrigatorioException;
import br.com.appfastfood.produto.exceptions.UriImagemFormatoInvalidoException;
import br.com.appfastfood.produto.exceptions.UriImagemObrigatorioException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CategoriaTest {

    @Test
    public void testConstrutorComCategoriaValida() {
        String categoria = "bebida";
        Categoria categoriaObjeto = new Categoria(categoria);
        assertEquals(CategoriaEnum.bebida, categoriaObjeto.getCategoria());
    }

    @Test
    public void testConstrutorComCategoriaNula() {
        assertThrows(CategoriaObrigatorioException.class, () -> new Categoria(null));
    }

    @Test
    public void testConstrutorComCategoriaVazia() {
        assertThrows(CategoriaObrigatorioException.class, () -> new Categoria(""));
    }

    @Test
    public void testConstrutorComCategoriaInvalida() {
        String categoria = "Comidas";
        assertThrows(CategoriaNaoEncontradaException.class, () -> new Categoria(categoria));
    }
}
