package br.com.compasso.miniecommerce.models.helpers;

import java.util.Optional;

import javax.transaction.Transactional;

import br.com.compasso.miniecommerce.models.Brand;
import br.com.compasso.miniecommerce.models.Category;
import br.com.compasso.miniecommerce.models.Price;
import br.com.compasso.miniecommerce.models.Product;
import br.com.compasso.miniecommerce.models.SKU;
import br.com.compasso.miniecommerce.repository.BrandRepository;
import br.com.compasso.miniecommerce.repository.CategoryRepository;
import br.com.compasso.miniecommerce.repository.PriceRepository;
import br.com.compasso.miniecommerce.repository.ProductRepository;
import br.com.compasso.miniecommerce.repository.SKURepository;

@Transactional
public class HelperUpdate {

	private HelperUpdate() {
	}

	public static void updateCategory(CategoryRepository categoryRepo, Category category) {
		Optional<Category> categoryOp = categoryRepo.findById(category.getId());
		if (!categoryOp.isPresent()) {
			categoryRepo.save(category);
		}
	}

	public static void updateBrand(BrandRepository brandRepo, Brand brand) {
		Optional<Brand> brandOp = brandRepo.findById(brand.getId());
		if (!brandOp.isPresent()) {
			brandRepo.save(brand);
		}
	}

	public static void updateProduct(ProductRepository productRepo, Product product) {
		Optional<Product> productOp = productRepo.findById(product.getId());
		if (productOp.isPresent()) {
			Product p = productOp.get();
			p.setPrice(product.getPrice());
		} else {
			productRepo.save(product);
		}
	}

	public static void updateSKU(SKURepository skuRepo, SKU sku) {
		Optional<SKU> skuOp = skuRepo.findById(sku.getId());
		if (skuOp.isPresent()) {
			SKU s = skuOp.get();
			s.setStock(sku.getStock());
		} else {
			skuRepo.save(sku);
		}
	}

	public static void updatePrice(PriceRepository priceRepo, Price price) {
		Optional<Price> priceOp = priceRepo.findById(price.getId());
		if (priceOp.isPresent()) {
			Price p = priceOp.get();
			p.setPrice(price.getPrice());
			p.setSalePrice(price.getSalePrice());
		} else {
			priceRepo.save(price);
		}
	}

}
