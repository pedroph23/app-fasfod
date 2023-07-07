 import br.com.appfastfood.pedido.aplicacao.adaptadores.PedidoController;
 import org.junit.jupiter.api.BeforeEach;
 import org.junit.jupiter.api.Test;
 import org.mockito.Mock;
 import org.mockito.MockitoAnnotations;
 import org.springframework.http.HttpStatus;
 import org.springframework.http.ResponseEntity;

 import br.com.appfastfood.cliente.aplicacao.adaptadores.requisicao.RequisicaoExcecao;
 import br.com.appfastfood.pedido.aplicacao.adaptadores.requisicao.PedidoRequisicao;
 import br.com.appfastfood.pedido.dominio.servicos.portas.PedidoServico;
 import br.com.appfastfood.pedido.infraestrutura.entidades.PedidoEntidade;
 import br.com.appfastfood.produto.exceptions.IDNaoEncontradoException;

 import static org.junit.jupiter.api.Assertions.*;
 import static org.mockito.Answers.valueOf;
 import static org.mockito.Mockito.*;

 import java.math.BigDecimal;

 public class PedidoControllerTest {

     private PedidoController pedidoController;

     @Mock
     private PedidoServico pedidoServicoMock;

     @BeforeEach
     public void setUp() {
         MockitoAnnotations.openMocks(this);
         pedidoController = new PedidoController(pedidoServicoMock);
     }

     @Test
     public void criar_DeveRetornarStatus201_QuandoPedidoCriadoComSucesso() {
         // Defina os objetos de teste e comportamento do mock
         PedidoRequisicao pedidoRequisicao = new PedidoRequisicao("1", "12345678999", BigDecimal.valueOf(10), "1");

         // Configurar o comportamento do mock
         //when(pedidoServicoMock.criar(any(PedidoEntidade.class))).thenReturn(new PedidoEntidade(null, null, null, null, null, null, null));

         // Executar o método a ser testado
         ResponseEntity<Object> response = pedidoController.criar(pedidoRequisicao);

         // Verificar os resultados
         assertEquals(HttpStatus.CREATED, response.getStatusCode());
         verify(pedidoServicoMock, times(1)).criar(any(PedidoEntidade.class));
     }

     @Test
     public void criar_DeveRetornarStatus400_QuandoProdutoIDNaoEncontradoExceptionLancada() {
         // Definir objetos de teste e comportamento do mock
         PedidoRequisicao pedidoRequisicao = new PedidoRequisicao("1", "12345678999", BigDecimal.valueOf(10), "1");

         doAnswer(invocation -> {
             throw new IDNaoEncontradoException();
         }).when(pedidoServicoMock).criar(any(PedidoEntidade.class));

         // Executar o método a ser testado
         ResponseEntity<Object> response = pedidoController.criar(pedidoRequisicao);

         // Verificar os resultados
         assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
         assertEquals(RequisicaoExcecao.class, response.getBody().getClass());
         //assertEquals("ID não encontrado", ((RequisicaoExcecao) response.getBody()).getMessage());
     }

     // Escreva testes para os demais métodos da classe PedidoController

     // Exemplo:
     @Test
     public void atualizarStatus_DeveRetornarStatus200_QuandoStatusAtualizadoComSucesso() {
         // Implementar o teste para o método atualizarStatus
     }

     // ...
 }