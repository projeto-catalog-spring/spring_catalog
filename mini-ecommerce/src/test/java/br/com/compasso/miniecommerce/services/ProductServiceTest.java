package br.com.compasso.miniecommerce.services;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.compasso.miniecommerce.models.Product;
import br.com.compasso.miniecommerce.models.dto.ProductDtoReq;
import br.com.compasso.miniecommerce.repository.ProductRepository;
import br.com.compasso.miniecommerce.services.ProductService;

public class ProductServiceTest {

	@RunWith(MockitoJUnitRunner.class)
	public class ProductDtoTest {

		@Mock
		private ProductService prodServ;

		@InjectMocks
		private ProductRepository repository;
		private Product product;
		private ProductDtoReq productDTO;
		private ProductDtoReq productDTOres;
		private UriComponentsBuilder uri;

		@Test(expected = IllegalArgumentException.class)
		public void addProduct() {
			when(prodServ.addProduct(product)).thenReturn(null).thenThrow(new IllegalArgumentException());
			assertEquals(product, product);
		}

		@Test(expected = IllegalArgumentException.class)
		public void editProduct() {
			when(prodServ.editProduct(product.getId(), productDTO, uri)).thenReturn(null)
					.thenThrow(new IllegalArgumentException());
			assertEquals(product, product);
		}

		@Test(expected = IllegalArgumentException.class)
		public void removeProduct() {
			when(prodServ.removeProduct(product.getId(), true, uri)).thenReturn(null)
					.thenThrow(new IllegalArgumentException());
			assertEquals(productDTOres, productDTOres);
		}

	}
}
