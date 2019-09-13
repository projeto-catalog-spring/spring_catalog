package br.com.compasso.miniecommerce.models;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import br.com.compasso.miniecommerce.models.Product;
import br.com.compasso.miniecommerce.models.Sku;

@RunWith(MockitoJUnitRunner.class)
public class SKUTest {
	
	@Mock
	private Sku mockedSKU;
	
	@InjectMocks
	private Product mockedProduct;
	
	@Before
	public void setup() {
		
	}
	
	@Test
	public void skuConstructorTest() {
		mockedSKU = new Sku(new Long(4), "camisapretap", "camisa preta de tamanho p que cabe muito bem em voce", 3, true, mockedProduct);
		assertEquals(new Long(4), mockedSKU.getId());
		assertEquals("camisapretap", mockedSKU.getName());
        assertEquals("camisa preta de tamanho p que cabe muito bem em voce", mockedSKU.getDescription());
        assertEquals(3, mockedSKU.getStock());
        assertEquals(true, mockedSKU.isEnabled());
        assertEquals(mockedProduct, mockedSKU.getProduct());
	}
	
	@Test
    public void skuGetIdTest() {
		when(mockedSKU.getId()).thenReturn(new Long(4));
        assertEquals(new Long(4), mockedSKU.getId());
    }
	
	@Test
	public void skuGetNameTest() {
		when(mockedSKU.getName()).thenReturn("camisapretap");
		assertEquals("camisapretap", mockedSKU.getName());
	}
	
	@Test
    public void skuGetDescriptionTest() {
		when(mockedSKU.getDescription()).thenReturn("camisa preta de tamanho p que cabe muito bem em voce");
        assertEquals("camisa preta de tamanho p que cabe muito bem em voce", mockedSKU.getDescription());
    }
	
	@Test
    public void skuGetStockTest() {
		when(mockedSKU.getStock()).thenReturn(3);
        assertEquals(3, mockedSKU.getStock());
    }
	
	@Test
    public void skuGetEnableTest() {
		when(mockedSKU.isEnabled()).thenReturn(true);
        assertEquals(true, mockedSKU.isEnabled());
    }
	
	@Test
    public void skuGetProductTest() {
		when(mockedSKU.getProduct()).thenReturn(mockedProduct);
        assertEquals(mockedProduct, mockedSKU.getProduct());
    }
	
}
