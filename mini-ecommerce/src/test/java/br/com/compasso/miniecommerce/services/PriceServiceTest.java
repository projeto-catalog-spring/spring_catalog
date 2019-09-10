package br.com.compasso.miniecommerce.services;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import br.com.compasso.miniecommerce.models.Category;
import br.com.compasso.miniecommerce.models.SKU;
import br.com.compasso.miniecommerce.repository.SKURepository;

@RunWith(MockitoJUnitRunner.class)
public class PriceServiceTest {
	
	@Mock
	private SKURepository mockedSKURepository;
	private SkuService mockedSkuService;
	private Page<SKU> pages;
	
	@InjectMocks
	private Category mockedCategory;
    private Pageable page;
     
    @Before
    public void setup() {
    	
    }
    
    @Test
    public void getAllSkusTest() {
    	when(mockedSKURepository.findAll(page)).thenReturn(pages);
    	when(pages.getSize()).thenReturn(3);
    	
      	assertEquals(3, mockedSkuService.getAllSkus(page).getSize());
    }
	
}
