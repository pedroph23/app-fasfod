package br.com.appfastfood.cliente.domain.model; 
 

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Embeddable
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Embedded
    private Nome nome;
    @Embedded
    private Cpf cpf;
    @Embedded
    private Email email;

    protected Cliente() {
        // Construtor vazio para uso do JPA
    }

    public Cliente(Nome nome, Cpf cpf, Email email) {
        if (nome == null && cpf == null && email == null) {
            throw new IllegalArgumentException("Pelo menos um dos atributos (nome, cpf, email) deve ser preenchido");
        }
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
    }

    public Long getId() {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cliente cliente = (Cliente) o;
        return Objects.equals(cpf, cliente.cpf);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cpf);
    }
}
