package br.com.compasso.miniecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.compasso.miniecommerce.models.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

	@Query(value="SELECT PRODUCT.ENABLED FROM PRODUCT JOIN SKU ON PRODUCT.ID = SKU.PRODUCT_ID WHERE PRODUCT.ID = ?1 AND SKU.ENABLED = TRUE AND SKU.STOCK > 0 ", nativeQuery = true)
	boolean isActive(Long id);
	
	

}
