package br.com.compasso.miniecommerce.config.validacao;

import lombok.AllArgsConstructor;
import lombok.Getter;
@Getter
@AllArgsConstructor
public class ErrorObject {
	
	private final String messagem;
	private final String field;
	private final Object parameter;

}
