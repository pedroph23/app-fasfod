package br.com.appfastfood.pedido.dominio.servicos.adaptadores;

import java.util.List;
import java.util.Optional;

import br.com.appfastfood.pedido.aplicacao.adaptadores.requisicao.PedidoRequisicao;
import br.com.appfastfood.pedido.dominio.modelos.Pedido;
import br.com.appfastfood.pedido.dominio.repositorios.PedidoRepositorio;
import br.com.appfastfood.pedido.dominio.servicos.portas.PedidoServico;


public class PedidoServicoImpl implements PedidoServico{

    private final PedidoRepositorio pedidoRepositorio;

    public PedidoServicoImpl(PedidoRepositorio pedidoRepositorio) {
        this.pedidoRepositorio = pedidoRepositorio;
    }

    @Override
    public void criar(Pedido pedido) {
           
        this.pedidoRepositorio.criar(pedido);
    }
    @Override
    public Pedido atualizar(Pedido pedidoRequisicao) {
        Pedido pedidoAlterado = this.pedidoRepositorio.atualizar(pedidoRequisicao);
        return pedidoAlterado;
    }


    @Override
    public Optional<List<Pedido>> listarTodosOsPedidos() {
       return this.pedidoRepositorio.listarTodosOsPedidos();
    }

    @Override
    public Pedido buscarPedidoPorId(Long id) {
        return this.pedidoRepositorio.buscarPedidoPorId(id);
    }
}
