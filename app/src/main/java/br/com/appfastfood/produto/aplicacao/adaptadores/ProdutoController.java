package br.com.appfastfood.produto.aplicacao.adaptadores;

import br.com.appfastfood.produto.aplicacao.adaptadores.requisicao.ProdutoRequisicao;
import br.com.appfastfood.produto.aplicacao.adaptadores.resposta.ProdutoResposta;
import br.com.appfastfood.produto.dominio.modelos.*;
import br.com.appfastfood.produto.dominio.modelos.enums.CategoriaEnum;
import br.com.appfastfood.produto.dominio.servicos.portas.ProdutoServico;
import br.com.appfastfood.produto.exceptions.*;
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

        try {
            Produto produto = new Produto(
                    new Nome(produtoRequisicao.getNome()),
                    new Preco(produtoRequisicao.getPreco()),
                    new UriImagem(produtoRequisicao.getUriImagem()),
                    new Categoria(produtoRequisicao.getCategoria()).getCategoria(),
                    new Descricao(produtoRequisicao.getDescricao())
            );

            this.produtoServico.cadastrar(produto);

            ProdutoResposta produtoResposta = ProdutoResposta
                    .builder()
                    .nome(produto.getNome().getNome())
                    .preco(produto.getPreco().getPreco())
                    .descricao(produto.getDescricao().getDescricao())
                    .categoria(produto.getCategoria().name())
                    .uriImagem(produto.getUriImagem().getUriImagem())
                    .build();

            return ResponseEntity.status(HttpStatus.CREATED).body(produtoResposta);
        } catch (CategoriaNaoEncontradaException cnee) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(cnee.getMessage());
        } catch (CategoriaObrigatorioException coe) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(coe.getMessage());
        } catch (DescricaoObrigatorioException doe) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(doe.getMessage());
        } catch (NomeObrigatorioException noe) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(noe.getMessage());
        } catch (PrecoObrigatorioException poe) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(poe.getMessage());
        } catch (UriImagemFormatoInvalidoException uifie) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(uifie.getMessage());
        } catch (UriImagemObrigatorioException uioe) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(uioe.getMessage());
        }
    }
    @DeleteMapping("/{id}")
    public ResponseEntity remover(@PathVariable("id") Long id){
        this.produtoServico.remover(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity atualizar(@PathVariable("id") Long id, @RequestBody ProdutoRequisicao produtoRequisicao){

        try {
            Produto produto = new Produto(
                    new Nome(produtoRequisicao.getNome()),
                    new Preco(produtoRequisicao.getPreco()),
                    new UriImagem(produtoRequisicao.getUriImagem()),
                    new Categoria(produtoRequisicao.getCategoria()).getCategoria(),
                    new Descricao(produtoRequisicao.getDescricao())
            );

            Produto produtoResultado = this.produtoServico.atualizar(id, produto);

            ProdutoResposta produtoResposta = ProdutoResposta
                    .builder()
                    .nome(produtoResultado.getNome().getNome())
                    .preco(produtoResultado.getPreco().getPreco())
                    .descricao(produtoResultado.getDescricao().getDescricao())
                    .categoria(produtoResultado.getCategoria().name())
                    .uriImagem(produtoResultado.getUriImagem().getUriImagem())
                    .build();

            return ResponseEntity.status(HttpStatus.OK).body(produtoResposta);
        } catch (CategoriaNaoEncontradaException cnee) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(cnee.getMessage());
        } catch (CategoriaObrigatorioException coe) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(coe.getMessage());
        } catch (DescricaoObrigatorioException doe) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(doe.getMessage());
        } catch (NomeObrigatorioException noe) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(noe.getMessage());
        } catch (PrecoObrigatorioException poe) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(poe.getMessage());
        } catch (UriImagemFormatoInvalidoException uifie) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(uifie.getMessage());
        } catch (UriImagemObrigatorioException uioe) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(uioe.getMessage());
        }

    }

    @GetMapping()
    public ResponseEntity buscarPorCategoria(@RequestParam(value = "categoria") String categoria){

        try {
            List<Produto> produtos = this.produtoServico.buscarPorCategoria(categoria);

            List<ProdutoResposta> produtosResposta =  produtos.stream().map(produto -> ProdutoResposta
                    .builder()
                    .nome(produto.getNome().getNome())
                    .preco(produto.getPreco().getPreco())
                    .descricao(produto.getDescricao().getDescricao())
                    .categoria(produto.getCategoria().name())
                    .uriImagem(produto.getUriImagem().getUriImagem())
                    .build()).toList();


            return ResponseEntity.status(HttpStatus.OK).body(produtosResposta);
        } catch (CategoriaNaoEncontradaException e) {
           return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }

    }
}
