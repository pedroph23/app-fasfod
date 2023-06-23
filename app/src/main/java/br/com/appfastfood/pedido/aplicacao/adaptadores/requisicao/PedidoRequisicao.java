package br.com.appfastfood.pedido.aplicacao.adaptadores.requisicao;

import java.math.BigDecimal;
import java.util.Map;

import br.com.appfastfood.cliente.dominio.modelos.Cliente;
import br.com.appfastfood.cliente.dominio.modelos.Cpf;
import br.com.appfastfood.cliente.dominio.modelos.Email;
import br.com.appfastfood.pedido.dominio.modelos.enums.StatusPedidoEnum;
import br.com.appfastfood.produto.dominio.modelos.Categoria;
import br.com.appfastfood.produto.dominio.modelos.Descricao;
import br.com.appfastfood.produto.dominio.modelos.Nome;
import br.com.appfastfood.produto.dominio.modelos.Preco;
import br.com.appfastfood.produto.dominio.modelos.Produto;
import br.com.appfastfood.produto.dominio.modelos.UriImagem;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class PedidoRequisicao {
    private Map<Produto, Long> produto;
    private Cliente cliente;
    private BigDecimal valorTotal;
    private StatusPedidoEnum status;

    public PedidoRequisicao(Map<Produto,Long> produto,  Cliente cliente, BigDecimal valorTotal, String status) {
        this.produto = produto;
        this.cliente = cliente;
        this.valorTotal = BigDecimal.valueOf(0);
        this.status =  StatusPedidoEnum.recebido;
    }


    

    // public Produto ProdutoMock(){
    //     return new Produto(new Nome("BigMac"),new Preco(BigDecimal.valueOf(10.10)),new UriImagem("http://blabla"),new Categoria(null).getCategoria(),new Descricao("2 hamburgues molho especial"));
    // }

    // public Cliente ClienteMock(){
    //    return null;
    //     //return new Cliente(new Nome("Lina Caike Pedro Filipe Marcus"), new Cpf("12345678900"), new Email("teste@gmail.com"));
    // }
}
