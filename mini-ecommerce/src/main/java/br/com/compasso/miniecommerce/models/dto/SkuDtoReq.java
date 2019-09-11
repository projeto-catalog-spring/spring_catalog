package br.com.compasso.miniecommerce.models.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;

import org.hibernate.validator.constraints.Length;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class SkuDtoReq {

	@NotBlank
	@Length(min = 1)
	private String name;

	@NotBlank
	@Length(min = 1)
	private String description;

	@PositiveOrZero
	private int stock;

	@PositiveOrZero
	private int productId;

	@NotNull
	private boolean enabled;

}
