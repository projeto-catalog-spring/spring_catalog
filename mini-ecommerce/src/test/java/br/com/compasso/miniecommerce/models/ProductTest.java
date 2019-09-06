package br.com.compasso.miniecommerce.models;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import br.com.compasso.miniecommerce.models.Brand;
import br.com.compasso.miniecommerce.models.Category;
import br.com.compasso.miniecommerce.models.Product;

@RunWith(MockitoJUnitRunner.class)
public class ProductTest {
	
	@Mock
	private Product mockedProduct;
	
	@InjectMocks
	private Category mockedCategory;
    private Brand mockedBrand;
    private Price mockedPrice;
    
    @Before
    public void setup() {
    	
    }
    
    @Test
    public void productConstructorTest() {
    	mockedProduct = new Product(new Long(4), "Camiseta", "Camisa branca bem bonita", false, mockedCategory, mockedBrand, mockedPrice);
    	assertEquals(new Long(4), mockedProduct.getId());
    	assertEquals("Camiseta", mockedProduct.getName());
    	assertEquals("Camisa branca bem bonita", mockedProduct.getDescription());
    	assertEquals(mockedCategory, mockedProduct.getCategory());
		assertEquals(mockedBrand, mockedProduct.getBrand());
		assertEquals(mockedPrice, mockedProduct.getPrice());
    }
	
	@Test
	public void productGetIdTest() {
		when(mockedProduct.getId()).thenReturn(new Long(4));
    	assertEquals(new Long(4), mockedProduct.getId());
	}
	
	@Test
	public void productGetNameTest() {
		when(mockedProduct.getName()).thenReturn("Camiseta");
    	assertEquals("Camiseta", mockedProduct.getName());
	}
	
	@Test
	public void productGetDescriptionTest() {
		when(mockedProduct.getDescription()).thenReturn("Camisa branca bem bonita");
    	assertEquals("Camisa branca bem bonita", mockedProduct.getDescription());
	}
	
	@Test
	public void productGetCategoryTest() {
		when(mockedProduct.getCategory()).thenReturn(mockedCategory);
    	assertEquals(mockedCategory, mockedProduct.getCategory());
	}
	
	@Test
	public void productGetBrandTest() {
		when(mockedProduct.getBrand()).thenReturn(mockedBrand);
		assertEquals(mockedBrand, mockedProduct.getBrand());
	}
	
	@Test
	public void productGetPriceTest() {
		when(mockedProduct.getPrice()).thenReturn(mockedPrice);
		assertEquals(mockedPrice, mockedProduct.getPrice());
	}
	
}
