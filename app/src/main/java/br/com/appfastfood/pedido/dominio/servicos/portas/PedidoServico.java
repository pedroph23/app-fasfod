package br.com.appfastfood.pedido.dominio.servicos.portas;
import java.util.List;
import java.util.Optional;

import br.com.appfastfood.pedido.aplicacao.adaptadores.requisicao.AtualizarPedidoRequisicao;
import br.com.appfastfood.pedido.dominio.modelos.Pedido;


public interface PedidoServico {
    void criar(Pedido pedido);
    Pedido atualizar(AtualizarPedidoRequisicao pedido);
    // Optional<List<Pedido>> listarTodosOsPedidos();
    Pedido buscarPedidoPorId(Long id);
    List<Pedido> listarTodosPedidos();
} 
