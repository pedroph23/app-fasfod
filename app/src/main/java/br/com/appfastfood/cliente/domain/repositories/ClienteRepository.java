package br.com.appfastfood.cliente.domain.repositories; 
 
import br.com.appfastfood.cliente.domain.model.Cliente; 
 
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
}