package br.com.compasso.miniecommerce.service;

import java.util.Optional;

import javax.validation.constraints.NotEmpty;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import br.com.compasso.miniecommerce.models.Brand;
import br.com.compasso.miniecommerce.models.Category;
import br.com.compasso.miniecommerce.models.Price;
import br.com.compasso.miniecommerce.models.Product;
import br.com.compasso.miniecommerce.models.dto.ProductReqDto;
import br.com.compasso.miniecommerce.repository.BrandRepository;
import br.com.compasso.miniecommerce.repository.CategoryRepository;
import br.com.compasso.miniecommerce.repository.PriceRepository;
import br.com.compasso.miniecommerce.repository.ProductRepository;
import br.com.compasso.miniecommerce.repository.SKURepository;
import springfox.documentation.schema.Model;

@Service("ProductService")
public class ProductService {
	@Autowired
	public ProductRepository productrep;
	public SKURepository skurep;
	ModelMapper model = new ModelMapper();

	
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
	
	

}