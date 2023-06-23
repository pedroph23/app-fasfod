package br.com.appfastfood.pedido.infraestrutura.entidades;
import java.math.BigDecimal;
import java.util.Map;

import br.com.appfastfood.cliente.dominio.modelos.Cliente;
import br.com.appfastfood.pedido.dominio.modelos.enums.StatusPedidoEnum;
import br.com.appfastfood.produto.dominio.modelos.Produto;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;



@Entity(name = "pedido")
public class PedidoEntidade { 
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    protected PedidoEntidade() {}

    private Map<Produto, Long> produto;
    private Cliente cliente;
    private BigDecimal valorTotal;
    private StatusPedidoEnum status;


    
    public PedidoEntidade(Long id , Map<Produto,Long> produto, Cliente cliente, BigDecimal valorTotal, StatusPedidoEnum status){
        this.id = id;
        this.produto = produto;
        this.cliente = cliente;
        this.valorTotal = valorTotal;
        this.status = status;
    }
    public PedidoEntidade(Map<Produto,Long> produto, Cliente cliente, BigDecimal valorTotal, StatusPedidoEnum status){
        this.produto = produto;
         this.cliente = cliente;
        this.valorTotal = valorTotal;
        this.status = status;
    }

    
    public Long getId() {
        return id;
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


   

} 
