package br.com.appfastfood.produto.dominio.servicos.adaptadores;

import br.com.appfastfood.pedido.dominio.repositorios.PedidoRepositorio;
import br.com.appfastfood.produto.dominio.modelos.Produto;
import br.com.appfastfood.produto.dominio.repositorios.ProdutoRepositorio;
import br.com.appfastfood.produto.dominio.servicos.portas.ProdutoServico;

import java.util.List;

public class ProdutoServicoImpl implements ProdutoServico {

    private final ProdutoRepositorio produtoRepositorio;

    public ProdutoServicoImpl(ProdutoRepositorio produtoRepositorio) {
        this.produtoRepositorio = produtoRepositorio;
    }

    @Override
    public void cadastrar(Produto produto) {
             this.produtoRepositorio.cadastrar(produto);
    }

    @Override
    public void remover(Long id) {
             this.produtoRepositorio.remover(id);
    }

    @Override
    public Produto atualizar(Long id, Produto p) {
        Produto produtoAlterado = this.produtoRepositorio.atualizar(id,p);
        return produtoAlterado;
    }

    @Override
    public List<Produto> buscarPorCategoria(String categoria) {
        return this.produtoRepositorio.buscarPorCategoria(categoria).get();
    }
}
