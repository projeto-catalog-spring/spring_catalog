package br.com.compasso.miniecommerce.services;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import br.com.compasso.miniecommerce.models.Product;
import br.com.compasso.miniecommerce.models.SKU;
import br.com.compasso.miniecommerce.models.dto.SkuDtoReqEdit;
import br.com.compasso.miniecommerce.models.dto.SkuDtoRes;
import br.com.compasso.miniecommerce.services.SkuService;

@RunWith(MockitoJUnitRunner.class)
public class SkuServiceTest {
	@Mock
	private SkuService mockedskuService;

	@Autowired
	private Pageable paginable;

	@Test
	public void testListAllMethod() {

		Page<SkuDtoRes> skus = Mockito.mock(Page.class);

		when(mockedskuService.getAllSkus(paginable)).thenReturn(skus);
		assertEquals(skus, mockedskuService.getAllSkus(paginable));

	}

	@Test
	public void testAddSkuMethod() {
		Product product = new Product((long) 50, "produto", "descrição", true, null, null, null);
		SKU sku = new SKU((long) 50, "nomeSku", "descrição", 50, true, product);
		SKU sku2 = new SKU((long) 51, "nomeSku", "descrição", 50, true, product);

		when(mockedskuService.addSku(sku)).thenReturn(sku);
		assertEquals(sku, mockedskuService.addSku(sku));
		assertNotEquals(sku, mockedskuService.addSku(sku2));

	}

	@Test
	public void testGetSkuMethod() {

		SKU sku = Mockito.mock(SKU.class);

		when(mockedskuService.getSku((long) 50)).thenReturn(sku);
		assertEquals(sku, mockedskuService.getSku((long) 50));
		assertNotEquals(sku, mockedskuService.getSku((long) 51));

	}

	@Test
	public void testEditSkuMethod() {

		SkuDtoReqEdit dto = new SkuDtoReqEdit("nome", "descrição", 56, true);
		SkuDtoReqEdit dto2 = new SkuDtoReqEdit("nome", "descrição", 56, true);
		SKU sku = Mockito.mock(SKU.class);

		when(mockedskuService.editSku((long) 1, dto)).thenReturn(sku);
		assertEquals(sku, mockedskuService.editSku((long) 1, dto));
		assertNotEquals(sku, mockedskuService.editSku((long) 2, dto));
		assertNotEquals(sku, mockedskuService.editSku((long) 2, dto2));
	}

	@Test
	public void testConvertMethod() {

		Page<SKU> skus = Mockito.mock(Page.class);
		Page<SkuDtoRes> skusRes = Mockito.mock(Page.class);

		when(mockedskuService.convert(skus)).thenReturn(skusRes);
		assertEquals(skusRes, mockedskuService.convert(skus));
		assertNotEquals(skus, mockedskuService.convert(skus));
	}
}
