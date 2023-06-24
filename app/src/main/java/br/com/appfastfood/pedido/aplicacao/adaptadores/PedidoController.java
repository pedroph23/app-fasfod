package br.com.appfastfood.pedido.aplicacao.adaptadores;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.appfastfood.cliente.aplicacao.adaptadores.requisicao.RequisicaoExcecao;
import br.com.appfastfood.pedido.aplicacao.adaptadores.requisicao.AtualizarPedidoRequisicao;
import br.com.appfastfood.pedido.aplicacao.adaptadores.requisicao.PedidoRequisicao;
import br.com.appfastfood.pedido.aplicacao.adaptadores.resposta.PedidoResposta;
import br.com.appfastfood.pedido.dominio.modelos.Pedido;
import br.com.appfastfood.pedido.dominio.modelos.enums.StatusPedidoEnum;
import br.com.appfastfood.pedido.dominio.servicos.portas.PedidoServico;
import br.com.appfastfood.produto.aplicacao.adaptadores.resposta.ProdutoResposta;
import br.com.appfastfood.produto.dominio.modelos.Produto;
import br.com.appfastfood.produto.exceptions.CategoriaNaoEncontradaException;


@RestController
// @RequestMapping("/pedido")
public class PedidoController {
    private PedidoServico pedidoServico;

    public PedidoController(PedidoServico pedidoServico) {
        this.pedidoServico = pedidoServico;
    }

   @PostMapping("/pedido")
    public ResponseEntity<Object> criar(@RequestBody PedidoRequisicao pedidoRequisicao){
       try {
            
            Pedido pedido = new Pedido(
                pedidoRequisicao.getProduto(),
                pedidoRequisicao.getCliente(),
                pedidoRequisicao.getValorTotal(),
                pedidoRequisicao.getStatus()
            );
            
            this.pedidoServico.criar(pedido);

            // PedidoResposta pedidoResposta = PedidoResposta
            //         .builder()
            //         .nome(pedido.getProduto().)
            //         .preco(produto.getPreco().getPreco())
            //         .descricao(produto.getDescricao().getDescricao())
            //         .categoria(produto.getCategoria().name())
            //         .uriImagem(produto.getUriImagem().getUriImagem())
            //         .build();
            return ResponseEntity.status(HttpStatus.CREATED).body(pedido);

        } catch (IllegalArgumentException e) {
              RequisicaoExcecao jsonExcecao = new RequisicaoExcecao(e.getMessage(), HttpStatus.BAD_REQUEST.value());
               return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(jsonExcecao);
        }

    }

    @PostMapping("atualizar-status")
    public ResponseEntity<?> atualizarStatus(AtualizarPedidoRequisicao pedido){
        try {
        
           
           Pedido pedidoResultado = this.pedidoServico.atualizar(pedido);
           return ResponseEntity.status(HttpStatus.OK).body(pedidoResultado);
            
        } catch (IllegalArgumentException e) {
              RequisicaoExcecao jsonExcecao = new RequisicaoExcecao(e.getMessage(), HttpStatus.BAD_REQUEST.value());
               return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(jsonExcecao);
        }
    }

    @GetMapping("listar")
    public ResponseEntity ListarPedidos(){

        try {
            List<Pedido> pedido = this.pedidoServico.listarTodosPedidos();

            // List<ProdutoResposta> produtosResposta =  pedido.stream().map(pedido -> ProdutoResposta
            //         .builder()
            //         .nome(pedido.getNome().getNome())
            //         .preco(pedido.getPreco().getPreco())
            //         .descricao(pedido.getDescricao().getDescricao())
            //         .categoria(pedido.getCategoria().name())
            //         .uriImagem(pedido.getUriImagem().getUriImagem())
            //         .build()).toList();

            return ResponseEntity.status(HttpStatus.OK).body(pedido);
        } catch (CategoriaNaoEncontradaException e) {
            RequisicaoExcecao jsonExcecao = new RequisicaoExcecao(e.getMessage(), HttpStatus.BAD_REQUEST.value());
           // logger.aviso(jsonExcecao.toString());
           return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(jsonExcecao);
        }

    }

} 
