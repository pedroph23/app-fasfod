package br.com.appfastfood.cliente.domain.model;


import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class Cpf {
    @Column(name = "cpf")
    private String cpf;

    // Construtor vazio para JPA
    protected Cpf() {
    }

    public Cpf(String cpf) {
        validarCpf(cpf);
        this.cpf = cpf;
    }

    private void validarCpf(String cpf) {
        if (cpf == null || cpf.isEmpty() || cpf.length() != 11 || !cpf.matches("\\d+")) {
            throw new IllegalArgumentException("CPF inválido");
        }
    }

    // getters
}