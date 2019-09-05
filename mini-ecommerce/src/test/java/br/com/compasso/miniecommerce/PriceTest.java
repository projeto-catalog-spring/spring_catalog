package br.com.compasso.miniecommerce;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import br.com.compasso.miniecommerce.models.Price;
import br.com.compasso.miniecommerce.models.Product;

@RunWith(MockitoJUnitRunner.class)
public class PriceTest {
	
	@Mock
	private Price mockedPrice;
	
	@InjectMocks
	private Product mockedProd;
	
	@Before
	public void setup() {
		mockedProd = mock(Product.class);
		mockedPrice = new Price(new Long(4), new Double(3), new Double(4), mockedProd);
	}
	
	@Test
    public void priceGetIdTest() {
        assertEquals(new Long(4), mockedPrice.getId());
    }
	
	@Test
	public void priceGetProductTest() {
		assertEquals(mockedProd, mockedPrice.getProduct());		
	}
	
}
