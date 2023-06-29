package br.com.appfastfood.pedido.dominio.servicos.portas;
import java.util.List;
import java.util.Optional;

import br.com.appfastfood.pedido.aplicacao.adaptadores.requisicao.AtualizarPedidoRequisicao;
import br.com.appfastfood.pedido.dominio.modelos.Pedido;
import br.com.appfastfood.pedido.infraestrutura.entidades.PedidoEntidade;


public interface PedidoServico {
    void criar(PedidoEntidade pedido);
    Pedido atualizar(AtualizarPedidoRequisicao pedido);
    // Optional<List<Pedido>> listarTodosOsPedidos();
    Pedido buscarPedidoPorId(Long id);
    List<Pedido> listarTodosPedidos();
} 
