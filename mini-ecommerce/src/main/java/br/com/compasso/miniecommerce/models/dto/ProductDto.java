package br.com.compasso.miniecommerce.models.dto;

import lombok.Getter;
import lombok.Setter;

public class ProductDto {

	@Getter private Long id; 
	@Getter @Setter private String name;
	@Getter @Setter private String description;
	@Getter @Setter private boolean enable;
	@Getter @Setter private Long idCategory;
	@Getter @Setter private Long idBrand;
	
}