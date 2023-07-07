package br.com.appfastfood.pedido.dominio.modelos;

import br.com.appfastfood.pedido.dominio.modelos.VO.Produto;
import br.com.appfastfood.pedido.dominio.modelos.enums.StatusPedidoEnum;

import java.util.List;

public class Pedido { 
    private List<Produto> produtos;
    private String cliente;
    private Double valorTotal;
    private StatusPedidoEnum status;
    private String tempoEspera;

    public Pedido(List<Produto> produtos, String cliente, Double valorTotal, StatusPedidoEnum status, String tempoEspera){
        this.produtos = produtos;
         this.cliente = cliente;
        this.valorTotal = valorTotal;
        this.status = status;
        this.tempoEspera = tempoEspera;
    }


    public List<Produto> getProdutos() {
        return produtos;
    }

    public String getCliente() {
        return cliente;
    }

    public Double getValorTotal() {
        return valorTotal;
    }

    public StatusPedidoEnum getStatus() {
        return status;
    }

    public String getTempoEspera() {
        return tempoEspera;
    }
}
