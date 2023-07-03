package br.com.appfastfood.pedido.dominio.modelos;
import java.math.BigDecimal;
import java.util.Map;
import br.com.appfastfood.cliente.dominio.modelos.Cliente;
import br.com.appfastfood.pedido.aplicacao.adaptadores.resposta.PedidoResposta;
import br.com.appfastfood.pedido.dominio.modelos.enums.StatusPedidoEnum;
import br.com.appfastfood.produto.aplicacao.adaptadores.resposta.ProdutoResposta;
import br.com.appfastfood.produto.dominio.modelos.Produto;

public class Pedido { 
    private Map<Produto, Long> produto;
    private Cliente cliente;
    private BigDecimal valorTotal;
    private StatusPedidoEnum status;
    private String tempoEspera;
    private ProdutoResposta resp;

    public Pedido(Map<Produto,Long> produto, Cliente cliente, BigDecimal valorTotal, StatusPedidoEnum status, String tempoEspera){
        this.produto = produto;
         this.cliente = cliente;
        this.valorTotal = valorTotal;
        this.status = status;
        this.tempoEspera = tempoEspera;
    }

    public Map<Produto, Long> getProduto() {
        return produto;
    }

    public void setProduto(Map<Produto, Long> produto) {
        this.produto = produto;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public BigDecimal getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(BigDecimal valorTotal) {
        this.valorTotal = valorTotal;
    }

    public StatusPedidoEnum getStatus() {
        return status;
    }

    public void setStatus(StatusPedidoEnum status) {
        this.status = status;
    }

    public String getTempoEspera() {
        return tempoEspera;
    }

  

   

} 
