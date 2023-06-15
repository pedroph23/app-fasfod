package br.com.appfastfood.cliente.infraestrutura.configuracoes;

import br.com.appfastfood.AppFastfoodApplication;
import br.com.appfastfood.cliente.dominio.repositorios.ClienteRepositorio;
import br.com.appfastfood.cliente.dominio.servicos.adaptadores.ClienteServicoImpl;
import br.com.appfastfood.cliente.dominio.servicos.portas.ClienteServico;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackageClasses = AppFastfoodApplication.class)
public class BeanConfiguration {

    @Bean
    ClienteServico clienteServico(final ClienteRepositorio clienteRepositorio){
        return new ClienteServicoImpl(clienteRepositorio);
    }
}
