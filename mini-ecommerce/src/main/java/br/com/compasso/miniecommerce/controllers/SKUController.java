package br.com.compasso.miniecommerce.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sku")
public class SKUController {

	@GetMapping("/")
	public String helloSKU() {
		return "Olá SKU";
	}

}