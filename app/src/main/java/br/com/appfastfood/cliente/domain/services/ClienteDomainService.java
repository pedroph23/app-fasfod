package br.com.appfastfood.cliente.domain.services; 
 
import br.com.appfastfood.cliente.domain.model.Cliente; 
 
public interface ClienteDomainService {
    Cliente cadastrarCliente(Cliente cliente);
}
