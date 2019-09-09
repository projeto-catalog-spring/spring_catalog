package br.com.compasso.miniecommerce.models.dto;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import br.com.compasso.miniecommerce.models.Product;
import lombok.Getter;
import lombok.Setter;

public class ProductReqDto {
	@Autowired
    ModelMapper modelMapper;

	@Getter private Long id; 
	@Getter @Setter private String name;
	@Getter @Setter private String description;
	@Getter @Setter private boolean enable;
	@Getter @Setter private Long idCategory;
	@Getter @Setter private Long idBrand;
	
<<<<<<< HEAD:mini-ecommerce/src/main/java/br/com/compasso/miniecommerce/models/dto/ProductReqDto.java

	public Object dtoToProduct(ProductReqDto productDTO) {
		Product entproduct = modelMapper.map(productDTO, Product.class);
		return entproduct;
	}
	
=======
>>>>>>> sprint-1:mini-ecommerce/src/main/java/br/com/compasso/miniecommerce/models/dto/ProductDto.java
}