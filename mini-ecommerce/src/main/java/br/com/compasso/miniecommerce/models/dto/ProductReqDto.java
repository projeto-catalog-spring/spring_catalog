package br.com.compasso.miniecommerce.models.dto;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonProperty;

import br.com.compasso.miniecommerce.models.Brand;
import br.com.compasso.miniecommerce.models.Category;
import br.com.compasso.miniecommerce.models.Price;
import br.com.compasso.miniecommerce.models.Product;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Data
public class ProductReqDto {
	@Autowired
    ModelMapper modelMapper = new ModelMapper();
	
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
	
	public Product dtoToProduct(ProductReqDto productDTO) {
		Product entproduct = modelMapper.map(productDTO, Product.class);
		return entproduct;
	}
		
}