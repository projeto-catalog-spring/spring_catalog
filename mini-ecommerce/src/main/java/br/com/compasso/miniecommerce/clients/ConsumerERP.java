package br.com.compasso.miniecommerce.clients;

import br.com.compasso.miniecommerce.ERP.ERPDto;
import feign.RequestLine;


public interface ConsumerERP {
	
	@RequestLine("GET")
	public ERPDto getData();


	
}