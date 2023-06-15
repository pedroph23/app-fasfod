package br.com.appfastfood.cliente.dominio.servicos.portas;


import br.com.appfastfood.cliente.dominio.modelos.Cliente;

import java.util.UUID;

public interface ClienteServico {
    UUID cadastrar(Cliente cliente);
    Cliente buscarPorCpf(Cliente cliente);

}
