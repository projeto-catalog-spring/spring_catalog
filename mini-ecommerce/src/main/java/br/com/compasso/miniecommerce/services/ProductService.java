package br.com.compasso.miniecommerce.services;

import java.util.Optional;

import javax.transaction.Transactional;
import javax.validation.constraints.NotEmpty;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import br.com.compasso.miniecommerce.models.Brand;
import br.com.compasso.miniecommerce.models.Category;
import br.com.compasso.miniecommerce.models.Price;
import br.com.compasso.miniecommerce.models.Product;
import br.com.compasso.miniecommerce.models.dto.ProductDtoReq;
import br.com.compasso.miniecommerce.models.dto.ProductDtoRes;
import br.com.compasso.miniecommerce.repository.BrandRepository;
import br.com.compasso.miniecommerce.repository.CategoryRepository;
import br.com.compasso.miniecommerce.repository.PriceRepository;
import br.com.compasso.miniecommerce.repository.ProductRepository;
import br.com.compasso.miniecommerce.repository.SKURepository;

@Service("ProductService")
public class ProductService {

	@Autowired
	private ProductRepository repository;

	@Autowired
	private SKURepository skuRepository;

	@Autowired
	private BrandRepository brandRepository;

	@Autowired
	private CategoryRepository categoryRepository;

	@Autowired
	private PriceRepository priceRepository;

	public Product addProduct(Product product) {
		Optional<Brand> branch = brandRepository.findByName(product.getBrand().getName());
		if (branch.isPresent()) {
			product.setBrand(branch.get());
		}

		Optional<Category> category = categoryRepository.findByName(product.getCategory().getName());
		if (category.isPresent()) {
			product.setCategory(category.get());
		}

		Optional<Price> price = priceRepository.findById(product.getPrice().getId());
		if (price.isPresent()) {
			product.setPrice(price.get());
		}

		return repository.save(product);
	}

	@Transactional
	public ResponseEntity<ProductDtoRes> editProduct(Long id, ProductDtoReq dto) {
		Product updatedProduct = dto.update(dto);

		Optional<Product> product = repository.findById(id);

		if (product.isPresent()) {
			updatedProduct.setId(product.get().getId());
		}

		if (true) {
			Optional<Brand> brand = brandRepository.findByName(dto.getBrand().getName());
			if (brand.isPresent()) {
				updatedProduct.setBrand(brand.get());
			} else {
				updatedProduct.setBrand(brandRepository.save(dto.getBrand()));
			}

			Optional<Category> category = categoryRepository.findByName(dto.getCategory().getName());
			if (category.isPresent()) {
				updatedProduct.setCategory(category.get());
			} else {
				updatedProduct.setCategory(categoryRepository.save(dto.getCategory()));
			}

			Optional<Price> price = priceRepository.findById(dto.getPrice().getId());
			if (price.isPresent()) {
				updatedProduct.setPrice(price.get());
			}
		}

		return ResponseEntity.ok(new ProductDtoRes(repository.save(updatedProduct)));
	}

	@Transactional
	public ResponseEntity<ProductDtoRes> removeProduct(long id, boolean status) {
		Optional<Product> productOptional = repository.findById(id);

		if (productOptional.isPresent()) {
			Product product = productOptional.get();
			if (status) {
				int numeroDeSkusAtivas = repository.findAllSkus(id);

				if (numeroDeSkusAtivas > 0 && product.getPrice().getPrice() > 0) {
					product.setEnabled(status);
				}

			} else {
				product.setEnabled(status);
			}

			return ResponseEntity.ok(new ProductDtoRes(repository.save(productOptional.get())));
		}

		return ResponseEntity.notFound().build();
	}

	public void activateProduct(Product product) {
		product.setEnabled(true);
	}

	// RN05 - Um produto ativo tem que ter um preço valido
	public boolean validatePrice(@NotEmpty @Validated Product product) {
		return (skuRepository.existsById(product.getId())) ? true : false;
	}

	/* Verifica se o produto está ativo */
	public boolean isEnabled(Product product) {
		return repository.isActive(product.getId());
	}

}