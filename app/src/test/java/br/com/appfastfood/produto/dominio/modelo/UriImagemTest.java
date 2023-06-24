package br.com.appfastfood.produto.dominio.modelo;
import static org.junit.jupiter.api.Assertions.*;

import br.com.appfastfood.produto.dominio.modelos.UriImagem;
import br.com.appfastfood.produto.exceptions.UriImagemFormatoInvalidoException;
import br.com.appfastfood.produto.exceptions.UriImagemObrigatorioException;
import org.junit.jupiter.api.Test;
public class UriImagemTest {

    @Test
    public void testConstrutorComUriImagemValida() {
        String uriImagem = "https://example.com/image.jpg";
        UriImagem uriImagemObjeto = new UriImagem(uriImagem);
        assertEquals(uriImagem, uriImagemObjeto.getUriImagem());
    }

    @Test
    public void testConstrutorComUriImagemNula() {
        assertThrows(UriImagemObrigatorioException.class, () -> new UriImagem(null));
    }

    @Test
    public void testConstrutorComUriImagemVazia() {
        assertThrows(UriImagemObrigatorioException.class, () -> new UriImagem(""));
    }

    @Test
    public void testConstrutorComUriImagemInvalida() {
        String uriImagem = "invalid-url";
        assertThrows(UriImagemFormatoInvalidoException.class, () -> new UriImagem(uriImagem));
    }
}
