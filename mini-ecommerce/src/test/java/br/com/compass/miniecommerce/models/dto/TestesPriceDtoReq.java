package br.com.compass.miniecommerce.models.dto;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import br.com.compasso.miniecommerce.models.Price;
import br.com.compasso.miniecommerce.models.dto.PriceDtoReq;

@RunWith(MockitoJUnitRunner.class)
public class TestesPriceDtoReq {
	Price price  = new Price(new Long(3), 3.15, 6.17);
	Price price2  = new Price(new Long(4), 3.19, 6.00);
	
	@Mock
	private PriceDtoReq mockedPriceDtoReq;
	
	@Before
    public void setup() {
		//price;
	}
    
	@Test
    public void constructorTest(){
	mockedPriceDtoReq = new PriceDtoReq(price);
	   assertEquals("O preço está errado.", 3.15, mockedPriceDtoReq.getPrice(), 0);
	   assertEquals("O preço de venda está errado.", 6.17, mockedPriceDtoReq.getSalePrice(), 0);
    }
	
	@Test
	public void priceDtoReqGetPriceTest() {
		when(mockedPriceDtoReq.getPrice()).thenReturn(3.15);
    	assertEquals("O preço está errado.", 3.15, mockedPriceDtoReq.getPrice(), 0);
	}
	
	@Test
	public void priceDtoReqGetSalePriceTest() {
		when(mockedPriceDtoReq.getSalePrice()).thenReturn(6.17);
    	assertEquals("O preço de venda está errado.", 6.17, mockedPriceDtoReq.getSalePrice(), 0);
	}
	
	/*
	 * @Test public void priceDtoReqUpdateTest() { when(mockedPriceDtoReq.update(new
	 * Long(3), priceRepository)).thenReturn(price);
	 * assertEquals("O preço está errado.", 3.19, mockedPriceDtoReq.getPrice(), 0);
	 * assertEquals("O preço de venda está errado.", 6.00,
	 * mockedPriceDtoReq.getSalePrice(), 0); }
	 */
}
