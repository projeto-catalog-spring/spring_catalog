package br.com.compasso.miniecommerce.config.validacao;

import lombok.Getter;

public class ErrorFormDTO {
	@Getter
	private String campo;
	@Getter
	private String erro;
	
	
	public ErrorFormDTO(String field, String mensagem) {
		this.campo = field;
		this.erro = mensagem;
	}

}
