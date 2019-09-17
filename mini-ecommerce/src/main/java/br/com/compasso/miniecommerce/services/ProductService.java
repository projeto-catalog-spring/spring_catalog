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
import br.com.compasso.miniecommerce.models.dto.ProductSkusDtoRes;
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
	public ResponseEntity<ProductSkusDtoRes> getProduct(Long id, Pageable page) {
		Optional<Product> product = repository.findById(id);
		if (product.isPresent()) {
			return ResponseEntity.ok(new ProductSkusDtoRes(product.get(), skuRepository));
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

		product = updateProduct(product, dto);

		if (product == null) {
			return ResponseEntity.notFound().build();
		}

		URI uri = uriBuilder.path("/" + product.getId()).buildAndExpand(product.getId()).toUri();
		return ResponseEntity.created(uri).body(this.mapper.map(repository.save(product), ProductDtoRes.class));
	}

	@Transactional
	public ResponseEntity<ProductDtoRes> editProduct(Long id, ProductDtoReq dto) {
		Optional<Product> productSource = repository.findById(id);

		if (productSource.isPresent()) {
			Product product = updateProduct(new Product(), dto);
			if (product != null) {
				product.setId(id);
				return ResponseEntity.ok(this.mapper.map(repository.save(product), ProductDtoRes.class));
			}
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
				}
			} else {
				product.setEnabled(status);
			}

			return ResponseEntity.ok(new ProductDtoRes(repository.save(productOptional.get())));
		}

		return ResponseEntity.notFound().build();
	}

	@Transactional
	public Product updateProduct(Product product, ProductDtoReq dto) {
		Optional<Brand> brand = brandRepository.findByName(dto.getBrand().getName());
		if (brand.isPresent()) {
			product.setBrand(brand.get());
		} else {
			Brand newBrand = brandRepository.save(this.mapper.map(dto.getBrand(), Brand.class));
			product.setBrand(newBrand);
		}

		Optional<Category> category = categoryRepository.findByName(dto.getCategory().getName());
		if (category.isPresent()) {
			product.setCategory(category.get());
		} else {
			Category newCategory = categoryRepository.save(this.mapper.map(dto.getCategory(), Category.class));
			product.setCategory(newCategory);
		}

		Optional<Price> price = priceRepository.findById(dto.getPrice().getId());
		if (price.isPresent()) {
			product.setPrice(price.get());
		} else {
			return null;
		}

		product.setName(dto.getName());
		product.setDescription(dto.getDescription());

		return product;
	}

}