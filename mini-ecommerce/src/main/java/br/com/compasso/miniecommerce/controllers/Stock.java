package br.com.compasso.miniecommerce.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Stock {

	@GetMapping("/stock")
	public String stock() {
		// retorna lista com todas skus e o nivel do estoque de cada uma;
		return "Stock level";
	}

	@PutMapping("/stock/sku/{id}/add/{qtd}")
	public String addStock(@PathVariable long id, @PathVariable int qtd) {
		
		return "add" + id;
	}

	@PutMapping("/stock/sku/{id}/remove/{qtd}")
	public String removeStock(@PathVariable long id, @PathVariable int qtd) {
		
		return "remove" + id;
	}
}
