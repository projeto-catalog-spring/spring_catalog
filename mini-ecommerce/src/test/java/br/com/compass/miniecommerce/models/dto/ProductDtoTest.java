package br.com.compass.miniecommerce.models.dto;

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

import br.com.compasso.miniecommerce.models.Price;
import br.com.compasso.miniecommerce.models.Product;
import br.com.compasso.miniecommerce.models.dto.ProductReqDto;

@RunWith(MockitoJUnitRunner.class)
public class ProductDtoTest {
	
	private Validator validator;
	
	@Mock
	private ProductReqDto productmock;
	
	@InjectMocks
	private Price pricetest;
	private Product product;

	@Before(value = "setup")
	public void setup() {
		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		this.validator = factory.getValidator();
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void validName() {
		when(productmock.getName()).thenReturn("").thenThrow(new IllegalArgumentException());
		assertEquals(productmock.getName(), productmock.getName().length());
		productmock.getName();
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void validDescription() {
		when(productmock.getDescription()).thenReturn("").thenThrow(new IllegalArgumentException());
		assertEquals(productmock.getDescription(), productmock.getDescription().length());
		productmock.getDescription();
	}
		
	@Test(expected = IllegalArgumentException.class)
	public void validCategory() {
		when(productmock.getCategory()).thenReturn(null).thenThrow(new IllegalArgumentException());
		assertEquals(productmock.getCategory(), productmock.getCategory());
		
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void validBrand() {
		when(productmock.getBrand()).thenReturn(null).thenThrow(new IllegalArgumentException());
		assertEquals(productmock.getBrand(), productmock.getBrand());
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void validPrice() {
		when(productmock.getPrice()).thenReturn(null).thenThrow(new IllegalArgumentException());
		assertEquals(productmock.getPrice(), productmock.getPrice());
		
	}
	
	@Test
	public void updateDTO() {
		when(productmock.update((long) 1, productmock))
		.thenReturn(null).thenThrow(new IllegalArgumentException());
		assertEquals(product, productmock.update((long) 1, productmock));
	}
	
}
