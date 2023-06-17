package br.com.appfastfood.pedido.dominio.servicos.portas;

import java.util.List;
import java.util.Optional;

import br.com.appfastfood.pedido.dominio.modelos.Pedido;

public interface PedidoServico {
    void criar(Pedido pedido);
    void atualizar(Long id, Pedido pedido);
    Optional<List<Pedido>> listarTodosOsPedidos();
} 
