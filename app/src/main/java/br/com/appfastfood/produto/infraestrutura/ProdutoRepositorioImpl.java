package br.com.appfastfood.produto.infraestrutura;

import br.com.appfastfood.produto.dominio.modelos.Produto;
import br.com.appfastfood.produto.dominio.repositorios.ProdutoRepositorio;
import br.com.appfastfood.produto.infraestrutura.entidades.ProdutoEntidade;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class ProdutoRepositorioImpl implements ProdutoRepositorio {

    private final SpringDataProdutoRepository springDataProdutoRepository;

    public ProdutoRepositorioImpl(SpringDataProdutoRepository springDataProdutoRepository) {
        this.springDataProdutoRepository = springDataProdutoRepository;
    }

    @Override
    public void cadastrar(Produto produto) {
        ProdutoEntidade produtoSalvo = new ProdutoEntidade(produto.getId(),
                produto.getNome(), produto.getPreco(), produto.getUriImagem(),
                null, produto.getDescricao());

        this.springDataProdutoRepository.save(produtoSalvo);
    }

    @Override
    public void remover(Long id) {

    }

    @Override
    public Produto atualizar(Long id, Produto p) {
        return null;
    }

    @Override
    public Optional<List<Produto>> buscarPorCategoria(String categoria) {
        return Optional.empty();
    }
}
