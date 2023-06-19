package br.com.appfastfood.produto.dominio.modelos;

import br.com.appfastfood.produto.dominio.modelos.enums.CategoriaEnum;
import br.com.appfastfood.produto.exceptions.CategoriaNaoEncontradaException;
import br.com.appfastfood.produto.exceptions.CategoriaObrigatorioException;

public class Categoria {
    private CategoriaEnum categoria;
    public Categoria(String categoria) {
        this.categoria = this.isValid(categoria);
    }
    public CategoriaEnum getCategoria() {
        return categoria;
    }
    private CategoriaEnum isValid(String categoria) {
        this.isEmpty(categoria);
        return this.existCategoria(categoria);
    }

    private CategoriaEnum existCategoria(String categoria) {
        try {
            return CategoriaEnum.valueOf(categoria);
        } catch (IllegalArgumentException e) {
            throw new CategoriaNaoEncontradaException();
        }
    }

    private void isEmpty(String categoria) {
        if(categoria == null || categoria.isEmpty()) {
            throw new CategoriaObrigatorioException();
        }
    }


}
