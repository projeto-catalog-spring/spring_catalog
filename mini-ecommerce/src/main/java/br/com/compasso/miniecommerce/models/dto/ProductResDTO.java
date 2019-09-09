package br.com.compasso.miniecommerce.models.dto;


import org.springframework.data.domain.Page;

import br.com.compasso.miniecommerce.models.Product;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
@AllArgsConstructor
public class ProductResDTO {
	
	@Getter private Long id; 
	@Getter @Setter private String name;
	@Getter @Setter private String description;
	@Getter @Setter private boolean enable;
	@Getter @Setter private Long idCategory;
	@Getter @Setter private Long idBrand;
	
	ProductResDTO(Product product) {
		this.id =  product.getId();
		this.name = product.getName();
		this.description = product.getDescription();
		this.enable = isEnable();
		this.idCategory = getIdCategory();
		this.idBrand = getIdBrand();
		
	}
	
	public static Page<ProductResDTO> productToDTO (Page<Product> product) {
		return product.map(ProductResDTO::new);
    }
}