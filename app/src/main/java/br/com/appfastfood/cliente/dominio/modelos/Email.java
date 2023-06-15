package br.com.appfastfood.cliente.dominio.modelos;


public class Email {

    private String email;

    public String getEmail() {
        return email;
    }

    public Email(String email) {
        validarEmail(email);
        this.email = email;
    }

    private void validarEmail(String email) {
        // Lógica de validação do email
    }

}