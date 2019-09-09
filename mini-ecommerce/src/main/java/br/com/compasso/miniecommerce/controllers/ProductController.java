package br.com.compasso.miniecommerce.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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
	public List<Product> getAllProducts() {
		return productrep.findAll();
	}

	@PostMapping
	public Product set(@Validated @RequestBody ProductDto products) {
		return productrep.save(products);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Product> delete(@PathVariable long id) {
		
		//RN07 - Um produto nunca será excluido, apenas desativado 
		Optional<Product> optional = productres.findById(id);
		
		if(!optional.isPresent()) {
			Product product = optional.get();
			product.setEnabled(true);
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} 
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
	

//	@PutMapping("/{id}")
//	public Product insert(@RequestBody ProductDto id) {
//		return productrep.findOne(id);
//	}

//	@DeleteMapping("/{id}")
//	public void delete(@RequestBody ProductDto id) {
//		if (productrep.findOne(id) != null) {
//			id.isEnable();
//		}
//	}

}
