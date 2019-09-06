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
		Product product = new Product((long)1,"asdas","asdasd",true,new Category(), new Brand());
		Price price = new Price((long)1, 15.0, 10.0);
		
		tbe.setProducts(Arrays.asList(product, product, product));
		tbe.setPrices(Arrays.asList(price, price));
		
		return ResponseEntity.ok().body(tbe);

//		return ResponseEntity.ok()
//			      .body("{"
//			    		+ " \"product\":{"
//				      		+ "\"id\":\"0\","
//				      		+ "\"name\":\"SeiLá\","
//				      		+ "\"description\":\"SeiLá\""
//			      		+ "}"
//			    		+"}");
	}

}
