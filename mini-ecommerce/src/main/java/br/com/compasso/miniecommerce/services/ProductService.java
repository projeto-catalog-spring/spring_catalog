package br.com.compasso.miniecommerce.services;

import java.net.URI;
import java.util.Optional;

import javax.transaction.Transactional;
import javax.validation.constraints.NotEmpty;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.compasso.miniecommerce.models.Brand;
import br.com.compasso.miniecommerce.models.Category;
import br.com.compasso.miniecommerce.models.Price;
import br.com.compasso.miniecommerce.models.Product;
import br.com.compasso.miniecommerce.models.dto.ProductReqDto;
import br.com.compasso.miniecommerce.models.dto.ProductResDTO;
import br.com.compasso.miniecommerce.repository.BrandRepository;
import br.com.compasso.miniecommerce.repository.CategoryRepository;
import br.com.compasso.miniecommerce.repository.PriceRepository;
import br.com.compasso.miniecommerce.repository.ProductRepository;
import br.com.compasso.miniecommerce.repository.SKURepository;

@Service("ProductService")
public class ProductService {

	@Autowired
	public ProductRepository repository;

	@Autowired
	public SKURepository skurep;

	@Autowired
	private BrandRepository br;

	@Autowired
	private CategoryRepository cr;

	@Autowired
	private PriceRepository pr;

	public Product addProduct(Product product) {
		Optional<Brand> branch = br.findById(product.getBrand().getId());
		if (branch.isPresent()) {
			product.setBrand(branch.get());
		}

		Optional<Category> category = cr.findById(product.getCategory().getId());
		if (category.isPresent()) {
			product.setCategory(category.get());
		}

		Optional<Price> price = pr.findById(product.getPrice().getId());
		if (price.isPresent()) {
			product.setPrice(price.get());
		}

		return repository.save(product);
	}

	@Transactional
	public ResponseEntity<ProductResDTO> editProduct(Long id, ProductReqDto dto, UriComponentsBuilder uriBuilder) {
		Optional<Product> product = repository.findById(id);

		if (product.isPresent()) {
			Optional<Brand> brand = br.findByName(dto.getBrand().getName());
			if (brand.isPresent()) {
				product.get().setBrand(brand.get());
			} else {
				product.get().setBrand(br.save(dto.getBrand()));
			}
			
			Optional<Category> category = cr.findByName(dto.getCategory().getName());
			if (category.isPresent()) {
				product.get().setCategory(category.get());
			} else {
				product.get().setCategory(cr.save(dto.getCategory()));
			}

			Optional<Price> price = pr.findById(dto.getPrice().getId());
			if (price.isPresent()) {
				product.get().setPrice(price.get());
			}
		}

		URI uri = uriBuilder.path("/{id}").buildAndExpand(id).toUri();
		return ResponseEntity.created(uri).body(new ProductResDTO(product.get()));
	}

	// RN03 - RN04 - Um produto ativo deve ter pelo menos uma SKU ativa
	public void activeProduct(Product product) {
		if (repository.isActive(product.getId())) {
			product.setEnabled(true);
		} else {
			product.setEnabled(false);
		}
	}

	// RN05 - Um produto ativo tem que ter um preço valido
	public boolean validatePrice(@NotEmpty @Validated Product product) {
		return (skurep.existsById(product.getId())) ? true : false;
	}

	/* Verifica se o produto está ativo */
	public boolean isEnabled(Product product) {
		return repository.isActive(product.getId());
	}

	public boolean deleteProduct(long id) {
		Optional<Product> productOptional = repository.findById(id);
		if (productOptional.isPresent()) {
			Product product = productOptional.get();
			product.setEnabled(false);
			return true;
		}
		return false;
	}

}