package br.com.appfastfood.produto.dominio.modelos;

import br.com.appfastfood.produto.exceptions.NomeObrigatorioException;

public class Nome {
    private String nome;
    public Nome(String nome) {
        this.isValid(nome);
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }
    private void isValid(String nome) {
        if(nome.isEmpty()) {
            throw new NomeObrigatorioException();
        }
    }


}
