package br.com.compasso.miniecommerce;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;

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
    
    @Before
    public void setup() {
    	mockedCategory = mock(Category.class);
    	mockedBrand = mock(Brand.class);
    	
    	mockedProduct = new Product(new Long(4), "Camiseta", "Camisa branca bem bonita", false, mockedCategory, mockedBrand);

//    	mockedProduct = mock(Product.class);
//    	when(mockedProduct.getId()).thenReturn(new Long(4));
//    	when(mockedProduct.getName()).thenReturn("Camiseta");
//      when(mockedProduct.getDescription()).thenReturn("Camisa branca bem bonita");
//      when(mockedProduct.getCategory()).thenReturn(mockedCategory);
//      when(mockedProduct.getBrand()).thenReturn(mockedBrand);
    	
    }
	
	@Test
	public void productGetIdTest() {
		assertEquals(new Long(4), mockedProduct.getId());
	}
	
	@Test
	public void productGetNameTest() {
		assertEquals("Camiseta", mockedProduct.getName());
	}
	
	@Test
	public void productGetDescriptionTest() {
		assertEquals("Camisa branca bem bonita", mockedProduct.getDescription());
	}
	
	@Test
	public void productGetCategoryTest() {
		assertEquals(mockedCategory, mockedProduct.getCategory());
	}
	
	@Test
	public void productGetBrandTest() {
		assertEquals(mockedBrand, mockedProduct.getBrand());
	}
	
}
