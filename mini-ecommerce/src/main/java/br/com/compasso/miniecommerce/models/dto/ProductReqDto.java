package br.com.compasso.miniecommerce.models.dto;

import javax.validation.constraints.NotBlank;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import br.com.compasso.miniecommerce.models.Product;
import lombok.Getter;
import lombok.Setter;

public class ProductReqDto {
	@Autowired
    ModelMapper modelMapper;

	@Getter @NotBlank private Long id; 
	@Getter @Setter @NotBlank private String name;
	@Getter @Setter @NotBlank private String description;
	@Getter @Setter @NotBlank private boolean enable;
	@Getter @Setter @NotBlank private Long idCategory;
	@Getter @Setter @NotBlank private Long idBrand;
	
	public Product dtoToProduct(ProductReqDto productDTO) {
		Product entproduct = modelMapper.map(productDTO, Product.class);
		return entproduct;
	}
	
}