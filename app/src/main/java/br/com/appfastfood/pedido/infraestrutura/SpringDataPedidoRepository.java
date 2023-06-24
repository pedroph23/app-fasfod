package br.com.appfastfood.pedido.infraestrutura;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import br.com.appfastfood.pedido.infraestrutura.entidades.PedidoEntidade;


public interface SpringDataPedidoRepository extends JpaRepository<PedidoEntidade, Long> {
     Optional<List<PedidoEntidade>> findPedidoEntidadeById(Long id);
}
