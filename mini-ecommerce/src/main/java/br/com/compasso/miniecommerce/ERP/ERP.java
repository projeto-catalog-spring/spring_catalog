package br.com.compasso.miniecommerce.ERP;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

@RestController
@RequestMapping("/ERP")
public class ERP {

	@Autowired
	PriceRepository priceRepository;

	@Autowired
	CategoryRepository categoryRepository;

	@Autowired
	BrandRepository brandRepository;

	@Autowired
	ProductRepository productRepository;

	@Autowired
	SKURepository skuRepository;

	@GetMapping()
	public ResponseEntity<ERPDtoSend> getData() {

		List<Price> prices = priceRepository.findAll();
		Price price = prices.get(prices.size() - 1);

		Price price1 = new Price(price.getId() + 1, 15.90, 12.90);
		Price price2 = new Price(price.getId() + 2, 25.90, 18.90);
		Price price3 = new Price(price.getId() + 3, 115.90, 99.90);

		List<Category> categorys = categoryRepository.findAll();
		Category category = categorys.get(categorys.size() - 1);

		Category c1 = new Category(category.getId() + 1, "Escritorio");
		Category c2 = new Category(category.getId() + 2, "Cama mesa e banho");

		List<Brand> brands = brandRepository.findAll();
		Brand brand = brands.get(brands.size() - 1);

		Brand b1 = new Brand(brand.getId() + 1, "FaberCastell");
		Brand b2 = new Brand(brand.getId() + 2, "Santista");

		List<Product> products = productRepository.findAll();
		Product product = products.get(products.size() - 1);

		Product product1 = new Product(product.getId() + 1, "Cadeira", "Ergonômica", true, c1, b1, price3);
		Product product2 = new Product(product.getId() + 2, "Lápis", "Lápis Fodão", true, c1, b1, price2);
		Product product3 = new Product(product.getId() + 3, "Toalha", "Toalha de rosto", true, c2, b2, price1);

		List<SKU> skus = skuRepository.findAll();
		SKU sku = skus.get(skus.size() - 1);

		SKU sku1 = new SKU(sku.getId() + 1, "HB", "Lápis HB", 15001, true, product2);
		SKU sku2 = new SKU(sku.getId() + 2, "B2", "Lápis B2", 15000, true, product2);
		SKU sku3 = new SKU(sku.getId() + 3, "B4", "Lápis B4", 15000, true, product2);
		SKU sku4 = new SKU(sku.getId() + 4, "Preta", "Confortável", 100, true, product1);
		SKU sku5 = new SKU(sku.getId() + 5, "azul", "macia", 5000, true, product3);

		ERPDtoSend tbe = new ERPDtoSend();
		tbe.setProducts(Arrays.asList(product1, product2, product3));
		tbe.setSkus(Arrays.asList(sku1, sku2, sku3, sku4, sku5));
		tbe.setPrices(Arrays.asList(price1, price2, price3));

		return ResponseEntity.ok().body(tbe);
	}

}
