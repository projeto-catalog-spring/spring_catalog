package br.com.compasso.miniecommerce.services;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.aspectj.lang.annotation.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.compasso.miniecommerce.models.Product;
import br.com.compasso.miniecommerce.models.dto.ProductReqDto;
import br.com.compasso.miniecommerce.models.dto.ProductResDTO;

@RunWith(MockitoJUnitRunner.class)
public class ProductServiceTest {
	

	private Validator validator;
	
	@Mock
	private ProductService productService;
	private Product product;
	
	@InjectMocks
	private ProductReqDto prodDTO;
	private ProductResDTO prodDTOres;
	private UriComponentsBuilder uri;

	
	@Before(value = "setup")
	public void setup() {
		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		this.validator = factory.getValidator();
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void addProduct() {
		when(productService.addProduct(product)).thenReturn(null).thenThrow(new IllegalArgumentException());
		assertEquals(product, product);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void editProduct() {
		when(productService.editProduct(product.getId(), prodDTO, uri)).thenReturn(null).thenThrow(new IllegalArgumentException());
		assertEquals(product, product);
	}
	@Test(expected = IllegalArgumentException.class)
	public void removeProduct() {
		when(productService.removeProduct(product.getId(), true, uri)).thenReturn(null).thenThrow(new IllegalArgumentException());
		
	}


	

}
