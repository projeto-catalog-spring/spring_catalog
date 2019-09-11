package br.com.compasso.miniecommerce.controllers;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import br.com.compasso.miniecommerce.models.Product;
import br.com.compasso.miniecommerce.models.SKU;

@RunWith(MockitoJUnitRunner.class)
public class SkuControllerTest {
	
	@Test
	private void testListAllMethod() {
		
		Product product = new Product(45741L, "Produto Aleatório", "Descrição aleatória", true, null, null, null);
		SKU sku = new SKU(283672L, "Cor aleatótia de um produto", "Descrição aleatória da SKU", 1500, true, product);
		
	}
}
