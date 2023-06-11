package br.com.appfastfood.pedido.application.services; 
 
import br.com.appfastfood.pedido.domain.model.Pedido; 
import br.com.appfastfood.pedido.domain.repositories.PedidoRepository; 
import br.com.appfastfood.pedido.domain.services.PedidoDomainService; 
 
public class PedidoService { 
    private final PedidoRepository pedidoRepository; 
    private final PedidoDomainService pedidoDomainService; 
 
    public PedidoService(PedidoRepository pedidoRepository, PedidoDomainService pedidoDomainService) { 
        this.pedidoRepository = pedidoRepository; 
        this.pedidoDomainService = pedidoDomainService; 
    } 
 
    // Métodos do serviço... 
} 
