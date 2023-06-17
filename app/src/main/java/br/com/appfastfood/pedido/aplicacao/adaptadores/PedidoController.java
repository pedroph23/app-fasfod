package br.com.appfastfood.pedido.aplicacao.adaptadores;

import java.math.BigDecimal;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.appfastfood.cliente.dominio.modelos.Cliente;
import br.com.appfastfood.cliente.dominio.modelos.Cpf;
import br.com.appfastfood.cliente.dominio.modelos.Email;
import br.com.appfastfood.pedido.aplicacao.adaptadores.requisicao.PedidoRequisicao;
import br.com.appfastfood.pedido.dominio.modelos.Pedido;
import br.com.appfastfood.pedido.dominio.modelos.enums.StatusPedidoEnum;
import br.com.appfastfood.pedido.dominio.servicos.portas.PedidoServico;
import br.com.appfastfood.produto.dominio.modelos.Categoria;
import br.com.appfastfood.produto.dominio.modelos.Descricao;
import br.com.appfastfood.produto.dominio.modelos.Nome;
import br.com.appfastfood.produto.dominio.modelos.Preco;
import br.com.appfastfood.produto.dominio.modelos.Produto;
import br.com.appfastfood.produto.dominio.modelos.UriImagem;

@RestController
@RequestMapping("/pedido")
public class PedidoController {
    private PedidoServico pedidoServico;

    public PedidoController(PedidoServico pedidoServico) {
        this.pedidoServico = pedidoServico;
    }

    @PostMapping
    public ResponseEntity<Object> criar(@RequestBody PedidoRequisicao pedidoRequisicao){
        Pedido pedido = new Pedido(
            pedidoRequisicao.ProdutoMock(),
            pedidoRequisicao.getQuantidade(),
            pedidoRequisicao.ClienteMock(),
            BigDecimal.valueOf(10.10),
            StatusPedidoEnum.emPreparacao
        );

        this.pedidoServico.criar(pedido);
        return ResponseEntity.status(HttpStatus.CREATED).body(pedido);
    }

    @PostMapping("atualizar-pedido")
    public ResponseEntity<?> atualizar(PedidoRequisicao pedidoRequisicao){
        Pedido pedidoResultado = this.pedidoServico.atualizar(pedidoRequisicao);
        return ResponseEntity.status(HttpStatus.OK).body(pedidoResultado);
    }
} 
