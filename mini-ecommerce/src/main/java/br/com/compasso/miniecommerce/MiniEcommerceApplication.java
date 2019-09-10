package br.com.compasso.miniecommerce;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
//@EnableSwagger2
public class MiniEcommerceApplication {

	public static void main(String[] args) {
		SpringApplication.run(MiniEcommerceApplication.class, args);
	}

}
