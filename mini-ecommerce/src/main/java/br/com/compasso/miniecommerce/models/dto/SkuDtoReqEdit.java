package br.com.compasso.miniecommerce.models.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;

import org.hibernate.validator.constraints.Length;

import br.com.compasso.miniecommerce.models.SKU;
import br.com.compasso.miniecommerce.repository.SKURepository;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
public class SkuDtoReqEdit {

	@Getter
	@Setter
	@NotBlank
	@Length(min = 1)
	private String name;

	@Getter
	@Setter
	@NotBlank
	@Length(min = 1)
	private String description;

	@Getter
	@Setter
	@PositiveOrZero
	private int stock;

	@Getter
	@Setter
	@NotNull
	private boolean enabled;

	public SKU update(Long id, SKURepository skuRepository) {

		SKU sku = skuRepository.getOne(id);
		sku.setName(this.name);
		sku.setDescription(this.description);
		sku.setStock(this.stock);
		sku.setEnabled(this.enabled);

		return sku;
	}

}
