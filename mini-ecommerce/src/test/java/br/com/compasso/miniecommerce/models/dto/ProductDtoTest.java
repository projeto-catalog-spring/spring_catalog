package br.com.compasso.miniecommerce.models.dto;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import org.aspectj.lang.annotation.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import br.com.compasso.miniecommerce.models.Price;
import br.com.compasso.miniecommerce.models.Product;

@RunWith(MockitoJUnitRunner.class)
public class ProductDtoTest {

	@Mock
	private ProductDtoReq productmock;

	@InjectMocks
	private Price pricetest;
	private Product product;

	@Before(value = "setup")
	public void setup() {
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
		when(productmock.update(productmock)).thenReturn(null).thenThrow(new IllegalArgumentException());
		assertEquals(product, productmock.update(productmock));
	}

}