package br.com.appfastfood.pedido.aplicacao.adaptadores.requisicao;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;


@Getter
@Setter

public class PedidoRequisicao implements Serializable {


    private List<ProdutosReq> produtos;
    private String idCliente;
    private Double valorTotal;

     public PedidoRequisicao(List<ProdutosReq> produtos, String idCliente, Double valorTotal) {
        this.idCliente = idCliente;
        this.valorTotal = valorTotal;
        this.produtos = produtos;

    }
}
