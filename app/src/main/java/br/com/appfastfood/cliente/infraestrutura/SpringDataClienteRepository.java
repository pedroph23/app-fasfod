package br.com.appfastfood.cliente.infraestrutura;

import br.com.appfastfood.cliente.infraestrutura.entidades.EntidadeCliente;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.UUID;

public interface SpringDataClienteRepository extends MongoRepository<EntidadeCliente, UUID> {
}