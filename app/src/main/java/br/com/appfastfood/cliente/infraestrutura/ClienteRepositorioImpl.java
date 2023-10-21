package br.com.appfastfood.cliente.infraestrutura;

import br.com.appfastfood.cliente.dominio.modelos.Cliente;
import br.com.appfastfood.cliente.dominio.repositorios.ClienteRepositorio;
import br.com.appfastfood.cliente.infraestrutura.entidades.CustomSequence;
import br.com.appfastfood.cliente.infraestrutura.entidades.EntidadeCliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.FindAndModifyOptions;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Component;
import org.springframework.util.DigestUtils;

import java.util.Optional;
import java.util.UUID;

@Component
public class ClienteRepositorioImpl implements ClienteRepositorio {

    private final SpringDataClienteRepository clienteRepository;
    @Autowired
    private MongoTemplate mongoTemplate;
    public ClienteRepositorioImpl(SpringDataClienteRepository clienteRepository){
        this.clienteRepository = clienteRepository;
    }
    @Override
    public Optional<EntidadeCliente> buscarPorCpf(String cpf) {
        UUID id = UUID.nameUUIDFromBytes(DigestUtils.md5Digest(cpf.getBytes()));
        return clienteRepository.findById(id);
    }

    @Override
    public UUID cadastrar(Cliente cliente) {
        EntidadeCliente clienteDb = new EntidadeCliente(cliente.getNome(), cliente.getCpf(), cliente.getEmail());
        clienteRepository.save(clienteDb);
        return clienteDb.getId();
    }

    public Long generateNextId(String collectionName) {
        Query query = new Query(Criteria.where("_id").is(collectionName));
        Update update = new Update().inc("sequence", 1);
        FindAndModifyOptions options = new FindAndModifyOptions().returnNew(true).upsert(true);

        CustomSequence sequence = mongoTemplate.findAndModify(query, update, options, CustomSequence.class);

        return sequence.getSequence();
    }
}
