package br.com.compasso.miniecommerce.services;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import br.com.compasso.miniecommerce.models.Product;
import br.com.compasso.miniecommerce.models.dto.ProductDtoReq;
import br.com.compasso.miniecommerce.models.dto.ProductDtoRes;
import br.com.compasso.miniecommerce.repository.ProductRepository;

public class ProductServiceTest {

	@RunWith(MockitoJUnitRunner.class)
	public class ProductDtoTest {

		@Mock
		private ProductService prodServ;

		@InjectMocks
		private ProductRepository repository;
		private Product product;
		private ProductDtoReq productDtoReq;
		private ProductDtoRes productDtores;

		@Test(expected = IllegalArgumentException.class)
		public void addProduct() {
			when(prodServ.addProduct(productDtoReq, null)).thenReturn(null).thenThrow(new IllegalArgumentException());
			assertEquals(product, product);
		}

		@Test(expected = IllegalArgumentException.class)
		public void editProduct() {
			when(prodServ.editProduct(product.getId(), productDtoReq)).thenReturn(null)
					.thenThrow(new IllegalArgumentException());
			assertEquals(product, product);
		}

		@Test(expected = IllegalArgumentException.class)
		public void removeProduct() {
			when(prodServ.removeProduct(product.getId(), true)).thenReturn(null)
					.thenThrow(new IllegalArgumentException());
			assertEquals(productDtoReq, productDtores);
		}

	}
}
