package br.com.appfastfood.produto.dominio.modelo;

import br.com.appfastfood.produto.dominio.modelos.Nome;
import br.com.appfastfood.produto.exceptions.NomeObrigatorioException;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class NomeTest {
    @Test
    public void testConstrutorComNomeValido() {
        String nome = "João";
        Nome nomeObjeto = new Nome(nome);
        assertEquals(nome, nomeObjeto.getNome());
    }

    @Test
    public void testConstrutorComNomeNulo() {
        assertThrows(NomeObrigatorioException.class, () -> new Nome(null));
    }

    @Test
    public void testConstrutorComNomeVazio() {
        assertThrows(NomeObrigatorioException.class, () -> new Nome(""));
    }

}
