package br.com.compasso.miniecommerce.controllers;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.compasso.miniecommerce.models.Product;
import br.com.compasso.miniecommerce.models.dto.ProductDto;
import br.com.compasso.miniecommerce.repository.ProductRepository;

@RestController
@RequestMapping("/products")
public class ProductController {
	
	@Autowired
	private ProductRepository productrep;
	
	@GetMapping 
	public Iterable<Product> getAllProducts(){
		return productrep.findAll();
	}

	
	@PostMapping
	public Product set(@Validated Product products) {
		return productrep.save(products);
	} 
	
	
	@PutMapping
	public Product insert(@RequestBody Product products) {
		return productrep.save(products);
	}
	
	
	@DeleteMapping("/{id}")
	public String delete(@PathVariable long id) {
		
		/* RN07 - Um produto nunca será excluido, apenas desativado */
		Optional<Product> optional = productrep.findById(id);
		
		if(optional.isPresent()) {
			Product product = optional.get();
			product.setEnable(false);
			
			return "Disabled";
		} else { 
			return "Product not find";
		}
	}
	
}
	
	
	
	
	
	
	


