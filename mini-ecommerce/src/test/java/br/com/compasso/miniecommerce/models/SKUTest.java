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
import br.com.compasso.miniecommerce.models.SKU;

@RunWith(MockitoJUnitRunner.class)
public class SKUTest {
	
	@Mock
	private SKU mockedSKU;
	
	@InjectMocks
	private Product mockedProduct;
	
	@Before
	public void setup() {	
		when(mockedSKU.getId()).thenReturn(new Long(4));
		when(mockedSKU.getName()).thenReturn("camisapretap");
		when(mockedSKU.getDescription()).thenReturn("camisa preta de tamanho p que cabe muito bem em voce");
		when(mockedSKU.getStock()).thenReturn(3);
		when(mockedSKU.isEnable()).thenReturn(true);
		when(mockedSKU.getProduct()).thenReturn(mockedProduct);
	}
	
	@Test
    public void skuGetIdTest() {
        assertEquals(new Long(4), mockedSKU.getId());
    }
	
	@Test
	public void skuGetNameTest() {
		assertEquals("camisapretap", mockedSKU.getName());
	}
	
	@Test
    public void skuGetDescriptionTest() {
        assertEquals("camisa preta de tamanho p que cabe muito bem em voce", mockedSKU.getDescription());
    }
	
	@Test
    public void skuGetStockTest() {
        assertEquals(3, mockedSKU.getStock());
    }
	
	@Test
    public void skuGetEnableTest() {
        assertEquals(true, mockedSKU.isEnable());
    }
	
	@Test
    public void skuGetProductTest() {
        assertEquals(mockedProduct, mockedSKU.getProduct());
    }
	
}
