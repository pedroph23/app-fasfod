package br.com.appfastfood.pedido.dominio.servicos.adaptadores;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import br.com.appfastfood.pedido.aplicacao.adaptadores.requisicao.AtualizarPedidoRequisicao;
import br.com.appfastfood.pedido.dominio.modelos.Pedido;
import br.com.appfastfood.pedido.dominio.modelos.enums.StatusPedidoEnum;
import br.com.appfastfood.pedido.dominio.repositorios.PedidoRepositorio;
import br.com.appfastfood.pedido.dominio.servicos.portas.PedidoServico;
import br.com.appfastfood.pedido.infraestrutura.entidades.PedidoEntidade;
import br.com.appfastfood.produto.dominio.modelos.Produto;
import br.com.appfastfood.produto.infraestrutura.ProdutoRepositorioImpl;


public class PedidoServicoImpl implements PedidoServico{

    private final PedidoRepositorio pedidoRepositorio;

    public PedidoServicoImpl(PedidoRepositorio pedidoRepositorio) {
        this.pedidoRepositorio = pedidoRepositorio;
    }

    @Override
    public void criar(PedidoEntidade pedido) {
           
        this.pedidoRepositorio.criar(pedido);
    }
    @Override
    public Boolean atualizar(Long id) {
  
     return this.pedidoRepositorio.atualizar(id);
    }

    @Override
    public Pedido buscarPedidoPorId(Long id) {
       return this.pedidoRepositorio.buscarPedidoPorId(id);
    }
    
    @Override
    public List<Pedido> listarTodosPedidos() {
        return this.pedidoRepositorio.listarTodosOsPedidos();
    }

}
