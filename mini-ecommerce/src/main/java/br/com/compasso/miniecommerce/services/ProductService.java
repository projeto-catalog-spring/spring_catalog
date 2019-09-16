package br.com.compasso.miniecommerce.services;

import java.net.URI;
import java.util.Optional;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.compasso.miniecommerce.models.Brand;
import br.com.compasso.miniecommerce.models.Category;
import br.com.compasso.miniecommerce.models.Price;
import br.com.compasso.miniecommerce.models.Product;
import br.com.compasso.miniecommerce.models.Sku;
import br.com.compasso.miniecommerce.models.dto.ProductDtoReq;
import br.com.compasso.miniecommerce.models.dto.ProductDtoRes;
import br.com.compasso.miniecommerce.models.dto.SkuDtoRes;
import br.com.compasso.miniecommerce.repository.BrandRepository;
import br.com.compasso.miniecommerce.repository.CategoryRepository;
import br.com.compasso.miniecommerce.repository.PriceRepository;
import br.com.compasso.miniecommerce.repository.ProductRepository;
import br.com.compasso.miniecommerce.repository.SkuRepository;

@Service("ProductService")
public class ProductService {

	@Autowired
	private ProductRepository repository;

	@Autowired
	private SkuRepository skuRepository;

	@Autowired
	private BrandRepository brandRepository;

	@Autowired
	private CategoryRepository categoryRepository;

	@Autowired
	private PriceRepository priceRepository;

	@Autowired
	private ModelMapper mapper = new ModelMapper();

	@Transactional
	public ResponseEntity<Page<ProductDtoRes>> getAllProducts(Pageable page) {
		return ResponseEntity.ok(ProductDtoRes.convert(repository.findAll(page)));
	}

	@Transactional
	public ResponseEntity<ProductDtoRes> getProduct(Long id, Pageable page) {
		Optional<Product> product = repository.findById(id);
		if (product.isPresent()) {
			return ResponseEntity.ok(this.mapper.map(product.get(), ProductDtoRes.class));
		}

		return ResponseEntity.notFound().build();
	}

	@Transactional
	public ResponseEntity<Page<SkuDtoRes>> getProductSkus(Long id, Pageable page) {
		Page<Sku> skus = skuRepository.findByProductId(id, page);

		if (repository.findById(id).isPresent()) {
			return ResponseEntity.ok(SkuDtoRes.convert(skus));
		}

		return ResponseEntity.notFound().build();
	}

	@Transactional
	public ResponseEntity<ProductDtoRes> addProduct(ProductDtoReq dto, UriComponentsBuilder uriBuilder) {
		Product product = mapper.map(dto, Product.class);

		Optional<Brand> branch = brandRepository.findByName(product.getBrand().getName());
		if (branch.isPresent()) {
			product.setBrand(branch.get());
		} else {
			product.setBrand(brandRepository.save(this.mapper.map(dto.getBrand(), Brand.class)));
		}

		Optional<Category> category = categoryRepository.findByName(product.getCategory().getName());
		if (category.isPresent()) {
			product.setCategory(category.get());
		} else {
			product.setCategory(categoryRepository.save(this.mapper.map(dto.getCategory(), Category.class)));
		}

		Optional<Price> price = priceRepository.findById(product.getPrice().getId());
		if (price.isPresent()) {
			product.setPrice(price.get());
		} else {
			return ResponseEntity.notFound().build();
		}

		repository.save(product);

		URI uri = uriBuilder.path("/" + product.getId()).buildAndExpand(product.getId()).toUri();
		return ResponseEntity.created(uri).body(this.mapper.map(product, ProductDtoRes.class));
	}

	@Transactional
	public ResponseEntity<ProductDtoRes> editProduct(Long id, ProductDtoReq dto) {
		Optional<Product> productX = repository.findById(id);
		if (productX.isPresent()) {
			Product product = productX.get();

			Optional<Brand> branch = brandRepository.findByName(dto.getBrand().getName());
			if (branch.isPresent()) {
				product.setBrand(branch.get());
			} else {
				product.setBrand(brandRepository.save(this.mapper.map(dto.getBrand(), Brand.class)));
			}

			Optional<Category> category = categoryRepository.findByName(dto.getCategory().getName());
			if (category.isPresent()) {
				product.setCategory(category.get());
			} else {
				product.setCategory(categoryRepository.save(this.mapper.map(dto.getCategory(), Category.class)));
			}

			Optional<Price> price = priceRepository.findById(dto.getPrice().getId());
			if (price.isPresent()) {
				product.setPrice(price.get());
			} else {
				return ResponseEntity.notFound().build();
			}

			product.setName(dto.getName());
			product.setDescription(dto.getDescription());

			return ResponseEntity.ok(this.mapper.map(repository.save(product), ProductDtoRes.class));
		}

		return ResponseEntity.notFound().build();

	}

	@Transactional
	public ResponseEntity<ProductDtoRes> removeProduct(long id, boolean status) {
		Optional<Product> productOptional = repository.findById(id);

		if (productOptional.isPresent()) {
			Product product = productOptional.get();
			if (status) {
				if (repository.findAllSkus(id) > 0 && product.getPrice().getPrice() > 0) {
					product.setEnabled(status);
					return ResponseEntity.ok(new ProductDtoRes(repository.save(productOptional.get())));
				}
			} else {
				product.setEnabled(status);
			}
		}

		return ResponseEntity.notFound().build();
	}

}