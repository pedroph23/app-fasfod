package br.com.appfastfood.cliente.dominio.modelos;

public class Nome {
    private String nome;
    public Nome(String nome) {
        validarNome(nome);
        this.nome = nome;
    }

    private void validarNome(String nome) {
        if (nome == null || nome.isEmpty()) {
            throw new IllegalArgumentException("Nome inválido");
        }
    }

    public String getNome() {
        return nome;
    }

}