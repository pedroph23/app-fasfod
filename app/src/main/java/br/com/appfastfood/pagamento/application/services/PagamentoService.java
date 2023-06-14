package br.com.appfastfood.pagamento.application.services; 
 
import br.com.appfastfood.pagamento.domain.model.Pagamento; 
import br.com.appfastfood.pagamento.domain.repositories.PagamentoRepository; 
import br.com.appfastfood.pagamento.domain.services.PagamentoDomainService; 
 
public class PagamentoService { 
    private final PagamentoRepository pagamentoRepository; 
    private final PagamentoDomainService pagamentoDomainService; 
 
    public PagamentoService(PagamentoRepository pagamentoRepository, PagamentoDomainService pagamentoDomainService) { 
        this.pagamentoRepository = pagamentoRepository; 
        this.pagamentoDomainService = pagamentoDomainService; 
    } 
 
    // Métodos do serviço... 
} 
