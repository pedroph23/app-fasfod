package br.com.appfastfood.pedido.aplicacao.adaptadores.requisicao;

import java.math.BigDecimal;

import br.com.appfastfood.cliente.dominio.modelos.Cliente;
import br.com.appfastfood.pedido.dominio.modelos.enums.StatusPedidoEnum;
import br.com.appfastfood.produto.dominio.modelos.Produto;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder()
@Getter
@Setter
public class PedidoRequisicao {
    private Produto produto;
    private Long quantidade;
    private Cliente cliente;
    private BigDecimal valorTotal;
    private String status;
}
