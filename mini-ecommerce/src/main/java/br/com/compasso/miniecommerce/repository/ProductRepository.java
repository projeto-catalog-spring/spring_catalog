package br.com.compasso.miniecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.compasso.miniecommerce.models.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

	@Query(value = "SELECT PRODUCT.ENABLED FROM PRODUCT JOIN SKU ON PRODUCT.ID = SKU.PRODUCT_ID WHERE PRODUCT.ID = ?1 AND SKU.ENABLED = TRUE AND SKU.STOCK > 0 ", nativeQuery = true)
	boolean isActive(Long id);

	@Query(value = "select count(s.*) from sku s where s.product_id = ? and s.enabled = true and s.stock > 0", nativeQuery = true)
	int findAllSkus(Long id);

	@Query(value = "select * from product p inner join price pr on pr.id=p.price_id where p.price_id = ?", nativeQuery = true)
	Product findProductByPrice(Long id);

}
