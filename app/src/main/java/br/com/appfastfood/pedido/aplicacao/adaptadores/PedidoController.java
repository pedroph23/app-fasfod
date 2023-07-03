package br.com.appfastfood.pedido.aplicacao.adaptadores;
import java.math.BigDecimal;
import java.util.List;

import org.hibernate.mapping.Map;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import br.com.appfastfood.cliente.aplicacao.adaptadores.requisicao.RequisicaoExcecao;
import br.com.appfastfood.pedido.aplicacao.adaptadores.requisicao.PedidoRequisicao;
import br.com.appfastfood.pedido.aplicacao.adaptadores.resposta.PedidoResposta;
import br.com.appfastfood.pedido.dominio.modelos.Pedido;
import br.com.appfastfood.pedido.dominio.servicos.portas.PedidoServico;
import br.com.appfastfood.pedido.exceptions.IDPedidoNaoEncontradoException;
import br.com.appfastfood.pedido.exceptions.PedidoJaFinalizadoException;
import br.com.appfastfood.pedido.infraestrutura.entidades.PedidoEntidade;
import br.com.appfastfood.produto.exceptions.CategoriaNaoEncontradaException;
import br.com.appfastfood.produto.exceptions.IDNaoEncontradoException;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;


@RestController
@RequestMapping("/pedidos")
@Tag(name = "Pedidos", description = "Tudo sobre pedidos")
public class PedidoController {
    private PedidoServico pedidoServico;

    public PedidoController(PedidoServico pedidoServico) {
        this.pedidoServico = pedidoServico;
    }

   @PostMapping
    @Operation(summary = "Cadastrar Pedido", description = "Funcionalidade de criar um pedido")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "pedido cadastrado com sucesso",
                    content = { @Content(mediaType = "application/json",
                    schema = @Schema(implementation = PedidoResposta.class)) }),
            @ApiResponse(responseCode = "400", description = "",
                    content = @Content(mediaType = "application/json",
                    schema = @Schema(implementation = RequisicaoExcecao.class)))})
    public ResponseEntity<Object> criar(@RequestBody PedidoRequisicao pedidoRequisicao){
       try {
            
            PedidoEntidade pedido = new PedidoEntidade(null, pedidoRequisicao.getIdProduto().toString(), pedidoRequisicao.getQuantidadeProduto().toString(), pedidoRequisicao.getIdCliente().toString(), BigDecimal.valueOf(0), "recebido","01:00");
            
            this.pedidoServico.criar(pedido);
            return ResponseEntity.status(HttpStatus.CREATED).body(pedido);

        } catch (IDNaoEncontradoException e) {
              RequisicaoExcecao jsonExcecao = new RequisicaoExcecao(e.getMessage(), HttpStatus.BAD_REQUEST.value());
               return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(jsonExcecao);
        }

    }

    @PutMapping("/atualizar-status")
     @Operation(summary = "Atualizar status do pedido", description = "Funcionalidade de atualizar o status do pedido passando o parametro 'id' do pedido")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Produto atualizado com sucesso",
                    content = { @Content() }),
            @ApiResponse(responseCode = "400", description = "",
                    content = @Content(mediaType = "application/json",
                    schema = @Schema(implementation = RequisicaoExcecao.class)))})
    public ResponseEntity<?> atualizarStatus(@RequestParam(value = "id") Long id){
        try {
            Pedido pedidoResultado = this.pedidoServico.atualizar(id);
            return ResponseEntity.status(HttpStatus.OK).body(pedidoResultado);
        } catch (IDPedidoNaoEncontradoException e) {
            RequisicaoExcecao jsonExcecao = new RequisicaoExcecao(e.getMessage(), HttpStatus.BAD_REQUEST.value());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(jsonExcecao);
        }catch(PedidoJaFinalizadoException e){
            RequisicaoExcecao jsonExcecao = new RequisicaoExcecao(e.getMessage(), HttpStatus.BAD_REQUEST.value());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(jsonExcecao);
        }
    }


    @GetMapping("/listarPorId")
    @Operation(summary = "Buscar pedidos por id", description = "Funcionalidade que retorna o pedido passando o parametro id do pedido")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Pedido filtrado com sucesso",
                    content = { @Content(mediaType = "application/json",
                    schema = @Schema(implementation = List.class, subTypes = { PedidoResposta.class }))}),
            @ApiResponse(responseCode = "400", description = "",
                    content = @Content(mediaType = "application/json",
                    schema = @Schema(implementation = RequisicaoExcecao.class)))})
    public ResponseEntity buscarPedidoPorID(@RequestParam(value = "id") Long id) throws JsonProcessingException {
        try {
            Pedido pedidoRetorno = this.pedidoServico.buscarPedidoPorId(id);
            ObjectMapper objectMapper = new ObjectMapper();
            String json = objectMapper.writeValueAsString(pedidoRetorno);
            return ResponseEntity.status(HttpStatus.OK).body(json);
        } catch (IDPedidoNaoEncontradoException e) {
            RequisicaoExcecao jsonExcecao = new RequisicaoExcecao(e.getMessage(), HttpStatus.BAD_REQUEST.value());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(jsonExcecao);
        }
        
    }

    @GetMapping("/listar-pedidos")
       @Operation(summary = "Buscar todos pedidos", description = "Funcionalidade que retorna todos pedidos")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Pedidos filtrado com sucesso",
                    content = { @Content(mediaType = "application/json",
                    schema = @Schema(implementation = List.class, subTypes = { PedidoResposta.class }))}),
            @ApiResponse(responseCode = "400", description = "",
                    content = @Content(mediaType = "application/json",
                    schema = @Schema(implementation = RequisicaoExcecao.class)))})    
    public ResponseEntity<Object> ListarPedidos() throws JsonProcessingException{
        try {
            List<Pedido> pedido = this.pedidoServico.listarTodosPedidos();
            ObjectMapper objectMapper = new ObjectMapper();
            String json = objectMapper.writeValueAsString(pedido);
           
            return ResponseEntity.status(HttpStatus.OK).body(json);
        } catch (CategoriaNaoEncontradaException e) {
            RequisicaoExcecao jsonExcecao = new RequisicaoExcecao(e.getMessage(), HttpStatus.BAD_REQUEST.value());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(jsonExcecao);
        }
    }
} 
