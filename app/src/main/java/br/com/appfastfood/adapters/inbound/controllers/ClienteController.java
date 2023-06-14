package br.com.appfastfood.adapters.inbound.controllers;

import br.com.appfastfood.cliente.application.services.ClienteService;
import br.com.appfastfood.cliente.domain.model.Cliente;
import br.com.appfastfood.cliente.domain.model.Cpf;
import br.com.appfastfood.cliente.domain.model.Email;
import br.com.appfastfood.cliente.domain.model.Nome;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/clientes")
public class ClienteController {
    private ClienteService clienteService;

    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

  @GetMapping
    public ResponseEntity<Object> cadastrarCliente(/*@RequestBody Cliente cliente*/) {
        Cliente clienteRequest = new Cliente(new Nome("Jose"), new Cpf("12345678901"), new Email("aa@gmail.com"));
        Cliente novoCliente = clienteService.cadastrarCliente(clienteRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(novoCliente);
    }
}