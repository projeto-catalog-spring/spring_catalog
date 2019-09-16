package br.com.compasso.miniecommerce.models.dto;

import org.modelmapper.ModelMapper;

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
	private CategoryDtoAddProductReq category;
	private BrandDtoAddProductReq brand;
	private PriceDtoAddProductReq price;

	public Product update(ProductDtoReq dto) {
		return new ModelMapper().map(dto, Product.class);
	}

}