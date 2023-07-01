package br.com.appfastfood.pedido.dominio.servicos.portas;
import java.util.List;
import br.com.appfastfood.pedido.dominio.modelos.Pedido;
import br.com.appfastfood.pedido.infraestrutura.entidades.PedidoEntidade;


public interface PedidoServico {

    void criar(PedidoEntidade pedido);
    Boolean atualizar(Long id);
    Pedido buscarPedidoPorId(Long id);
    List<Pedido> listarTodosPedidos();
} 
