package br.com.appfastfood.cliente.aplicacao.adaptadores;


import br.com.appfastfood.cliente.aplicacao.adaptadores.requisicao.RequisicaoCliente;
import br.com.appfastfood.cliente.aplicacao.adaptadores.requisicao.RequisicaoExcecao;
import br.com.appfastfood.cliente.dominio.modelos.Cliente;
import br.com.appfastfood.cliente.dominio.modelos.Cpf;
import br.com.appfastfood.cliente.dominio.modelos.Email;
import br.com.appfastfood.cliente.dominio.modelos.Nome;
import br.com.appfastfood.cliente.dominio.servicos.portas.ClienteServico;
import br.com.appfastfood.cliente.exceptions.ClienteNaoEncontradoException;
import br.com.appfastfood.configuracoes.logs.Log;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
public class ClienteController {
    private ClienteServico clienteServico;
    private Log logger;
    public ClienteController(ClienteServico clienteServico, Log logger) {
        this.clienteServico = clienteServico;
        this.logger = logger;
    }

    @PostMapping("/clientes")
    public ResponseEntity<?> cadastrar(@RequestBody RequisicaoCliente requisicaoCliente) {
        try {
            this.clienteServico.cadastrar(requisicaoCliente.getNome(), requisicaoCliente.getCpf(), requisicaoCliente.getEmail());
            return ResponseEntity.status(HttpStatus.CREATED).build();
        }catch (IllegalArgumentException e){
            RequisicaoExcecao jsonExcecao = new RequisicaoExcecao(e.getMessage(), HttpStatus.BAD_REQUEST.value());
            logger.aviso(jsonExcecao.toString());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(jsonExcecao);
        }
    }

    @GetMapping("/clientes/{id}")
    public ResponseEntity<?> buscarPorCpf(@PathVariable("id") String cpf) {
        try {
            Cliente cliente = this.clienteServico.buscarPorCpf(cpf);
            RequisicaoCliente clienteJson = new RequisicaoCliente(cliente.getNome(), cliente.getCpf(), cliente.getEmail());
            return ResponseEntity.status(HttpStatus.OK).body(clienteJson);
        }catch(ClienteNaoEncontradoException e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new RequisicaoExcecao(e.getMessage(), HttpStatus.NOT_FOUND.value()));
        }
    }
}