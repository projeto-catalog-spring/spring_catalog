package br.com.compasso.miniecommerce.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.compasso.miniecommerce.models.Product;
import br.com.compasso.miniecommerce.repository.ProductRepository;

@RestController
@RequestMapping("/products")
public class ProductController {
	
	@Autowired
	private ProductRepository productrep;
	
	@GetMapping("/products")
	public List <Product> getAllProducts(){
		return productrep.findAll();
	}
	
}
	
	
	
	
	
	
	

}
