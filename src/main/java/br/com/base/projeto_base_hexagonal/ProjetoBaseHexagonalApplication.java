package br.com.base.projeto_base_hexagonal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class ProjetoBaseHexagonalApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProjetoBaseHexagonalApplication.class, args);
	}

}
