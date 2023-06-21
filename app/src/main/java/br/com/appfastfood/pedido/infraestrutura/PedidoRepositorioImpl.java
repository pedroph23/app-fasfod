package br.com.appfastfood.pedido.infraestrutura;

import br.com.appfastfood.pedido.aplicacao.adaptadores.requisicao.PedidoRequisicao;
import br.com.appfastfood.pedido.dominio.modelos.Pedido;
import br.com.appfastfood.pedido.dominio.repositorios.PedidoRepositorio;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
@Component
public class PedidoRepositorioImpl implements PedidoRepositorio {
    @Override
    public void criar(Pedido pedido) {

    }

    @Override
    public Pedido atualizar(PedidoRequisicao pedidoRequisicao) {
        return null;
    }

    @Override
    public Optional<List<Pedido>> listarTodosOsPedidos() {
        return Optional.empty();
    }
}
