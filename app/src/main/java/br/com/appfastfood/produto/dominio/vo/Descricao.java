package br.com.appfastfood.produto.dominio.vo;

import br.com.appfastfood.produto.exceptions.CamposObrigatorioException;

public class Descricao {
    private String descricao;
    public Descricao(String descricao) {
        this.descricao = descricao;
    }
    public String getDescricao() {
        return descricao;
    }
}