package br.com.appfastfood.produto.infraestrutura;

import br.com.appfastfood.produto.dominio.modelos.*;
import br.com.appfastfood.produto.dominio.modelos.enums.CategoriaEnum;
import br.com.appfastfood.produto.dominio.repositorios.ProdutoRepositorio;
import br.com.appfastfood.produto.exceptions.CategoriaNaoEncontradaException;
import br.com.appfastfood.produto.infraestrutura.entidades.ProdutoEntidade;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
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
        ProdutoEntidade produtoSalvo = new ProdutoEntidade(
                produto.getNome().getNome(),
                produto.getPreco().getPreco(),
                produto.getUriImagem().getUriImagem(),
                produto.getCategoria().name(),
                produto.getDescricao().getDescricao()
        );

        this.springDataProdutoRepository.save(produtoSalvo);
    }

    @Override
    public void remover(Long id) {
       this.springDataProdutoRepository.deleteById(id);
    }

    @Override
    public Produto atualizar(Long id, Produto produto) {
        ProdutoEntidade produtoSalvo = new ProdutoEntidade(
                produto.getNome().getNome(),
                produto.getPreco().getPreco(),
                produto.getUriImagem().getUriImagem(),
                produto.getCategoria().name(),
                produto.getDescricao().getDescricao()
        );

        this.springDataProdutoRepository.save(produtoSalvo);

        return produto;
    }

    @Override
    public Optional<List<Produto>> buscarPorCategoria(String categoria) {
        List<Produto> produtos = new ArrayList<>();
        Optional<List<ProdutoEntidade>> produtoEntidadeCategoria;

        produtoEntidadeCategoria = this.springDataProdutoRepository.findProdutoEntidadeByCategoria(categoria);

        if(!produtoEntidadeCategoria.get().isEmpty()) {
            produtoEntidadeCategoria.get().forEach(produtoEntidade -> {
                Produto produto = new Produto(
                        new Nome(produtoEntidade.getNome()),
                        new Preco(produtoEntidade.getPreco()),
                        new UriImagem(produtoEntidade.getUriImagem()),
                        new Categoria(produtoEntidade.getCategoria()).getCategoria(),
                        new Descricao(produtoEntidade.getDescricao())
                );
                produtos.add(produto);
            });
            return Optional.of(produtos);
        }

        throw new CategoriaNaoEncontradaException();
    }
}
