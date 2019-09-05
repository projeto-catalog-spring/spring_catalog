package br.com.compasso.miniecommerce;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import br.com.compasso.miniecommerce.models.Brand;

@RunWith(MockitoJUnitRunner.class)
public class BrandTest {
	
	@Mock
	private Brand mockedBrand;
	
	@Before
	public void setup() {
		mockedBrand = new Brand(new Long(4), "Nike");
	}
	
	@Test
	public void brandGetIdTest() {
		assertEquals(new Long(4), mockedBrand.getId());		
	}
	
	@Test
    public void brandGetNameTest() {
		assertEquals("Nike", mockedBrand.getName());
    }
	
}
