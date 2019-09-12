package br.com.compasso.miniecommerce.models.dto;

import org.modelmapper.ModelMapper;

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
public class ProductDtoReq {

	private String name;
	private String description;
	private Category category;
	private Brand brand;
	private Price price;
	
	public Product update(ProductDtoReq dto) {
		return new ModelMapper().map(dto, Product.class);
	}

}