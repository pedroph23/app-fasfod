package br.com.appfastfood.pedido.infraestrutura;

import br.com.appfastfood.pedido.dominio.modelos.Pedido;
import br.com.appfastfood.pedido.dominio.modelos.enums.StatusPedidoEnum;
import br.com.appfastfood.pedido.dominio.repositorios.PedidoRepositorio;
import br.com.appfastfood.pedido.exceptions.IDPedidoNaoEncontradoException;
import br.com.appfastfood.pedido.exceptions.PagamentoNaoRealizado;
import br.com.appfastfood.pedido.exceptions.PedidoJaFinalizadoException;
import br.com.appfastfood.pedido.infraestrutura.entidades.PedidoEntidade;
import br.com.appfastfood.pedido.infraestrutura.entidades.ProdEnt;
import br.com.appfastfood.produto.dominio.modelos.Produto;
import br.com.appfastfood.produto.dominio.servicos.portas.ProdutoServico;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.*;

@Component
public class PedidoRepositorioImpl implements PedidoRepositorio {

    private final SpringDataPedidoRepository springDataPedidoRepository;

    public PedidoRepositorioImpl(SpringDataPedidoRepository springDataPedidoRepository) {
        this.springDataPedidoRepository = springDataPedidoRepository;
    }

    @Override
    public void criar(Pedido pedido) {
        Double valorTotal = 0D;
        List<ProdEnt> produtosEntidade = new ArrayList<>();
        pedido.getProdutos().forEach(produto -> {
           produtosEntidade.add(new ProdEnt(produto.getIdProduto(), produto.getQuantidadeProduto()));
        });
        PedidoEntidade pedidoDb = new PedidoEntidade(produtosEntidade, pedido.getCliente(), pedido.getValorTotal(), StatusPedidoEnum.retornaNomeEnum(pedido.getStatus()), pedido.getTempoEspera());

        if (realizarPagamento()){
            springDataPedidoRepository.save(pedidoDb);
        }else{
            throw new PagamentoNaoRealizado();
        }
    }

    @Override
    public Pedido atualizar(Long id) {

        Optional<PedidoEntidade> pedidoBusca =  this.springDataPedidoRepository.findById(id);
        if (!pedidoBusca.isPresent()){
            throw new IDPedidoNaoEncontradoException();
        }
        if(StatusPedidoEnum.buscaEnumPorStatusString(pedidoBusca.get().getStatus()) == StatusPedidoEnum.RECEBIDO){
            pedidoBusca.get().setStatus("EM_PREPARACAO");
        }else if(StatusPedidoEnum.buscaEnumPorStatusString(pedidoBusca.get().getStatus()) == StatusPedidoEnum.EM_PREPARACAO){
            pedidoBusca.get().setStatus("PRONTO");
        }else if(StatusPedidoEnum.buscaEnumPorStatusString(pedidoBusca.get().getStatus()) == StatusPedidoEnum.PRONTO){
            pedidoBusca.get().setStatus("FINALIZADO");
        }else if (StatusPedidoEnum.buscaEnumPorStatusString(pedidoBusca.get().getStatus()) == StatusPedidoEnum.FINALIZADO){
           throw new PedidoJaFinalizadoException();
        }
        this.springDataPedidoRepository.save(pedidoBusca.get());
        return buscarPedidoPorId(id);
    }

    @Override
    public List<Pedido> listarTodosOsPedidos() {
       List<PedidoEntidade> pedido = this.springDataPedidoRepository.findAll();
//        if(pedido.isEmpty()){
//            throw new IDPedidoNaoEncontradoException();
//        }
//        List<Produto> produtosBusca = new ArrayList<>();
//        List<Pedido> pedidoRetorno = new ArrayList<>();
//
//        for (PedidoEntidade pedidoBusca : pedido){
//            Pedido pedidoObj = new Pedido(null, null, null, null,null);
//            Map<Produto, Long> prods = new HashMap<>();
//            Double valorTotal = 0D;
//            pedidoObj.setCliente(pedidoBusca.getClienteId());
//            pedidoObj.setStatus(StatusPedidoEnum.buscaEnumPorStatusString(pedidoBusca.getStatus()));
//            String[] idsProdutos = pedidoBusca.getIdProduto().split(",");
//            String[] quantidades = pedidoBusca.getQuantidadeProduto().split(",");
//            for (int i = 0; i<idsProdutos.length; i++){
//                Produto produtoBuscaId = produtoServicoImplInject.buscaProdutoPorId(Long.parseLong(idsProdutos[i]));
//                valorTotal += (produtoBuscaId.getPreco().getPreco().doubleValue()) * (Double.parseDouble(quantidades[i]));
//                produtosBusca.add(produtoBuscaId);
//                prods.put(produtoBuscaId,Long.parseLong(quantidades[i]));
//            }
//            pedidoObj.setValorTotal(BigDecimal.valueOf(valorTotal));
//            pedidoObj.setTempoEspera(pedidoBusca.getTempoEspera());
//            pedidoObj.setProduto(prods);
//            pedidoRetorno.add(pedidoObj);
//        }
        return null;
    }

    @Override
    public Pedido buscarPedidoPorId(Long id) {
//
//        Optional<PedidoEntidade> pedidoEntidadeBusca = this.springDataPedidoRepository.findById(id);
//        if (!pedidoEntidadeBusca.isPresent()){
//            throw new IDPedidoNaoEncontradoException();
//        }
//        Double valorTotal = 0D;
//        String[] idsProdutos = pedidoEntidadeBusca.get().getIdProduto().split(",");
//        String[] quantidades = pedidoEntidadeBusca.get().getQuantidadeProduto().split(",");
//        Map<Produto, Long> listaProdutos = new HashMap<>();
//        for (int i = 0; i<idsProdutos.length; i++){
//            Produto produtoBuscaId = produtoServicoImplInject.buscaProdutoPorId(Long.parseLong(idsProdutos[i]));
//            listaProdutos.put(produtoBuscaId, Long.parseLong(quantidades[i]));
//            valorTotal += (produtoBuscaId.getPreco().getPreco().doubleValue()) * (Double.parseDouble(quantidades[i]));
//        }
//
//        Pedido pedidoRetorno = new Pedido(listaProdutos, pedidoEntidadeBusca.get().getClienteId(),BigDecimal.valueOf(valorTotal), StatusPedidoEnum.buscaEnumPorStatusString(pedidoEntidadeBusca.get().getStatus()),pedidoEntidadeBusca.get().getTempoEspera());
//        return pedidoRetorno;
        return null;
    }

    @Override
    public Boolean realizarPagamento(){
        return true;
    }
   
}
