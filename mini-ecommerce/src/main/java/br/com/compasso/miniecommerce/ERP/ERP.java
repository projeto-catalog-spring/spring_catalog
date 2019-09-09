package br.com.compasso.miniecommerce.ERP;

import java.util.Arrays;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.compasso.miniecommerce.models.Brand;
import br.com.compasso.miniecommerce.models.Category;
import br.com.compasso.miniecommerce.models.Price;
import br.com.compasso.miniecommerce.models.Product;
import br.com.compasso.miniecommerce.models.SKU;

@RestController
@RequestMapping("/ERP")
public class ERP {

	@GetMapping()
	public ResponseEntity<ERPDtoSend> getData() {

		Price price1 = new Price((long) 1, 15.90, 12.90);
		Price price2 = new Price((long) 2, 25.90, 18.90);
		Price price3 = new Price((long) 3, 115.90, 99.90);

		Category c1 = new Category((long) 1, "Escritorio");
		Category c2 = new Category((long) 2, "Cama mesa e banho");

		Brand b1 = new Brand((long) 1, "FaberCastell");
		Brand b2 = new Brand((long) 2, "Santista");

		Product product1 = new Product((long) 1, "Cadeira", "Ergonômica", true, c1, b1, price3);
		Product product2 = new Product((long) 2, "Lápis", "Lápis Fodão", true, c1, b1, price2);
		Product product3 = new Product((long) 3, "Toalha", "Toalha de rosto", true, c2, b2, price1);

		SKU sku1 = new SKU((long) 1, "HB", "Lápis HB", 15000, true, product2);
		SKU sku2 = new SKU((long) 2, "B2", "Lápis B2", 15000, true, product2);
		SKU sku3 = new SKU((long) 3, "B4", "Lápis B4", 15000, true, product2);
		SKU sku4 = new SKU((long) 4, "Preta", "Confortável", 100, true, product1);
		SKU sku5 = new SKU((long) 5, "azul", "macia", 5000, true, product3);

		ERPDtoSend tbe = new ERPDtoSend();
		tbe.setProducts (Arrays.asList(product1, product2, product3));
		tbe.setSkus     (Arrays.asList(sku1, sku2, sku3, sku4, sku5));
		tbe.setPrices   (Arrays.asList(price1, price2, price3));

		return ResponseEntity.ok().body(tbe);
	}

}
