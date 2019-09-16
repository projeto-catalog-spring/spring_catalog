package br.com.compasso.miniecommerce.models.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;

import org.hibernate.validator.constraints.Length;

import br.com.compasso.miniecommerce.models.Sku;
import br.com.compasso.miniecommerce.repository.SkuRepository;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class SkuDtoReqEdit {

	@NotBlank
	@Length(min = 1)
	private String name;

	@NotBlank
	@Length(min = 1)
	private String description;

	@PositiveOrZero
	private int stock;
	
	@NotNull
	private boolean enabled;

	public Sku update(Long id, SkuRepository skuRepository) {
		Sku sku = skuRepository.getOne(id);

		sku.setName(this.name);
		sku.setDescription(this.description);
		sku.setStock(this.stock);
		sku.setEnabled(this.enabled);

		return sku;
	}

}
