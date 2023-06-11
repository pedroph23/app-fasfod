import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Email {
    @Column(name = "email")
    private String email;

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