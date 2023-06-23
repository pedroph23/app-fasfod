package br.com.appfastfood.pedido.infraestrutura;

import br.com.appfastfood.pedido.aplicacao.adaptadores.requisicao.PedidoRequisicao;
import br.com.appfastfood.pedido.dominio.modelos.Pedido;
import br.com.appfastfood.pedido.dominio.repositorios.PedidoRepositorio;
import br.com.appfastfood.pedido.infraestrutura.entidades.PedidoEntidade;
import br.com.appfastfood.produto.infraestrutura.SpringDataProdutoRepository;

import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class PedidoRepositorioImpl implements PedidoRepositorio {


     private final SpringDataPedidoRepository springDataPedidoRepository;

    public PedidoRepositorioImpl(SpringDataPedidoRepository springDataPedidoRepository) {
        this.springDataPedidoRepository = springDataPedidoRepository;
    }

     @Override
    public void criar(Pedido pedido) {
        
    }

    @Override
    public Pedido atualizar(Pedido pedidoRequisicao) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'atualizar'");
    }

    @Override
    public Optional<List<Pedido>> listarTodosOsPedidos() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'listarTodosOsPedidos'");
    }   
   
}
