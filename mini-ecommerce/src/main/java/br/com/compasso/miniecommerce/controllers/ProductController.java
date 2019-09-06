package br.com.compasso.miniecommerce.controllers;


import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.hibernate.validator.internal.util.privilegedactions.NewInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.compasso.miniecommerce.models.Product;
import br.com.compasso.miniecommerce.models.dto.ProductDto;
import br.com.compasso.miniecommerce.repository.ProductRepository;
import io.swagger.models.Response;
import org.modelmapper.ModelMapper;

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
	public String set(@Validated @RequestBody ProductDto products) {
		
		ModelMapper modelMapper = new ModelMapper();
//		modelMapper.map(, Product.class);
		modelMapper.typeMap(product, Product.class);
		productrep.save(products);
		return "teste";
	} 

		

	@PutMapping
	public String insert(Product products) {
			productrep.save(products);
		 return "Save";
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
	
	
	
	
	
	
	


