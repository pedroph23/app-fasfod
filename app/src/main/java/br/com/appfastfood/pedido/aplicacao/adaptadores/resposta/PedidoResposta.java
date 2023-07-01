package br.com.appfastfood.pedido.aplicacao.adaptadores.resposta;
import lombok.Builder;
import lombok.Getter;
import java.math.BigDecimal;
import java.util.Map;

import br.com.appfastfood.cliente.dominio.modelos.Cliente;
import br.com.appfastfood.pedido.dominio.modelos.enums.StatusPedidoEnum;
import br.com.appfastfood.produto.aplicacao.adaptadores.resposta.ProdutoResposta;
import br.com.appfastfood.produto.dominio.modelos.Produto;
@Builder()
@Getter

public class PedidoResposta {
    
    private Map<ProdutoResposta, Long> produto;
    private String idCliente;
    private BigDecimal valorTotal;
    private String status;
}
