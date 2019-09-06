package br.com.compasso.miniecommerce.models;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import br.com.compasso.miniecommerce.models.Brand;

@RunWith(MockitoJUnitRunner.class)
public class CategoryTest {
		
	@Mock
	private Brand mockedBrand;
	
	@Before
	public void setup() {
	}
	
	@Test
	public void brandConstructorTest() {
		mockedBrand = new Brand(new Long(4), "Masculino");
		assertEquals(new Long(4), mockedBrand.getId());
		assertEquals("Masculino", mockedBrand.getName());
	}
	
	@Test
    public void brandGetIdTest() {
		when(mockedBrand.getId()).thenReturn(new Long(4));
		assertEquals(new Long(4), mockedBrand.getId());	
	}
	
	@Test
	public void brandGetNameTest() {
		when(mockedBrand.getName()).thenReturn("Masculino");
		assertEquals("Masculino", mockedBrand.getName());		
	}
	
}
