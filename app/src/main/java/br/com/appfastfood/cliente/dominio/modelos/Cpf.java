package br.com.appfastfood.cliente.dominio.modelos;
public class Cpf {
    private String cpf;

    public String getCpf() {
        return cpf;
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


}