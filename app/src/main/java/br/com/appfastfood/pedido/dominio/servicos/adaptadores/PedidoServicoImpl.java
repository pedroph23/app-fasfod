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
    public Pedido atualizar(AtualizarPedidoRequisicao pedido) {
      Optional<PedidoEntidade> pedidoBusca = this.pedidoRepositorio.buscarPedidoPorId(pedido.getId());
      
      Pedido pedidoAtualizado = new Pedido(null, null, null, null);
       if (pedido.getStatus() == StatusPedidoEnum.EM_PREPARACAO) {
             pedidoAtualizado.setStatus(StatusPedidoEnum.PRONTO);
       } if (pedido.getStatus() == StatusPedidoEnum.PRONTO) {
             pedidoAtualizado.setStatus(StatusPedidoEnum.FINALIZADO);
       }
                
        return this.pedidoRepositorio.atualizar(pedidoAtualizado);
    }


    // @Override
    // public Optional<List<Pedido>> listarTodosOsPedidos() {
    //    return this.pedidoRepositorio.listarTodosOsPedidos();
    // }

    @Override
    public Pedido buscarPedidoPorId(Long id) {
        Optional<PedidoEntidade> pedidoBusca = this.pedidoRepositorio.buscarPedidoPorId(id);
        Optional<List<Produto>> produtoBusca = new ProdutoRepositorioImpl(null).buscarPorCategoria("null");
        Map<Produto, Long> listaProdutos = new HashMap<>();
        if (!pedidoBusca.isPresent()){
            //validar o retorno
        }
        BigDecimal valorTotal = BigDecimal.valueOf(0);
        for (Produto prod : produtoBusca.get()){
            listaProdutos.put(prod, 1L);
            valorTotal.add(prod.getPreco().getPreco());
        }
        Pedido pedidoRetorno = new Pedido(listaProdutos, null, pedidoBusca.get().getValorTotal(), StatusPedidoEnum.buscaEnumPorStatusString(pedidoBusca.get().getStatus()));
        return pedidoRetorno;
    }
    
    @Override
    public List<PedidoEntidade> listarTodosPedidos() {
        return this.pedidoRepositorio.listarTodosOsPedidos();
    }

}
