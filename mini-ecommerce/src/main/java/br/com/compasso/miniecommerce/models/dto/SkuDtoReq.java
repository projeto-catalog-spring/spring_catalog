package br.com.compasso.miniecommerce.models.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;

import org.hibernate.validator.constraints.Length;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
public class SkuDtoReq {

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
	@PositiveOrZero
	private int productId;

	@Getter
	@Setter
	@NotNull
	private boolean enabled;

}
