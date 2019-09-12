package br.com.compasso.miniecommerce.models.dto;

import lombok.Data;

@Data
public class ProductDto {

	private Long id; 
	private String name;
	private String description;
	private boolean enable;
	private Long idCategory;
	private Long idBrand;
	
}