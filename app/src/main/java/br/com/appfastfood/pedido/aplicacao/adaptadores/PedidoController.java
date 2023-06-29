package br.com.appfastfood.pedido.aplicacao.adaptadores;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.appfastfood.cliente.aplicacao.adaptadores.requisicao.RequisicaoExcecao;
import br.com.appfastfood.pedido.aplicacao.adaptadores.requisicao.AtualizarPedidoRequisicao;
import br.com.appfastfood.pedido.aplicacao.adaptadores.requisicao.PedidoRequisicao;
import br.com.appfastfood.pedido.dominio.modelos.Pedido;
import br.com.appfastfood.pedido.dominio.servicos.portas.PedidoServico;
import br.com.appfastfood.pedido.infraestrutura.entidades.PedidoEntidade;
import br.com.appfastfood.produto.dominio.modelos.Produto;
import br.com.appfastfood.produto.exceptions.CategoriaNaoEncontradaException;
import br.com.appfastfood.produto.infraestrutura.ProdutoRepositorioImpl;
import io.swagger.v3.oas.annotations.tags.Tag;


@RestController
//@RequestMapping("/pedidos")
//@Tag(name = "Pedidos", description = "Tudo sobre pedidos")
public class PedidoController {
    private PedidoServico pedidoServico;

    public PedidoController(PedidoServico pedidoServico) {
        this.pedidoServico = pedidoServico;
    }

   @PostMapping("/pedidos")
    public ResponseEntity<Object> criar(@RequestBody PedidoRequisicao pedidoRequisicao){
       try {
            
            PedidoEntidade pedido = new PedidoEntidade(null, pedidoRequisicao.getIdProduto().toString(), pedidoRequisicao.getQuantidadeProduto().toString(), pedidoRequisicao.getIdCliente().toString(), BigDecimal.valueOf(10), "recebido");
            
            this.pedidoServico.criar(pedido);
            return ResponseEntity.status(HttpStatus.CREATED).body(pedido);

        } catch (IllegalArgumentException e) {
              RequisicaoExcecao jsonExcecao = new RequisicaoExcecao(e.getMessage(), HttpStatus.BAD_REQUEST.value());
               return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(jsonExcecao);
        }

    }

    @PostMapping("{id}")
    public ResponseEntity<?> atualizarStatus(AtualizarPedidoRequisicao pedido){
        try {
           Pedido pedidoResultado = this.pedidoServico.atualizar(pedido);
           return ResponseEntity.status(HttpStatus.OK).body(pedidoResultado);
            
        } catch (IllegalArgumentException e) {
              RequisicaoExcecao jsonExcecao = new RequisicaoExcecao(e.getMessage(), HttpStatus.BAD_REQUEST.value());
               return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(jsonExcecao);
        }
    }

    @GetMapping("/listar")
    public ResponseEntity<Object> ListarPedidos(){
        try {
            List<Pedido> pedido = this.pedidoServico.listarTodosPedidos();
            // List<Produto> produtosBusca = new ArrayList<>();
            // for (Pedido pedidoBusca : pedido){
            //     String[] idsProdutos = pedidoBusca.getIdProduto().split(",");
            //     for (String id : idsProdutos){
            //         Produto produtoBuscaId = new ProdutoRepositorioImpl(null).buscarProdutoPorId(Long.parseLong(id));
            //         produtosBusca.add(produtoBuscaId);
            //     }
            // }

            return ResponseEntity.status(HttpStatus.OK).body(pedido);
        } catch (CategoriaNaoEncontradaException e) {
            RequisicaoExcecao jsonExcecao = new RequisicaoExcecao(e.getMessage(), HttpStatus.BAD_REQUEST.value());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(jsonExcecao);
        }
    }
} 
