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
    //private BigDecimal valorTotal;
    //private StatusPedidoEnum status;
    public PedidoRequisicao(String idProduto, String idCliente, BigDecimal valorTotal, String quantidadeProduto) {
        this.idProduto = idProduto;
        this.idCliente = idCliente;
        this.valorTotal = valorTotal;
        this.quantidadeProduto = quantidadeProduto;
    }
   
    // private Map<Produto, Long> produto;
    // private Cliente cliente;
    // private BigDecimal valorTotal;
    // private StatusPedidoEnum status;

    // public PedidoRequisicao(Map<Produto,Long> produto,  Cliente cliente, BigDecimal valorTotal, String status) {
    //     this.produto = produto;
    //     this.cliente = cliente;
    //     this.valorTotal = BigDecimal.valueOf(0);
    //     this.status =  StatusPedidoEnum.recebido;
    // }


    

    // public Produto ProdutoMock(){
    //     return new Produto(new Nome("BigMac"),new Preco(BigDecimal.valueOf(10.10)),new UriImagem("http://blabla"),new Categoria(null).getCategoria(),new Descricao("2 hamburgues molho especial"));
    // }

    // public Cliente ClienteMock(){
    //    return null;
    //     //return new Cliente(new Nome("Lina Caike Pedro Filipe Marcus"), new Cpf("12345678900"), new Email("teste@gmail.com"));
    // }
}
