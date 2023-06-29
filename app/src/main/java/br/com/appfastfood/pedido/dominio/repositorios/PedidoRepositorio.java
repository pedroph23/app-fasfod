package br.com.appfastfood.pedido.dominio.repositorios;
import java.util.List;
import java.util.Optional;

import br.com.appfastfood.pedido.dominio.modelos.Pedido;
import br.com.appfastfood.pedido.infraestrutura.entidades.PedidoEntidade;
public interface PedidoRepositorio {
    void criar(PedidoEntidade pedido);
    Pedido atualizar(Pedido pedidoRequisicao);
    List<Pedido> listarTodosOsPedidos();
    Optional<PedidoEntidade> buscarPedidoPorId(Long id);
} 
