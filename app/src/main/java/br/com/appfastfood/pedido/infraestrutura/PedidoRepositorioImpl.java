package br.com.appfastfood.pedido.infraestrutura;
import br.com.appfastfood.pedido.dominio.modelos.Pedido;
import br.com.appfastfood.pedido.dominio.modelos.enums.StatusPedidoEnum;
import br.com.appfastfood.pedido.dominio.repositorios.PedidoRepositorio;
import br.com.appfastfood.pedido.infraestrutura.entidades.PedidoEntidade;
import br.com.appfastfood.produto.dominio.modelos.Produto;
import br.com.appfastfood.produto.dominio.repositorios.ProdutoRepositorio;
import br.com.appfastfood.produto.dominio.servicos.adaptadores.ProdutoServicoImpl;
import br.com.appfastfood.produto.infraestrutura.ProdutoRepositorioImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Import;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Component
@Import(ProdutoServicoImpl.class)
public class PedidoRepositorioImpl implements PedidoRepositorio {

    @Autowired
    private ProdutoServicoImpl produtoServicoImplInject;

    private final SpringDataPedidoRepository springDataPedidoRepository;

    public PedidoRepositorioImpl(SpringDataPedidoRepository springDataPedidoRepository) {
        this.springDataPedidoRepository = springDataPedidoRepository;
    }

    @Override
    public void criar(PedidoEntidade pedido) {
        PedidoEntidade pedidoDb = new PedidoEntidade(null, pedido.getIdProduto().toString(), pedido.getQuantidadeProduto(), pedido.getClienteId().toString(), BigDecimal.valueOf(10), "RECEBIDO");
        springDataPedidoRepository.save(pedidoDb);
    }

    @Override
    public Pedido atualizar(Pedido pedidoRequisicao) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'atualizar'");
    }

    @Override
    public List<Pedido> listarTodosOsPedidos() {
        List<PedidoEntidade> pedido = this.springDataPedidoRepository.findAll();
        List<Produto> produtosBusca = new ArrayList<>();
        List<Pedido> pedidoRetorno = new ArrayList<>();
        
        for (PedidoEntidade pedidoBusca : pedido){
            Pedido pedidoObj = new Pedido(null, null, null, null);
            Map<Produto, Long> prods = new HashMap<>();
            pedidoObj.setCliente(null);
            //pedidoObj.setValorTotal(pedidoObj.getValorTotal().add(pedidoBusca.getValorTotal()));
            pedidoObj.setValorTotal(BigDecimal.valueOf(10));
            pedidoObj.setStatus(StatusPedidoEnum.buscaEnumPorStatusString(pedidoBusca.getStatus()));
            String[] idsProdutos = pedidoBusca.getIdProduto().split(",");
            String[] quantidades = pedidoBusca.getQuantidadeProduto().split(",");
            for (int i = 0; i<idsProdutos.length; i++){
                Produto produtoBuscaId = produtoServicoImplInject.buscaProdutoPorId(Long.parseLong(idsProdutos[i]));
                produtosBusca.add(produtoBuscaId);
                prods.put(produtoBuscaId,Long.parseLong(quantidades[i]));
            }
            pedidoObj.setProduto(prods);
            pedidoRetorno.add(pedidoObj);
        }
        return pedidoRetorno;
    }

    @Override
    public Pedido buscarPedidoPorId(Long id) {

        Optional<PedidoEntidade> pedidoEntidadeBusca = this.springDataPedidoRepository.findById(id);
        if (!pedidoEntidadeBusca.isPresent()){
            //exceção
        }

        String[] idsProdutos = pedidoEntidadeBusca.get().getIdProduto().split(",");
        String[] quantidades = pedidoEntidadeBusca.get().getQuantidadeProduto().split(",");
        Map<Produto, Long> listaProdutos = new HashMap<>();
        for (int i = 0; i<idsProdutos.length; i++){
            Produto produtoBuscaId = produtoServicoImplInject.buscaProdutoPorId(Long.parseLong(idsProdutos[i]));
            listaProdutos.put(produtoBuscaId, Long.parseLong(quantidades[i]));
        }

        Pedido pedidoRetorno = new Pedido(listaProdutos, null, pedidoEntidadeBusca.get().getValorTotal(), StatusPedidoEnum.buscaEnumPorStatusString(pedidoEntidadeBusca.get().getStatus()));
        return pedidoRetorno;
    }   
   
}
