//package br.com.compasso.miniecommerce.service;
//
//import javax.validation.constraints.NotEmpty;
//import javax.validation.constraints.PositiveOrZero;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import org.springframework.validation.annotation.Validated;
//
//import br.com.compasso.miniecommerce.models.Product;
//import br.com.compasso.miniecommerce.repository.ProductRepository;
//import br.com.compasso.miniecommerce.repository.SKURepository;
//
//@Service
//public class ProductService {
//	@Autowired
//	public ProductRepository productrep;
//	public SKURepository skurep;
//
//	public boolean requestERP() {
//		return false;
//	}
//
//	// RN03 - Um produto ativo deve ter pelo menos uma SKU ativa
//	public boolean validateSKU(Product product) {
//		if (!(skurep.existsById(product.getId())) && skurep.isEnabled(product.getId())) {
//			return false;
//		}
//		return true;
//	}
//
//	// RN04 - Um produto ativo tem que ter pelo menos uma SKU com estoque
//	public boolean validateStock(@NotEmpty @Validated Product product) {
//
//	//RN05 - Um produto ativo tem que ter um preço valido
//	public boolean validatePrice(@NotEmpty @Validated Product product){
//		return false;}
//	
//	public void activeProduct (Product product) {
//		if(validateSKU(product) && validatePrice(product)) {
//			product.setEnable(true);
//		} 
//	}
