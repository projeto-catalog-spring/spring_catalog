package br.com.compasso.miniecommerce.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/products")
public class ProductController {
	
	@Autowired
	private ProductRepository productrep;
	
	@GetMapping("/product")
	public List <Product> getAllProducts(){
		return productrep.findAll();
	}
	
	@PostMapping("/product")
	
	
	@PutMapping("/product")
	
	
	@DeleteMapping("/product")
	
	
	
	
	
	
	

}
