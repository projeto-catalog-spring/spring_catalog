package br.com.compasso.miniecommerce.clients;

import br.com.compasso.miniecommerce.models.dto.ERPDto;
import feign.RequestLine;


public interface ConsumerERP {
	
	@RequestLine("GET")
	public ERPDto getData();

}