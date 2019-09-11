package br.com.compasso.miniecommerce.models.dto;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

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
	
	@JsonProperty("Name")
	private String name;
	private String description;
	private boolean enabled;
	private Category category;
	private Brand brand;
	private Price price;
	
	public Product dtoToProduct(ProductReqDto productDTO) {
		Product entproduct = modelMapper.map(productDTO, Product.class);
		return entproduct;
	}
		
}