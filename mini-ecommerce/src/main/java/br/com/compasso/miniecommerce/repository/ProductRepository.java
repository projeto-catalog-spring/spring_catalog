package br.com.compasso.miniecommerce.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.compasso.miniecommerce.models.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

	@Query(value = "SELECT PRODUCT.ENABLED FROM PRODUCT JOIN SKU ON PRODUCT.ID = SKU.PRODUCT_ID WHERE PRODUCT.ID = ?1 AND SKU.ENABLED = TRUE AND SKU.STOCK > 0 ", nativeQuery = true)
	boolean isActive(Long id);

	@Query(value = "SELECT * FROM SKU S JOIN PRODUCT P ON P.ID = S.PRODUCT_ID WHERE S.PRODUCT_ID = ?", nativeQuery = true)
	Page<Product> findAllSkusPaginated(Long id, Pageable page);

	@Query(value = "select count(s.*) from sku s where s.product_id = ? and s.enabled = true and s.stock > 0", nativeQuery = true)
	int findAllSkus(Long id);

}
