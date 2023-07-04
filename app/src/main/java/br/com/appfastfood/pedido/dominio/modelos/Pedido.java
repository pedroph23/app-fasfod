package br.com.appfastfood.pedido.dominio.modelos;
import java.math.BigDecimal;
import java.util.Map;
import br.com.appfastfood.pedido.dominio.modelos.enums.StatusPedidoEnum;
import br.com.appfastfood.produto.dominio.modelos.Produto;

public class Pedido { 
    private Map<Produto, Long> produto;
    private String cliente;
    private BigDecimal valorTotal;
    private StatusPedidoEnum status;
    private String tempoEspera;

    public Pedido(Map<Produto,Long> produto, String cliente, BigDecimal valorTotal, StatusPedidoEnum status, String tempoEspera){
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

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
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

    public void setTempoEspera(String tempoEspera) {
        this.tempoEspera = tempoEspera;
    }

} 
