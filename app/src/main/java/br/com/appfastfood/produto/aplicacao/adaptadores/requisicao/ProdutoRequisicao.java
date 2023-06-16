package br.com.appfastfood.produto.aplicacao.adaptadores.requisicao;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.math.BigDecimal;
@AllArgsConstructor()
@Getter
public class ProdutoRequisicao {
    private Long id;
    private String nome;
    private BigDecimal preco;
    private String uriImagem;
    private Enum categoria;
    private String descricao;
}
