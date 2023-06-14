package br.com.appfastfood.cliente.domain.services; 
 
import br.com.appfastfood.cliente.domain.model.Cliente;
import org.springframework.stereotype.Service;

@Service
public interface ClienteDomainService {
    Cliente cadastrarCliente(Cliente cliente);
}
