package br.com.appfastfood.produto.aplicacao.adaptadores;

import br.com.appfastfood.cliente.aplicacao.adaptadores.requisicao.RequisicaoExcecao;
import br.com.appfastfood.configuracoes.logs.Log;
import br.com.appfastfood.produto.aplicacao.adaptadores.requisicao.ProdutoRequisicao;
import br.com.appfastfood.produto.aplicacao.adaptadores.resposta.ProdutoResposta;
import br.com.appfastfood.produto.dominio.modelos.*;
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
    private Log logger;

    public ProdutoController(ProdutoServico produtoServico, Log logger) {
        this.produtoServico = produtoServico;
        this.logger = logger;
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
            RequisicaoExcecao jsonExcecao = new RequisicaoExcecao(cnee.getMessage(), HttpStatus.BAD_REQUEST.value());
            logger.aviso(jsonExcecao.toString());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(jsonExcecao);
        } catch (CategoriaObrigatorioException coe) {
            RequisicaoExcecao jsonExcecao = new RequisicaoExcecao(coe.getMessage(), HttpStatus.BAD_REQUEST.value());
            logger.aviso(jsonExcecao.toString());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(jsonExcecao);
        } catch (DescricaoObrigatorioException doe) {
            RequisicaoExcecao jsonExcecao = new RequisicaoExcecao(doe.getMessage(), HttpStatus.BAD_REQUEST.value());
            logger.aviso(jsonExcecao.toString());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(jsonExcecao);
        } catch (NomeObrigatorioException noe) {
            RequisicaoExcecao jsonExcecao = new RequisicaoExcecao(noe.getMessage(), HttpStatus.BAD_REQUEST.value());
            logger.aviso(jsonExcecao.toString());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(jsonExcecao);
        } catch (PrecoObrigatorioException poe) {
            RequisicaoExcecao jsonExcecao = new RequisicaoExcecao(poe.getMessage(), HttpStatus.BAD_REQUEST.value());
            logger.aviso(jsonExcecao.toString());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(jsonExcecao);
        } catch (UriImagemFormatoInvalidoException uifie) {
            RequisicaoExcecao jsonExcecao = new RequisicaoExcecao(uifie.getMessage(), HttpStatus.BAD_REQUEST.value());
            logger.aviso(jsonExcecao.toString());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(jsonExcecao);
        } catch (UriImagemObrigatorioException uioe) {
            RequisicaoExcecao jsonExcecao = new RequisicaoExcecao(uioe.getMessage(), HttpStatus.BAD_REQUEST.value());
            logger.aviso(jsonExcecao.toString());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(jsonExcecao);
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
            RequisicaoExcecao jsonExcecao = new RequisicaoExcecao(cnee.getMessage(), HttpStatus.BAD_REQUEST.value());
            logger.aviso(jsonExcecao.toString());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(jsonExcecao);
        } catch (CategoriaObrigatorioException coe) {
            RequisicaoExcecao jsonExcecao = new RequisicaoExcecao(coe.getMessage(), HttpStatus.BAD_REQUEST.value());
            logger.aviso(jsonExcecao.toString());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(jsonExcecao);
        } catch (DescricaoObrigatorioException doe) {
            RequisicaoExcecao jsonExcecao = new RequisicaoExcecao(doe.getMessage(), HttpStatus.BAD_REQUEST.value());
            logger.aviso(jsonExcecao.toString());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(jsonExcecao);
        } catch (NomeObrigatorioException noe) {
            RequisicaoExcecao jsonExcecao = new RequisicaoExcecao(noe.getMessage(), HttpStatus.BAD_REQUEST.value());
            logger.aviso(jsonExcecao.toString());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(jsonExcecao);
        } catch (PrecoObrigatorioException poe) {
            RequisicaoExcecao jsonExcecao = new RequisicaoExcecao(poe.getMessage(), HttpStatus.BAD_REQUEST.value());
            logger.aviso(jsonExcecao.toString());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(jsonExcecao);
        } catch (UriImagemFormatoInvalidoException uifie) {
            RequisicaoExcecao jsonExcecao = new RequisicaoExcecao(uifie.getMessage(), HttpStatus.BAD_REQUEST.value());
            logger.aviso(jsonExcecao.toString());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(jsonExcecao);
        } catch (UriImagemObrigatorioException uioe) {
            RequisicaoExcecao jsonExcecao = new RequisicaoExcecao(uioe.getMessage(), HttpStatus.BAD_REQUEST.value());
            logger.aviso(jsonExcecao.toString());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(jsonExcecao);
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
            RequisicaoExcecao jsonExcecao = new RequisicaoExcecao(e.getMessage(), HttpStatus.BAD_REQUEST.value());
            logger.aviso(jsonExcecao.toString());
           return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(jsonExcecao);
        }

    }
}
