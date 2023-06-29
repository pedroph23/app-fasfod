package br.com.appfastfood.produto.aplicacao.adaptadores.requisicao;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.math.BigDecimal;
@Builder()
@Getter
public class ProdutoRequisicao {
    private Long id;
    private String nome;
    private BigDecimal preco;
    private String uriImagem;
    private String categoria;
    private String descricao;
}
