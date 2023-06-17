package br.com.appfastfood.pedido.dominio.modelos;
import java.math.BigDecimal;
import br.com.appfastfood.cliente.dominio.modelos.Cliente;
import br.com.appfastfood.pedido.dominio.modelos.enums.StatusPedidoEnum;
import br.com.appfastfood.produto.dominio.modelos.Produto;

public class Pedido { 
    private Produto produto;
    private Long quantidade;
    private Cliente cliente;
    private BigDecimal valorTotal;
    private StatusPedidoEnum status;

    public Pedido(Produto produto, Long quantidade, Cliente cliente, BigDecimal valorTotal, StatusPedidoEnum status){
        this.produto = produto;
        this.quantidade = quantidade;
        this.cliente = cliente;
        this.valorTotal = valorTotal;
        this.status = status;
    }

    public Produto getProduto() {
        return produto;
    }

    public Long getQuantidade() {
        return quantidade;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public BigDecimal getValorTotal() {
        return valorTotal;
    }

    public StatusPedidoEnum getStatus() {
        return status;
    }

    public void atualizarValorTotalPedido(BigDecimal valorTotal) {
        this.valorTotal = valorTotal;
    }

} 
