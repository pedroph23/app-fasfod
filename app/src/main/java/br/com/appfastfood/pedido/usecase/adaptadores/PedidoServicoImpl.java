package br.com.appfastfood.pedido.usecase.adaptadores;

import br.com.appfastfood.configuracoes.execption.BadRequestException;
import br.com.appfastfood.pedido.aplicacao.adaptadores.requisicao.PedidoRequisicao;
import br.com.appfastfood.pedido.aplicacao.adaptadores.requisicao.ProdutosReq;
import br.com.appfastfood.pedido.dominio.modelos.Pedido;
import br.com.appfastfood.pedido.dominio.modelos.VO.ProdutoVO;
import br.com.appfastfood.pedido.dominio.modelos.enums.StatusPagamentoEnum;
import br.com.appfastfood.pedido.dominio.modelos.enums.StatusPedidoEnum;
import br.com.appfastfood.pedido.dominio.repositorios.PedidoRepositorio;
import br.com.appfastfood.pedido.exceptions.ExceptionsMessages;
import br.com.appfastfood.pedido.usecase.portas.PedidoServico;
import br.com.appfastfood.produto.dominio.modelos.Produto;
import br.com.appfastfood.produto.usecase.portas.ProdutoServico;

import java.util.ArrayList;
import java.util.List;

public class PedidoServicoImpl implements PedidoServico {

    private final PedidoRepositorio pedidoRepositorio;
    private final ProdutoServico produtoServicoImplInject;

//    private final PagamentoServico pagamentoServico;

    public PedidoServicoImpl(PedidoRepositorio pedidoRepositorio, ProdutoServico produtoServicoImplInject) {

        this.pedidoRepositorio = pedidoRepositorio;
        this.produtoServicoImplInject = produtoServicoImplInject;
    }

//    public PedidoServicoImpl(PedidoRepositorio pedidoRepositorio, ProdutoServico produtoServicoImplInject,  PagamentoServico pagamentoServico) {
//
//        this.pedidoRepositorio = pedidoRepositorio;
//        this.produtoServicoImplInject = produtoServicoImplInject;
//        this.pagamentoServico = pagamentoServico;
//    }

    @Override
    public String criar(PedidoRequisicao pedidoReq, String status, String tempo) {
        Produto produtoBuscaId = null;
        Double valorTotal = 0.0;
        List<ProdutoVO> produtosVO = new ArrayList<ProdutoVO>();
        for (ProdutosReq produtoReq : pedidoReq.getProdutos()) {
            ProdutoVO produtoVO = new ProdutoVO(produtoReq.getIdProduto(), produtoReq.getQuantidadeProduto());
            produtoBuscaId = produtoServicoImplInject.buscaProdutoPorId(Long.valueOf(produtoReq.getIdProduto()));
            valorTotal += produtoBuscaId.getPreco().getPreco() * Double.parseDouble(produtoReq.getQuantidadeProduto());
            produtosVO.add(produtoVO);
        }
        Pedido pedido = new Pedido(produtosVO, pedidoReq.getIdCliente(), valorTotal,
                StatusPedidoEnum.buscaEnumPorStatusString(status), tempo, StatusPagamentoEnum.PENDENTE);

        return this.pedidoRepositorio.criar(pedido);

    }

    @Override
    public Pedido atualizar(Long id) {
        Pedido pedidoBusca = this.pedidoRepositorio.buscarPedidoPorId(id);
        Pedido pedido = null;

        if (pedidoBusca == null) {
            throw new BadRequestException(ExceptionsMessages.PEDIDO_NAO_ENCONTRADO.getValue());
        }

        if(pedidoBusca.getStatus() == StatusPedidoEnum.RECEBIDO) {
           pedido = new Pedido(
            pedidoBusca.getId(),
            pedidoBusca.getProdutos(), 
            pedidoBusca.getCliente(), 
            pedidoBusca.getValorTotal(), 
            pedidoBusca.getStatus(), 
            pedidoBusca.getTempoEspera(), 
            atualizarPagamento(pedidoBusca.getId()));
        } else {
            pedido = pedidoBusca;
        }

        return this.pedidoRepositorio.atualizar(pedido.atualizaStatus());
    }

    @Override
    public Pedido buscarPedidoPorId(Long id) {
        return this.pedidoRepositorio.buscarPedidoPorId(id);
    }

    @Override
    public List<Pedido> listarTodosPedidos() {
        return this.pedidoRepositorio.listarTodosOsPedidos();
    }

   private StatusPagamentoEnum atualizarPagamento(Long id) {
    //    return pagamentoServico.realizarPagemto(id);
       return StatusPagamentoEnum.APROVADO;
   }

}
