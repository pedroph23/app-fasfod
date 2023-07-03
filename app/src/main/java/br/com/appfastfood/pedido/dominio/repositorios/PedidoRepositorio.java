package br.com.appfastfood.pedido.dominio.repositorios;
import java.util.List;
import br.com.appfastfood.pedido.dominio.modelos.Pedido;
import br.com.appfastfood.pedido.infraestrutura.entidades.PedidoEntidade;

public interface PedidoRepositorio {
    void criar(PedidoEntidade pedido);
    Pedido atualizar(Long id) ;
    List<Pedido> listarTodosOsPedidos();
    Pedido buscarPedidoPorId(Long id);
} 
