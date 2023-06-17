// package br.com.appfastfood.pedido.aplicacao.adaptadores;

// import java.math.BigDecimal;

// import org.springframework.http.ResponseEntity;
// import org.springframework.web.bind.annotation.PostMapping;
// import org.springframework.web.bind.annotation.RequestBody;
// import org.springframework.web.bind.annotation.RequestMapping;
// import org.springframework.web.bind.annotation.RestController;

// import br.com.appfastfood.cliente.dominio.modelos.Cliente;
// import br.com.appfastfood.pedido.aplicacao.adaptadores.requisicao.PedidoRequisicao;
// import br.com.appfastfood.pedido.dominio.modelos.Pedido;
// import br.com.appfastfood.pedido.dominio.modelos.enums.StatusPedidoEnum;
// import br.com.appfastfood.pedido.dominio.servicos.portas.PedidoServico;
// import br.com.appfastfood.produto.dominio.modelos.Produto;

// @RestController
// @RequestMapping("/pedido")
// public class PedidoController {
//     private PedidoServico pedidoServico;

//     public PedidoController(PedidoServico pedidoServico) {
//         this.pedidoServico = pedidoServico;
//     }

//     @PostMapping
//     public ResponseEntity<Object> criar(@RequestBody PedidoRequisicao pedidoRequisicao){
//         Pedido pedido = new Pedido(
//             new Produto(null, null, null, null, null),
//             new Long(pedidoRequisicao.getQuantidade()),
//             new Cliente(null, null, null),
//             new BigDecimal(null, 0, 0, null),
//             ""new StatusPedidoEnum(pedidoRequisicao.getStatus()).""
//         );

//         this.pedidoServico.criar(pedido);
//     }
// } 
