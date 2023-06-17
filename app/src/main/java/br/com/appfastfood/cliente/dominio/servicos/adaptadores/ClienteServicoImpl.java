
package br.com.appfastfood.cliente.dominio.servicos.adaptadores;
 
import br.com.appfastfood.cliente.dominio.modelos.Cliente;
import br.com.appfastfood.cliente.dominio.modelos.Cpf;
import br.com.appfastfood.cliente.dominio.modelos.Email;
import br.com.appfastfood.cliente.dominio.modelos.Nome;
import br.com.appfastfood.cliente.dominio.repositorios.ClienteRepositorio;
import br.com.appfastfood.cliente.dominio.servicos.portas.ClienteServico;
import br.com.appfastfood.cliente.infraestrutura.entidades.EntidadeCliente;

import java.util.UUID;


public class ClienteServicoImpl implements ClienteServico {
    private final ClienteRepositorio clienteRepositorio;

    public ClienteServicoImpl(final ClienteRepositorio clienteRepositorio) {
        this.clienteRepositorio = clienteRepositorio;
    }

    @Override
    public UUID cadastrar(Cliente entidadeCliente) {
        UUID id = clienteRepositorio.cadastrar(entidadeCliente);
        return id;
    }

    @Override
    public Cliente buscarPorCpf(String cpf) {
        if (clienteRepositorio.buscarPorCpf(cpf).isPresent()) {
            EntidadeCliente entidade = clienteRepositorio.buscarPorCpf(cpf).get();
            return new Cliente(new Nome(entidade.getNome()), new Cpf(entidade.getCpf()), new Email(entidade.getEmail()));
        }
        return new Cliente(null, null, null);

    }
}

