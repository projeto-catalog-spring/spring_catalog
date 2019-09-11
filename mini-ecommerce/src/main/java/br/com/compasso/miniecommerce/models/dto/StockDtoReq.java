package br.com.compasso.miniecommerce.models.dto;

import javax.validation.constraints.Min;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class StockDtoReq {

	@Min(0)
	private long id;
	
	@Min(1)
	private int qtd;
}
