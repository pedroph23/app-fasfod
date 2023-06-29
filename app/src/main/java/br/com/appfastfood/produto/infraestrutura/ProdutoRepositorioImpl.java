package br.com.appfastfood.produto.infraestrutura;

import br.com.appfastfood.produto.dominio.modelos.*;
import br.com.appfastfood.produto.dominio.repositorios.ProdutoRepositorio;
import br.com.appfastfood.produto.exceptions.CategoriaNaoEncontradaException;
import br.com.appfastfood.produto.exceptions.IDNaoEncontradoException;
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

       if (this.springDataProdutoRepository.existsById(id)) {
           this.springDataProdutoRepository.deleteById(id);
        }

        throw new IDNaoEncontradoException();
    }

    @Override
    public Produto atualizar(Long id, Produto produto) {
        ProdutoEntidade produtoSalvo = new ProdutoEntidade(
                id,
                produto.getNome().getNome(),
                produto.getPreco().getPreco(),
                produto.getUriImagem().getUriImagem(),
                produto.getCategoria().name(),
                produto.getDescricao().getDescricao()
        );

        if (this.springDataProdutoRepository.existsById(id)) {
            this.springDataProdutoRepository.save(produtoSalvo);
            return produto;
        }

        throw new IDNaoEncontradoException();

    }

    @Override
    public Optional<List<Produto>> buscarPorCategoria(String categoria) {
        List<Produto> produtos = new ArrayList<>();
        Optional<List<ProdutoEntidade>> produtoEntidadeCategoria;
        produtoEntidadeCategoria = this.springDataProdutoRepository.findProdutoEntidadeByCategoria(categoria);

            if(produtoEntidadeCategoria.isPresent() && !produtoEntidadeCategoria.get().isEmpty()) {
                produtoEntidadeCategoria.get().forEach(produtoEntidade -> {
                    Produto produto = new Produto(
                            produtoEntidade.getId(),
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

    @Override
    public Produto buscarProdutoPorId(Long id){
        ProdutoEntidade produtoBusca = this.springDataProdutoRepository.findProdutoById(id);
        Produto produtoRetorno = new Produto(produtoBusca.getId(), 
                                    new Nome(produtoBusca.getNome()), 
                                    new Preco(produtoBusca.getPreco()), 
                                    new UriImagem(produtoBusca.getUriImagem()), 
                                    new Categoria(produtoBusca.getCategoria()).getCategoria(), 
                                    new Descricao(produtoBusca.getDescricao()));
        return produtoRetorno;
    }
}
