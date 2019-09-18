package br.com.compasso.miniecommerce.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.compasso.miniecommerce.models.Sku;

@Repository
public interface SKURepository extends JpaRepository<SKU, Long> {
	
	Page<SKU> findAllByEnabled(boolean enable, Pageable pageable);
	
	@Query(value="select * from sku where product_id = ?1", nativeQuery = true)
	public List<SKU> findByProduct(long id);

	Page<Sku> findAllByEnabled(boolean enable, Pageable pageable);

	Page<Sku> findByProductId(Long id, Pageable pageable);

	@Query(value = "select * from sku where product_id = ?", nativeQuery = true)
	ArrayList<Sku> findSkusByProductId(Long id);

}