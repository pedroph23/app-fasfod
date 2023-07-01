package br.com.appfastfood.pedido.aplicacao.adaptadores.requisicao;

import java.math.BigDecimal;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class PedidoRequisicao {

    private String idProduto;
    private String idCliente;
    private BigDecimal valorTotal;
    private String quantidadeProduto;
     public PedidoRequisicao(String idProduto, String idCliente, BigDecimal valorTotal, String quantidadeProduto) {
        this.idProduto = idProduto;
        this.idCliente = idCliente;
        this.valorTotal = valorTotal;
        this.quantidadeProduto = quantidadeProduto;
    }
      

}
