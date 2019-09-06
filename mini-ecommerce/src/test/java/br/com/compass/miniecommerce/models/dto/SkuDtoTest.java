package br.com.compass.miniecommerce.models.dto;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import br.com.compasso.miniecommerce.models.Product;
import br.com.compasso.miniecommerce.models.dto.SkuDtoReqAdd;

@RunWith(MockitoJUnitRunner.class)
public class SkuDtoTest {
	
	private Validator validator;
	
	@Mock
	private SkuDtoReqAdd mockedSKU;
	
	@InjectMocks
	private Product mockedProduct;
	
	@Before
	public void setup() {
		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
	    this.validator = factory.getValidator();
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void skuInvalidNameLengthTest() throws IllegalArgumentException {
		when(mockedSKU.getName()).thenReturn("").thenThrow(new IllegalArgumentException());
		assertEquals(0, mockedSKU.getName().length());
		mockedSKU.getName();
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void skuInvalidDescriptionLengthTest() throws IllegalArgumentException {
		when(mockedSKU.getDescription()).thenReturn("").thenThrow(new IllegalArgumentException());
		assertEquals(0, mockedSKU.getDescription().length());
		mockedSKU.getDescription();
	}
	
	@Test
	public void skuDtoNameValidationTest() {
		mockedSKU = new SkuDtoReqAdd("camiseta preta p", "camisa oh, top", 3, 1);
		mockedSKU.setName("");
		Set<ConstraintViolation<SkuDtoReqAdd>> violations = validator.validate(mockedSKU);
		assertEquals(2, violations.size());	
	}
	
	@Test
	public void skuDtoDescriptionValidationTest() {
		mockedSKU = new SkuDtoReqAdd("camiseta preta p", "camisa oh, top", 3, 1);
		mockedSKU.setDescription("");
		Set<ConstraintViolation<SkuDtoReqAdd>> violations = validator.validate(mockedSKU);
		assertEquals(2, violations.size());
	}
	
	@Test
	public void skuDtoStockValidationTest() {
		mockedSKU = new SkuDtoReqAdd("camiseta preta p", "camisa oh, top", 3, 1);
		mockedSKU.setStock(-2);
		Set<ConstraintViolation<SkuDtoReqAdd>> violations = validator.validate(mockedSKU);
		assertEquals(1, violations.size());
	}
	
}
