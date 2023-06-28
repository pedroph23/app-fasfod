package br.com.appfastfood.pedido.infraestrutura.entidades;
import java.math.BigDecimal;
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
    
    private String idProduto;
    private String quantidadeProduto;
    private String clienteId;
    private BigDecimal valorTotal;
    private String status;


    public PedidoEntidade(Long id, String idProduto, String quantidadeProduto, String clienteId, BigDecimal valorTotal,
            String status) {
        this.id = id;
        this.idProduto = idProduto;
        this.quantidadeProduto = quantidadeProduto;
        this.clienteId = clienteId;
        this.valorTotal = valorTotal;
        this.status = status;
    }


    public Long getId() {
        return id;
    }


    public String getIdProduto() {
        return idProduto;
    }


    public String getQuantidadeProduto() {
        return quantidadeProduto;
    }


    public String getClienteId() {
        return clienteId;
    }


    public BigDecimal getValorTotal() {
        return valorTotal;
    }


    public String getStatus() {
        return status;
    }


} 
