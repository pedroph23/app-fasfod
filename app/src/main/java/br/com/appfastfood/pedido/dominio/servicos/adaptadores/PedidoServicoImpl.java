package br.com.appfastfood.pedido.dominio.servicos.adaptadores;

import br.com.appfastfood.pedido.aplicacao.adaptadores.requisicao.PedidoRequisicao;
import br.com.appfastfood.pedido.aplicacao.adaptadores.requisicao.ProdutosReq;
import br.com.appfastfood.pedido.dominio.modelos.Pedido;
import br.com.appfastfood.pedido.dominio.modelos.VO.Produto;
import br.com.appfastfood.pedido.dominio.modelos.enums.StatusPedidoEnum;
import br.com.appfastfood.pedido.dominio.repositorios.PedidoRepositorio;
import br.com.appfastfood.pedido.dominio.servicos.portas.PedidoServico;
import br.com.appfastfood.produto.dominio.servicos.portas.ProdutoServico;

import java.util.ArrayList;
import java.util.List;


public class PedidoServicoImpl implements PedidoServico{

    private final ProdutoServico produtoServicoImplInject;
    private final PedidoRepositorio pedidoRepositorio;

    public PedidoServicoImpl(PedidoRepositorio pedidoRepositorio, ProdutoServico produtoServicoImplInject ) {

        this.pedidoRepositorio = pedidoRepositorio;
        this.produtoServicoImplInject= produtoServicoImplInject;
    }

    @Override
    public void criar(PedidoRequisicao pedidoReq, String status, String tempo) {
        br.com.appfastfood.produto.dominio.modelos.Produto produtoBuscaId = null;
        Double valorTotal = 0.0;
        List<Produto> produtosVO = new ArrayList<Produto>();
        for(ProdutosReq produtoReq : pedidoReq.getProdutos()){
            Produto produtoVO = new Produto(produtoReq.getIdProduto(), produtoReq.getQuantidadeProduto());
            produtoBuscaId = produtoServicoImplInject.buscaProdutoPorId(Long.valueOf(produtoReq.getIdProduto()));
            valorTotal += produtoBuscaId.getPreco().getPreco() * Double.parseDouble(produtoReq.getQuantidadeProduto());
            produtosVO.add(produtoVO);
        }

        Pedido pedido = new Pedido(produtosVO, pedidoReq.getIdCliente(), valorTotal, StatusPedidoEnum.buscaEnumPorStatusString(status), tempo);

        this.pedidoRepositorio.criar(pedido);
    }
    @Override
    public Pedido atualizar(Long id) {
  
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
