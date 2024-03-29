package br.com.compasso.miniecommerce.models.dto;

import org.modelmapper.ModelMapper;

import br.com.compasso.miniecommerce.models.Product;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
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