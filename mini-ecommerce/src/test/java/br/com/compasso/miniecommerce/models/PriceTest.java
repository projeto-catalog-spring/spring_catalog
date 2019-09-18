package br.com.compasso.miniecommerce.models;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class PriceTest {

	@Mock
	private Price mockedPrice;

	@Before
	public void setup() {

	}

	@Test
	public void constructorTest() {

		mockedPrice = new Price(new Long(4), 2.45, 6.85);
		assertEquals(new Long(4), mockedPrice.getId());
		assertEquals("O preço está errado.", 2.45, mockedPrice.getPrice(), 0);
		assertEquals("O preço de venda está errado.", 6.85, mockedPrice.getSalePrice(), 0);

	}

	@Test
	public void priceGetIdTest() {
		when(mockedPrice.getId()).thenReturn(new Long(4));
		assertEquals(new Long(4), mockedPrice.getId());
	}

	@Test
	public void priceGetPriceTest() {
		when(mockedPrice.getPrice()).thenReturn(2.45);
		assertEquals("O preço está errado.", 2.45, mockedPrice.getPrice(), 0);
	}

	@Test
	public void priceGetSalePriceTest() {
		when(mockedPrice.getSalePrice()).thenReturn(6.85);
		assertEquals("O preço de venda está errado.", 6.85, mockedPrice.getSalePrice(), 0);
	}

}
