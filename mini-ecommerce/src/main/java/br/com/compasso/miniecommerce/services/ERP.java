package br.com.compasso.miniecommerce.services;

import java.util.Arrays;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.compasso.miniecommerce.models.Brand;
import br.com.compasso.miniecommerce.models.Category;
import br.com.compasso.miniecommerce.models.Price;
import br.com.compasso.miniecommerce.models.Product;
import br.com.compasso.miniecommerce.models.dto.ERPDtoSend;

@RestController
@RequestMapping("/ERP")
public class ERP {

	@GetMapping()
	public ResponseEntity<ERPDtoSend> getData() {

		ERPDtoSend tbe = new ERPDtoSend();
		Price price1 = new Price((long)1, 15.90, 12.90);
		Price price2 = new Price((long)1, 25.90, 18.90);
		Price price3 = new Price((long)1, 115.90, 99.90);
		
		Category c1 = new Category((long)0, "Escritorio");
		Category c2 = new Category((long)1, "Cama mesa e banho");
		
		Brand b1 = new Brand((long)0, "FaberCastell");
		Brand b2 = new Brand((long)1, "Santista");
		
		
		Product product1 = new Product((long)1,"Cadeira","Ergonômica",true,c1, b1, price3);
		Product product2 = new Product((long)1,"Lápis","Lápis Fodão",true,c1, b1, price2);
		Product product3 = new Product((long)1,"Toalha","Toalha de rosto",true,c2, b2, price1);
		
		tbe.setProducts(Arrays.asList(product1, product2, product3));
		tbe.setPrices(Arrays.asList(price1, price2, price3));
		
		return ResponseEntity.ok().body(tbe);
	}

}
