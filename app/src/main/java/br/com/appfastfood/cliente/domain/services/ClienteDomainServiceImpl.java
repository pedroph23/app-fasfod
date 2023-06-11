
package br.com.appfastfood.cliente.domain.services; 
 
import br.com.appfastfood.cliente.domain.model.Cliente; 
import org.springframework.stereotype.Service;

@Service
public class ClienteDomainServiceImpl implements ClienteDomainService {
    private final ClienteRepository clienteRepository;

    public ClienteDomainServiceImpl(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    @Override
    public Cliente cadastrarCliente(Cliente cliente) {
        // Lógica de negócio para cadastro de cliente (validações, etc.)
        return clienteRepository.save(cliente);
    }
}