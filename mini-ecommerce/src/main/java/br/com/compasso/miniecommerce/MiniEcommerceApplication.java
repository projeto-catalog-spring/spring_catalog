package br.com.compasso.miniecommerce;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class MiniEcommerceApplication {

	public static void main(String[] args) {
		SpringApplication.run(MiniEcommerceApplication.class, args);
	}

}
