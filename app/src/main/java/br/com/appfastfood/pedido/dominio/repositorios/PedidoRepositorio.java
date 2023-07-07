package br.com.appfastfood.pedido.dominio.repositorios;

import br.com.appfastfood.pedido.dominio.modelos.Pedido;
import br.com.appfastfood.pedido.infraestrutura.entidades.PedidoEntidade;

import java.util.List;

public interface PedidoRepositorio {
    void criar(Pedido pedido);
    Pedido atualizar(Long id) ;
    List<Pedido> listarTodosOsPedidos();
    Pedido buscarPedidoPorId(Long id);
    Boolean realizarPagamento();
} 
