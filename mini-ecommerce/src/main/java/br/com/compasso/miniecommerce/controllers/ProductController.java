package br.com.compasso.miniecommerce.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import br.com.compasso.miniecommerce.models.Product;
import br.com.compasso.miniecommerce.models.dto.ProductReqDto;
import br.com.compasso.miniecommerce.models.dto.ProductResDTO;
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
	public ResponseEntity<ProductResDTO> set(@RequestBody ProductReqDto productDTO) {
		productrep.save(ProductReqDto.dtoToProduct(productDTO));
		return new ResponseEntity<>(HttpStatus.CREATED);
	} 

	/*
	@PutMapping
	public ResponseEntity insert(ProductReqDto productDTO) {
		productrep.save(productDTO);
		 return new ResponseEntity<>(ProductResDTO.productToDTO(productDTO), HttpStatus.CREATED);
	}
	*/
	/*
	@DeleteMapping("/{id}")
	public String delete(@PathVariable long id) {
		
		//RN07 - Um produto nunca será excluido, apenas desativado 
		Optional<Product> optional = productrep.findById(id);
		
		if(optional.isPresent()) {
			Product product = optional.get();
			product.setEnable(false);
			
			return "Disabled";
		} else { 
			return "Product not find";
		}
	}
	*/

	
}
	
	
	
	
	
	
	

