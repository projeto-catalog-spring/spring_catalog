package br.com.compasso.miniecommerce.services;

import java.util.Optional;

import javax.validation.constraints.NotEmpty;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import br.com.compasso.miniecommerce.models.Product;
import br.com.compasso.miniecommerce.models.dto.ProductReqDto;
import br.com.compasso.miniecommerce.repository.ProductRepository;
import br.com.compasso.miniecommerce.repository.SKURepository;

@Service("ProductService")
public class ProductService {
	@Autowired
	public ProductRepository productrep;
	public SKURepository skurep;
	public Product product;
	ModelMapper model = new ModelMapper();

	public Product saveProduct(Product product) {
		return productrep.save(product);
	}
	
	public Product editProduct(Long id, ProductReqDto proDTO) {
		Optional<Product> productget = productrep.findById(id);
		if(productget.isPresent()) {
			return proDTO.update(id, productrep);
		}
		return null;
	}
	
	//RN03 - RN04 - Um produto ativo deve ter pelo menos uma SKU ativa
	public void activeProduct (Product product) {
		if(productrep.isActive(product.getId())) {
			product.setEnabled(true);
		} else {
			product.setEnabled(false);
		}		
	}
	
	//RN05 - Um produto ativo tem que ter um preço valido
	public boolean validatePrice(@NotEmpty @Validated Product product){
		return (skurep.existsById(product.getId())) ? true: false;
	}
	
	/* Verifica se o produto está ativo */
	public boolean isEnabled(Product product) {
		return productrep.isActive(product.getId());
	}
	
	public boolean deleteProduct(long id) {
		Optional<Product> productOptional = productrep.findById(id);
		if(productOptional.isPresent()) {
			Product product = productOptional.get();
			product.setEnabled(false);
			return true;
		}
		return false;
	}
	
	

}