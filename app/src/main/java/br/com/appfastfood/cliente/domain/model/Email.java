package br.com.appfastfood.cliente.domain.model;


import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class Email {
    @Column(name = "email")
    private String email;

    public String getEmail() {
        return email;
    }

    // Construtor vazio para JPA
    protected Email() {
    }

    public Email(String email) {
        validarEmail(email);
        this.email = email;
    }

    private void validarEmail(String email) {
        // Lógica de validação do email
    }

    // getters
}