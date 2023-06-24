package br.com.appfastfood.pedido.dominio.servicos.adaptadores;

import java.util.List;
import java.util.Optional;

import br.com.appfastfood.pedido.aplicacao.adaptadores.requisicao.AtualizarPedidoRequisicao;
import br.com.appfastfood.pedido.aplicacao.adaptadores.requisicao.PedidoRequisicao;
import br.com.appfastfood.pedido.dominio.modelos.Pedido;
import br.com.appfastfood.pedido.dominio.modelos.enums.StatusPedidoEnum;
import br.com.appfastfood.pedido.dominio.repositorios.PedidoRepositorio;
import br.com.appfastfood.pedido.dominio.servicos.portas.PedidoServico;
import br.com.appfastfood.produto.dominio.modelos.Produto;


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
    public Pedido atualizar(AtualizarPedidoRequisicao pedido) {
      Pedido pedidoAtualizado = this.pedidoRepositorio.buscarPedidoPorId(pedido.getId());
     
       if (pedido.getStatus() == StatusPedidoEnum.emPreparacao) {
             pedidoAtualizado.setStatus(StatusPedidoEnum.pronto);
       } if (pedido.getStatus() == StatusPedidoEnum.pronto) {
             pedidoAtualizado.setStatus(StatusPedidoEnum.finalizado);
       }
                
        return this.pedidoRepositorio.atualizar(pedidoAtualizado);
    }


    // @Override
    // public Optional<List<Pedido>> listarTodosOsPedidos() {
    //    return this.pedidoRepositorio.listarTodosOsPedidos();
    // }

    @Override
    public Pedido buscarPedidoPorId(Long id) {
        return this.pedidoRepositorio.buscarPedidoPorId(id);
    }
    
    @Override
    public List<Pedido> listarTodosPedidos() {
        return this.pedidoRepositorio.listarTodosOsPedidos().get();
    }

}
