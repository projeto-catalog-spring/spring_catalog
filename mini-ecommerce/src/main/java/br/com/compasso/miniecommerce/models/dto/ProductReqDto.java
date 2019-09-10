package br.com.compasso.miniecommerce.models.dto;

import javax.validation.constraints.NotBlank;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import br.com.compasso.miniecommerce.models.Product;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
public class ProductReqDto {
	@Autowired
    ModelMapper modelMapper = new ModelMapper();

	@Getter private Long id; 
	@Getter @Setter  private String name;
	@Getter @Setter  private String description;
	@Getter @Setter  private boolean enabled;
	@Getter @Setter  private Long idCategory;
	@Getter @Setter  private Long idBrand;
	@Getter @Setter  private Long idPrice;
	
	public Product dtoToProduct(ProductReqDto productDTO) {
		Product entproduct = modelMapper.map(productDTO, Product.class);
		return entproduct;
	}
		
}