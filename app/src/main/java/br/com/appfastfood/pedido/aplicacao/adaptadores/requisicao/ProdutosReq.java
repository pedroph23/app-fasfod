package br.com.appfastfood.pedido.aplicacao.adaptadores.requisicao;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class ProdutosReq implements Serializable {

    private String idProduto;
    private String quantidadeProduto;



}
