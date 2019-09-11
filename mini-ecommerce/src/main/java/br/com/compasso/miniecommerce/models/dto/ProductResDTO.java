package br.com.compasso.miniecommerce.models.dto;


import org.springframework.data.domain.Page;

import br.com.compasso.miniecommerce.models.Product;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
@AllArgsConstructor
public class ProductResDTO {
	
	@Getter @Setter private Long id; 
	@Getter @Setter private String name;
	@Getter @Setter private String description;
	@Getter @Setter private boolean enabled;
	@Getter @Setter private Long idCategory;
	@Getter @Setter private Long idBrand;
	@Getter @Setter private Long idPrice;
	
	public ProductResDTO(Product product) {
		this.id = product.getId();
		this.name = product.getName();
		this.description = product.getDescription();
		this.enabled = product.isEnabled();
		this.idCategory = product.getCategory().getId();
		this.idBrand = product.getBrand().getId();
		this.idPrice = product.getPrice().getId();
		
	}
	
	
		
	public static Page<ProductResDTO> productToDTO (Page<Product> product) {
		return product.map(ProductResDTO::new);
    }

	
	
	
	/*
	 * public static ProductResDTO transformaEmDTO(Product product) { return new
	 * ProductResDTO(product.getId(), product.getName(), product.getDescription(),
	 * product.isEnabled(), product.getCategory().getId(),
	 * product.getBrand().getId()); }
	 */
	
}