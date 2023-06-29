package br.com.appfastfood.pedido.infraestrutura;
import br.com.appfastfood.pedido.dominio.modelos.Pedido;
import br.com.appfastfood.pedido.dominio.modelos.enums.StatusPedidoEnum;
import br.com.appfastfood.pedido.dominio.repositorios.PedidoRepositorio;
import br.com.appfastfood.pedido.infraestrutura.entidades.PedidoEntidade;
import br.com.appfastfood.produto.dominio.modelos.Produto;
import br.com.appfastfood.produto.infraestrutura.ProdutoRepositorioImpl;

import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Component
public class PedidoRepositorioImpl implements PedidoRepositorio {


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
            pedidoObj.setValorTotal(pedidoObj.getValorTotal().add(pedidoBusca.getValorTotal()));
            pedidoObj.setStatus(StatusPedidoEnum.buscaEnumPorStatusString(pedidoBusca.getStatus()));
            String[] idsProdutos = pedidoBusca.getIdProduto().split(",");
            String[] quantidades = pedidoBusca.getQuantidadeProduto().split(",");
            for (int i = 0; i<idsProdutos.length; i++){
                Produto produtoBuscaId = new ProdutoRepositorioImpl(null).buscarProdutoPorId(Long.parseLong(idsProdutos[i]));
                produtosBusca.add(produtoBuscaId);
                prods.put(produtoBuscaId,Long.parseLong(quantidades[i]));
            }
            pedidoObj.setProduto(prods);
        }
        return pedidoRetorno;
    }

    @Override
    public Optional<PedidoEntidade> buscarPedidoPorId(Long id) {
        // TODO Auto-generated method stub
        return springDataPedidoRepository.findById(id);
    }   
   
}
