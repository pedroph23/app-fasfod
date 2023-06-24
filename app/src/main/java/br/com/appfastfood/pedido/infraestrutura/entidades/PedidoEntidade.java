package br.com.appfastfood.pedido.infraestrutura.entidades;
import java.math.BigDecimal;
import java.util.Map;
import java.util.UUID;

import br.com.appfastfood.cliente.dominio.modelos.Cliente;
import br.com.appfastfood.cliente.infraestrutura.entidades.EntidadeCliente;
import br.com.appfastfood.pedido.dominio.modelos.enums.StatusPedidoEnum;
import br.com.appfastfood.produto.dominio.modelos.Produto;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;



@Entity(name = "pedido")
public class PedidoEntidade { 
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    protected PedidoEntidade() {}
    
    private Long idProduto;
    private UUID clienteId;
    private BigDecimal valorTotal;
    private String status;


    public PedidoEntidade(Long id, Long idProduto, UUID clienteId, BigDecimal valorTotal, String status) {
        this.id = id;
        this.idProduto = idProduto;
        this.clienteId = clienteId;
        this.valorTotal = valorTotal;
        this.status = status;
    }


    public Long getId() {
        return id;
    }


    public Long getIdProduto() {
        return idProduto;
    }


    public UUID getClienteId() {
        return clienteId;
    }


    public BigDecimal getValorTotal() {
        return valorTotal;
    }


    public String getStatus() {
        return status;
    }

} 
