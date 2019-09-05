package br.com.compasso.miniecommerce.models.dto;

import javax.validation.constraints.Min;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public class StockDtoReq {

	@Min(0) @Getter private long id;
	@Min(1) @Getter private int qtd;
}
