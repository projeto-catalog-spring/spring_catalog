package br.com.compasso.miniecommerce.models;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import br.com.compasso.miniecommerce.models.Price;

@RunWith(MockitoJUnitRunner.class)
public class PriceTest {
	
	@Mock
	private Price mockedPrice;
	
	@Before
	public void setup() {
	}
	
	@Test
	public void priceConstructorTest() {
		mockedPrice = new Price(new Long(4), 3.2, 3.8);
		assertEquals(new Long(4), mockedPrice.getId());
	}
	
	@Test
    public void priceGetIdTest() {
		when(mockedPrice.getId()).thenReturn(new Long(4));
        assertEquals(new Long(4), mockedPrice.getId());
    }
	
}
