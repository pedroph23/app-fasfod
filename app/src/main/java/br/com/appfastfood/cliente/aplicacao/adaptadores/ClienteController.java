package br.com.appfastfood.cliente.aplicacao.adaptadores;


import br.com.appfastfood.cliente.aplicacao.adaptadores.requisicao.RequisicaoCliente;
import br.com.appfastfood.cliente.dominio.modelos.Cliente;
import br.com.appfastfood.cliente.dominio.modelos.Cpf;
import br.com.appfastfood.cliente.dominio.modelos.Email;
import br.com.appfastfood.cliente.dominio.modelos.Nome;
import br.com.appfastfood.cliente.dominio.servicos.portas.ClienteServico;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/clientes")
public class ClienteController {
    private ClienteServico clienteServico;

    public ClienteController(ClienteServico clienteServico) {
        this.clienteServico = clienteServico;
    }

    @PostMapping
    public ResponseEntity cadastrar(@RequestBody RequisicaoCliente requisicaoCliente) {
        Cliente clienteRequest = new Cliente(
                new Nome(requisicaoCliente.getNome()),
                new Cpf(requisicaoCliente.getNome()),
                new Email(requisicaoCliente.getEmail()));
        this.clienteServico.cadastrar(clienteRequest);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}