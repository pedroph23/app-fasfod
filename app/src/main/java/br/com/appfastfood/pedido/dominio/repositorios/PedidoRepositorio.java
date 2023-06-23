package br.com.appfastfood.pedido.dominio.repositorios;
import java.util.List;
import java.util.Optional;

import br.com.appfastfood.pedido.dominio.modelos.Pedido;
public interface PedidoRepositorio {
    void criar(Pedido pedido);
    Pedido atualizar(Pedido pedidoRequisicao);
    Optional<List<Pedido>> listarTodosOsPedidos();
    Pedido buscarPedidoPorId(Long id);
} 
