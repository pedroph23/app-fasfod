package br.com.appfastfood.cliente.application.services; 
 
import br.com.appfastfood.cliente.domain.model.Cliente; 
import br.com.appfastfood.cliente.domain.repositories.ClienteRepository; 
import br.com.appfastfood.cliente.domain.services.ClienteDomainService; 
import org.springframework.stereotype.Service;
 
@Service
public class ClienteService { 
    private final ClienteDomainService clienteDomainService;

    public ClienteService(ClienteDomainService clienteDomainService) {
        this.clienteDomainService = clienteDomainService;
    }

    public Cliente cadastrarCliente(Cliente cliente) {
        // Lógica adicional, se necessário
        return clienteDomainService.cadastrarCliente(cliente);
    } 
} 
