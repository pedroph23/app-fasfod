package br.com.appfastfood.produto.aplicacao.adaptadores;

import br.com.appfastfood.produto.aplicacao.adaptadores.requisicao.ProdutoRequisicao;
import br.com.appfastfood.produto.dominio.modelos.*;
import br.com.appfastfood.produto.dominio.modelos.enums.CategoriaEnum;
import br.com.appfastfood.produto.dominio.servicos.portas.ProdutoServico;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    private ProdutoServico produtoServico;

    public ProdutoController(ProdutoServico produtoServico) {
        this.produtoServico = produtoServico;
    }

    @PostMapping
    public ResponseEntity<Object> cadastrar(@RequestBody ProdutoRequisicao produtoRequisicao){
        Produto produto = new Produto(
                new Nome(produtoRequisicao.getNome()),
                new Preco(produtoRequisicao.getPreco()),
                new UriImagem(produtoRequisicao.getUriImagem()),
                new Categoria(produtoRequisicao.getCategoria()).getCategoria(),
                new Descricao(produtoRequisicao.getDescricao())
        );

        this.produtoServico.cadastrar(produto);

        return ResponseEntity.status(HttpStatus.CREATED).body(produto);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity remover(@PathVariable("id") Long id){
        this.produtoServico.remover(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> atualizar(@PathVariable("id") Long id, @RequestBody ProdutoRequisicao produtoRequisicao){
        Produto produto = new Produto(
                new Nome(produtoRequisicao.getNome()),
                new Preco(produtoRequisicao.getPreco()),
                new UriImagem(produtoRequisicao.getUriImagem()),
                new Categoria(produtoRequisicao.getCategoria()).getCategoria(),
                new Descricao(produtoRequisicao.getDescricao())
        );

        Produto produtoResultado = this.produtoServico.atualizar(id, produto);

        return ResponseEntity.status(HttpStatus.OK).body(produtoResultado);
    }
    @GetMapping()
    public ResponseEntity buscarPorCategoria(@RequestParam(value = "categoria") String categoria){
        List<Produto> produtos = this.produtoServico.buscarPorCategoria(categoria);
        return ResponseEntity.status(HttpStatus.OK).body(produtos);
    }
}
