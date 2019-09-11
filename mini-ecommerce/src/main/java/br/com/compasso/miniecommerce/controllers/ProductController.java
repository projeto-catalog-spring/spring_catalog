package br.com.compasso.miniecommerce.controllers;

import java.util.Optional;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.compasso.miniecommerce.models.Product;
import br.com.compasso.miniecommerce.models.dto.ProductReqDto;
import br.com.compasso.miniecommerce.models.dto.ProductResDTO;
import br.com.compasso.miniecommerce.repository.ProductRepository;
import br.com.compasso.miniecommerce.services.ProductService;


@RestController
@RequestMapping("/products")
public class ProductController {

	@Autowired
	private ProductRepository productres;	
	
	@Autowired
	private ProductService service;	
	
	@GetMapping("/{id}")
	public ResponseEntity<ProductResDTO> getById(Long id){ 
		Optional<Product> productget = productres.findById(id);
		if(productget.isPresent()) {
			return ResponseEntity.ok(new ProductResDTO(productget.get()));
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@GetMapping
	public Page<ProductResDTO> getAllProducts(@PageableDefault (sort = "id", direction = Direction.DESC, page = 0, size = 10) Pageable pag){
		Page<Product> productget = productres.findAll(pag);
		return ProductResDTO.productToDTO(productget);
	}

	@PostMapping
	public ResponseEntity<Product> set(@RequestBody ProductReqDto productDTO) {
			
		ModelMapper model = new ModelMapper(); 
		Product product = model.map(productDTO, Product.class);
		
		productres.save(product);		
		return ResponseEntity.status(HttpStatus.CREATED).build();
	}
	
	@PutMapping("/{id}")
	public Product insert(@RequestBody ProductReqDto productDTO) {
		ProductReqDto reqProduct = new ProductReqDto();		
		return productres.save(reqProduct.dtoToProduct(productDTO));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Product> delete(long id) {
		
		//RN07 - Um produto nunca será excluido, apenas desativado 
		Optional<Product> productOptional = productres.findById(id);
		
		if(productOptional.isPresent()) {
			Product product = productOptional.get();
			product.setEnabled(false);
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} 
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
	

	
}
