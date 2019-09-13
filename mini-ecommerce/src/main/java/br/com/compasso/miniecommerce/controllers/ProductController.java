package br.com.compasso.miniecommerce.controllers;

import java.net.URI;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.compasso.miniecommerce.models.Product;
import br.com.compasso.miniecommerce.models.dto.ProductDtoReq;
import br.com.compasso.miniecommerce.models.dto.ProductDtoRes;
import br.com.compasso.miniecommerce.repository.ProductRepository;
import br.com.compasso.miniecommerce.services.ProductService;

@RestController
@RequestMapping("/products")
public class ProductController {

	@Autowired
	private ProductRepository repository;
	
	@Autowired
	private ProductService service;

	private ModelMapper mapper = new ModelMapper();

	@GetMapping
	public Page<ProductDtoRes> getAllProducts(
			@PageableDefault(sort = "id", direction = Direction.ASC, page = 0, size = 10) Pageable page) {
		Page<Product> products = repository.findAll(page);
		return ProductDtoRes.productToDTO(products);
	}

	@GetMapping("/{id}/skus")
	public Page<ProductDtoRes> getProductSkus(
			@PageableDefault(sort = "id", direction = Direction.ASC, page = 0, size = 10) Pageable page,
			@PathVariable Long id) {

		Page<Product> productget = repository.findAllSkusPaginated(id, page);
		return ProductDtoRes.productToDTO(productget);
	}

	@PostMapping
	public ResponseEntity<ProductDtoRes> addProduct(@RequestBody ProductDtoReq dto, UriComponentsBuilder uriBuilder) {
		Product product = service.addProduct(mapper.map(dto, Product.class));

		URI uri = uriBuilder.path("/{id}").buildAndExpand(product).toUri();
		return ResponseEntity.created(uri).body(new ProductDtoRes(product));
	}

	@GetMapping("/{id}")
	public ResponseEntity<ProductDtoRes> getProduct(@PathVariable Long id) {
		Optional<Product> productget = repository.findById(id);
		if (productget.isPresent()) {
			return ResponseEntity.ok(new ProductDtoRes(productget.get()));
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@PutMapping("/{id}")
	public ResponseEntity<ProductDtoRes> editProduct(@PathVariable Long id, @RequestBody ProductDtoReq productDTO) {
		return service.editProduct(id, productDTO);
	}

	@PutMapping("/{id}/{status}")
	public ResponseEntity<ProductDtoRes> removeProduct(@PathVariable long id, @PathVariable boolean status) {
		return service.removeProduct(id, status);
	}

}
