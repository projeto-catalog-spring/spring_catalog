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
		when(mockedPrice.getId()).thenReturn(new Long(4));
	}
	
	@Test
    public void priceGetIdTest() {
        assertEquals(new Long(4), mockedPrice.getId());
    }
	
}
