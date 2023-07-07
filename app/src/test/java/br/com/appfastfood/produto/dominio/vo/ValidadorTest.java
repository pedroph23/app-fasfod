package br.com.appfastfood.produto.dominio.vo;
import br.com.appfastfood.produto.dominio.vo.enums.CategoriaEnum;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class ValidacoesTest {

    @Test
    void validaTamanhoMaximoDoCampo() {
        String campo = "Hello, World!";
        int tamanhoMaximo = 10;

        boolean resultado = Validacoes.validaTamanhoMaximoDoCampo(campo, tamanhoMaximo);

        assertTrue(resultado);
    }


}
