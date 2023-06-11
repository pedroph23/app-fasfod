package br.com.appfastfood.cliente.domain.model;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;



@Embeddable
public class Nome {
    @Column(name = "nome")
    private String nome;

    // Construtor vazio para JPA
    protected Nome() {
    }

    public Nome(String nome) {
        validarNome(nome);
        this.nome = nome;
    }

    private void validarNome(String nome) {
        if (nome == null || nome.isEmpty()) {
            throw new IllegalArgumentException("Nome inválido");
        }
    }

    // getters
}