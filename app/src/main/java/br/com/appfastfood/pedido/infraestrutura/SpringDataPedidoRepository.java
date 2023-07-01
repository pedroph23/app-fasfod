package br.com.appfastfood.pedido.infraestrutura;
import org.springframework.data.jpa.repository.JpaRepository;
import br.com.appfastfood.pedido.infraestrutura.entidades.PedidoEntidade;


public interface SpringDataPedidoRepository extends JpaRepository<PedidoEntidade, Long> {
     PedidoEntidade findPedidoEntidadeById(Long id);
   
}
