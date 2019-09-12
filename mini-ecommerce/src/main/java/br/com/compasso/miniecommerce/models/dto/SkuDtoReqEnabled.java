package br.com.compasso.miniecommerce.models.dto;

import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
public class SkuDtoReqEnabled {
	
	@NotNull
	private boolean enabled;

}
