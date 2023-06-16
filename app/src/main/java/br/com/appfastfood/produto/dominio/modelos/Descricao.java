package br.com.appfastfood.produto.dominio.modelos;

import br.com.appfastfood.produto.exceptions.DescricaoObrigatorioException;

public class Descricao {
    private String descricao;
    public Descricao(String descricao) {
        this.isValid(descricao);
        this.descricao = descricao;
    }
    public String getDescricao() {
        isValid(descricao);
        return descricao;
    }
    private void isValid(String descricao) {
        if(descricao.isEmpty()) {
            throw new DescricaoObrigatorioException();
        }
    }
}