package br.com.compasso.miniecommerce.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/products")
public class ProductController {

	/*
	 * @Autowired private ProductRepository productres;
	 * 
	 * @GetMapping("/{id}") public ResponseEntity<Product> getById(@RequestParam
	 * long id) { productres.findById(id); return new
	 * ResponseEntity<>(HttpStatus.CREATED); }
	 * 
	 * @GetMapping public Page<ProductResDTO> getAllProducts(
	 * 
	 * @PageableDefault(sort = "id", direction = Direction.DESC, page = 0, size =
	 * 10) Pageable pag) { Page<Product> productget = productres.findAll(pag);
	 * return ProductResDTO.productToDTO(productget); }
	 * 
	 * @PostMapping public ResponseEntity<ProductResDTO> set(@RequestBody @Valid
	 * ProductReqDto productDTO) { ProductReqDto reqprod = new ProductReqDto();
	 * productres.save(reqprod.dtoToProduct(productDTO)); return new
	 * ResponseEntity<>(HttpStatus.CREATED); }
	 */

//	@DeleteMapping("/{id}")
//	public ResponseEntity<Product> delete(@PathVariable long id) {
//		
//		//RN07 - Um produto nunca será excluido, apenas desativado 
//		Optional<Product> optional = productres.findById(id);
//		
//		if(!optional.isPresent()) {
//			Product product = optional.get();
//			product.setEnabled(true);
//			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//		} 
//		return new ResponseEntity<>(HttpStatus.CREATED);
//	}

	// @PutMapping
//	public ResponseEntity<Product> insert(@RequestBody ProductReqDto productDTO) {
//		ProductReqDto reqProduct = new ProductReqDto();
//		productres.saveAll(reqProduct.dtoToProduct(productDTO));
//		return new ResponseEntity<>(HttpStatus.CREATED);
//	}

//	@DeleteMapping("/{id}")
//	public ResponseEntity<Product> delete(@PathVariable long id) {
//
//		// RN07 - Um produto nunca será excluido, apenas desativado
//		Optional<Product> optional = productres.findById(id);
//
//		if (!optional.isPresent()) {
//			Product product = optional.get();
//			product.setEnabled(true);
//			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//		}
//		return new ResponseEntity<>(HttpStatus.CREATED);
//	}

}
