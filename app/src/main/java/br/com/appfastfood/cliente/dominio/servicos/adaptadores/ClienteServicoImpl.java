
package br.com.appfastfood.cliente.dominio.servicos.adaptadores;
 
import br.com.appfastfood.cliente.dominio.modelos.Cliente;
import br.com.appfastfood.cliente.dominio.repositorios.ClienteRepositorio;
import br.com.appfastfood.cliente.dominio.servicos.portas.ClienteServico;

import java.util.UUID;


public class ClienteServicoImpl implements ClienteServico {
    private final ClienteRepositorio clienteRepositorio;

    public ClienteServicoImpl(final ClienteRepositorio clienteRepositorio) {
        this.clienteRepositorio = clienteRepositorio;
    }

    @Override
    public UUID cadastrar(Cliente entidadeCliente) {
      UUID id =  clienteRepositorio.cadastrar(entidadeCliente);
      return id;
    }

    @Override
    public Cliente buscarPorCpf(Cliente cliente) {
        return null;
    }
}