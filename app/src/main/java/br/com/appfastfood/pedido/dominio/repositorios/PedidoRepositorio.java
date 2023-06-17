package br.com.appfastfood.pedido.dominio.repositorios;
import java.util.List;
import java.util.Optional;

import br.com.appfastfood.pedido.aplicacao.adaptadores.requisicao.PedidoRequisicao;
import br.com.appfastfood.pedido.dominio.modelos.Pedido;

public interface PedidoRepositorio {
    void criar(Pedido pedido);
    Pedido atualizar(PedidoRequisicao pedidoRequisicao);
    Optional<List<Pedido>> listarTodosOsPedidos();
} 
