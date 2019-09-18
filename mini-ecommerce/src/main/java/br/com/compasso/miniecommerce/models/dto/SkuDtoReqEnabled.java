package br.com.compasso.miniecommerce.models.dto;

import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SkuDtoReqEnabled {
	
	@NotNull
	private boolean enabled;

}
