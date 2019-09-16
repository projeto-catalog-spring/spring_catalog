package br.com.compasso.miniecommerce.models.dto;

import org.springframework.data.domain.Page;

import com.fasterxml.jackson.annotation.JsonProperty;

import br.com.compasso.miniecommerce.models.Brand;
import br.com.compasso.miniecommerce.models.Category;
import br.com.compasso.miniecommerce.models.Price;
import br.com.compasso.miniecommerce.models.Product;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ProductDtoRes {

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
	
	public ProductDtoRes(Product product) {
		this.id = product.getId();
		this.name = product.getName();
		this.description = product.getDescription();
		this.enabled = product.isEnabled();
		this.category = product.getCategory();
		this.brand = product.getBrand();
		this.price = product.getPrice();
	}

	public static Page<ProductDtoRes> convert(Page<Product> products) {
		return products.map(ProductDtoRes::new);
	}

}