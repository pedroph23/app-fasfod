package br.com.appfastfood.cliente.aplicacao.adaptadores;


import br.com.appfastfood.cliente.dominio.modelos.Cliente;
import br.com.appfastfood.cliente.dominio.modelos.Cpf;
import br.com.appfastfood.cliente.dominio.modelos.Email;
import br.com.appfastfood.cliente.dominio.modelos.Nome;
import br.com.appfastfood.cliente.dominio.servicos.portas.ClienteServico;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/clientes")
public class ClienteController {
    private ClienteServico clienteServico;

    public ClienteController(ClienteServico clienteServico) {
        this.clienteServico = clienteServico;
    }

  @GetMapping
    public ResponseEntity<Object> cadastrarCliente(/*@RequestBody RequisicaoCliente cliente*/) {
        Cliente clienteRequest = new Cliente(new Nome("Blablabla"), new Cpf("12345678901"), new Email("aa@gmail.com"));
        UUID idcliente = this.clienteServico.cadastrar(clienteRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(clienteRequest);
    }
}