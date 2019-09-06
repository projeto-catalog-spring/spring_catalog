package br.com.compasso.miniecommerce.models.dto;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import br.com.compasso.miniecommerce.models.Product;
import lombok.Getter;
import lombok.Setter;

public class ProductResDTO {
	@Autowired
	static
    ModelMapper modelMapper;
	
	@Getter private Long id; 
	@Getter @Setter private String name;
	@Getter @Setter private String description;
	@Getter @Setter private boolean enable;
	@Getter @Setter private Long idCategory;
	@Getter @Setter private Long idBrand;
	
	public static ProductResDTO productToDTO (ProductReqDto productDTO) {
		ProductResDTO productresdto = modelMapper.map(productDTO, ProductResDTO.class);
		return productresdto;
    }
}
	