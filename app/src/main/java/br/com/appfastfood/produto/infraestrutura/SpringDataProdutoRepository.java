package br.com.appfastfood.produto.infraestrutura;

import br.com.appfastfood.produto.infraestrutura.entidades.ProdutoEntidade;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpringDataProdutoRepository extends JpaRepository<ProdutoEntidade, Long> {
}
