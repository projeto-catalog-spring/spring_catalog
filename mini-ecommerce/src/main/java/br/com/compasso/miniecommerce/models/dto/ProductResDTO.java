package br.com.compasso.miniecommerce.models.dto;


import org.springframework.data.domain.Page;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonProperty;

import br.com.compasso.miniecommerce.models.Brand;
import br.com.compasso.miniecommerce.models.Category;
import br.com.compasso.miniecommerce.models.Price;
import br.com.compasso.miniecommerce.models.Product;
import lombok.AllArgsConstructor;
import lombok.Data;
@AllArgsConstructor
@Data
public class ProductResDTO {
	@JsonAlias({"id", "Id"})
	private Long id; 

	@JsonAlias({"name", "Name"})
	private String name;
	
	@JsonAlias({"description", "Description"})
	private String description;
	
	@JsonAlias({"enabled", "Enabled"})
	private boolean enabled;
	
	@JsonAlias({"category", "Category"})
	private Category category;
	
	@JsonAlias({"brand", "Brand"})
	private Brand brand;
	
	@JsonAlias({"price", "Price"})
	private Price price;
	
	public ProductResDTO(Product product) {
		this.id = product.getId();
		this.name = product.getName();
		this.description = product.getDescription();
		this.enabled = product.isEnabled();
		this.category = product.getCategory();
		this.brand = product.getBrand();
		this.price = product.getPrice();
		
	}
			
	public static Page<ProductResDTO> productToDTO (Page<Product> product) {
		return product.map(ProductResDTO::new);
    }
	/*
	 * public static ProductResDTO transformaEmDTO(Product product) { return new
	 * ProductResDTO(product.getId(), product.getName(), product.getDescription(),
	 * product.isEnabled(), product.getCategory().getId(),
	 * product.getBrand().getId()); }
	 */
	
}