package br.com.appfastfood.pedido.infraestrutura;
import br.com.appfastfood.pedido.dominio.modelos.Pedido;
import br.com.appfastfood.pedido.dominio.repositorios.PedidoRepositorio;
import br.com.appfastfood.pedido.infraestrutura.entidades.PedidoEntidade;

import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.List;
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
    public List<PedidoEntidade> listarTodosOsPedidos() {
        return springDataPedidoRepository.findAll();
    }

    @Override
    public Optional<PedidoEntidade> buscarPedidoPorId(Long id) {
        // TODO Auto-generated method stub
        return springDataPedidoRepository.findById(id);
    }   
   
}
