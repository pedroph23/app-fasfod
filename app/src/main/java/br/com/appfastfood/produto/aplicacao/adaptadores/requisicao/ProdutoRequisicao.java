package br.com.appfastfood.produto.aplicacao.adaptadores.requisicao;

import lombok.Builder;
import lombok.Getter;

import java.math.BigDecimal;
@Builder()
@Getter
public class ProdutoRequisicao {
    private Long id;
    private String nome;
    private Double preco;
    private String uriImagem;
    private String categoria;
    private String descricao;
}
