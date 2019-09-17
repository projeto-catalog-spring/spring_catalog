package br.com.compasso.miniecommerce.models.dto;

import java.util.ArrayList;

import org.springframework.data.domain.Page;

import com.fasterxml.jackson.annotation.JsonProperty;

import br.com.compasso.miniecommerce.models.Brand;
import br.com.compasso.miniecommerce.models.Category;
import br.com.compasso.miniecommerce.models.Price;
import br.com.compasso.miniecommerce.models.Product;
import br.com.compasso.miniecommerce.models.Sku;
import br.com.compasso.miniecommerce.repository.SkuRepository;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ProductSkusDtoRes {

	@JsonProperty("Id")
	private Long id;

	@JsonProperty("Name")
	private String name;

	@JsonProperty("Description")
	private String description;

	@JsonProperty("Enabled")
	private boolean enabled;

	@JsonProperty("Category")
	private Category category;

	@JsonProperty("Brand")
	private Brand brand;

	@JsonProperty("Price")
	private Price price;

	@JsonProperty("skus")
	private ArrayList<Sku> skus;

	public ProductSkusDtoRes(Product product, SkuRepository repository) {
		this.id = product.getId();
		this.name = product.getName();
		this.description = product.getDescription();
		this.enabled = product.isEnabled();
		this.category = product.getCategory();
		this.brand = product.getBrand();
		this.price = product.getPrice();

		ArrayList<Sku> lista = repository.findSkusByProductId(product.getId());

		this.skus = lista;
	}

	public static Page<ProductDtoRes> convert(Page<Product> products) {
		return products.map(ProductDtoRes::new);
	}

}