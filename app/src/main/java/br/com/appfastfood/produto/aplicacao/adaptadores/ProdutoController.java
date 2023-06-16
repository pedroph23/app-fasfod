package br.com.appfastfood.produto.aplicacao.adaptadores;

import br.com.appfastfood.produto.aplicacao.adaptadores.requisicao.ProdutoRequisicao;
import br.com.appfastfood.produto.dominio.modelos.Produto;
import br.com.appfastfood.produto.dominio.servicos.portas.ProdutoServico;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    private ProdutoServico produtoServico;

    public ProdutoController(ProdutoServico produtoServico) {
        this.produtoServico = produtoServico;
    }

    @GetMapping
    public ResponseEntity<Object> cadastrarProduto(/*@RequestBody ProdutoRequisicao produto*/){
        Produto p = new Produto(1L, "Bigmac", BigDecimal.valueOf(10.10), "http://blabla", null, "2 hamburgues molho especial");
        this.produtoServico.cadastrar(p);
        return ResponseEntity.status(HttpStatus.CREATED).body(p);
    }
}
