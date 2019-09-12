package br.com.compasso.miniecommerce.models.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import org.modelmapper.ModelMapper;

import br.com.compasso.miniecommerce.models.Brand;
import br.com.compasso.miniecommerce.models.Category;
import br.com.compasso.miniecommerce.models.Price;
import br.com.compasso.miniecommerce.models.Product;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter 
public class ProductReqDto {

	@NotBlank
	private String name;
	@NotBlank
	private String description;
	@NotNull
	private boolean enabled;
	@NotBlank
	private Category category;
	@NotBlank
	private Brand brand;
	@NotBlank
	@Positive
	private Price price;
	
	public Product update(Long id, ProductReqDto dto) {
		return new ModelMapper().map(dto, Product.class);
	}

}