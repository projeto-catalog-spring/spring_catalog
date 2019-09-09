package br.com.compasso.miniecommerce.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.compasso.miniecommerce.models.Product;
import br.com.compasso.miniecommerce.repository.ProductRepository;
import br.com.compasso.miniecommerce.repository.SKURepository;

@Service
public class ProductService {
	@Autowired
	public ProductRepository productrep;
	public SKURepository skurep;
	
	public boolean requestERP() {
		return false;
	}
	
	public boolean verifySKU(Product product){
		if(!(skurep.existsById(product.getId())) && (skurep.isEnabled(product.getId()))) {
			product.setEnable(false);
			return false;
		} 
		return true;
	}
	
	public boolean verifyPrice(Product product){
		return true;	
	}
	
	
	
	
	
	

}
