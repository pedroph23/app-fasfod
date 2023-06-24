package br.com.appfastfood;


import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "Especificação da aplicação de Fast Food"))
public class AppFastfoodApplication {

	public static void main(String[] args) {
		SpringApplication.run(AppFastfoodApplication.class, args);
	}

}
