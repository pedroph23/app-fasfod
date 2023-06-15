package br.com.appfastfood.cliente.dominio.modelos;

import java.util.UUID;

public class Cliente {
    private UUID id;
    private Nome nome;
    private Cpf cpf;
    private Email email;


    public Cliente(Nome nome, Cpf cpf, Email email) {
        if (nome == null && cpf == null && email == null) {
            throw new IllegalArgumentException("Pelo menos um dos atributos (nome, cpf, email) deve ser preenchido");
        }
        this.id = UUID.randomUUID();
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
    }

    public UUID getId() {
        return id;
    }

    public String getNome() {
        return nome.getNome();
    }

    public String getCpf() {
        return cpf.getCpf();
    }

    public String getEmail() {
        return email.getEmail();
    }
}
