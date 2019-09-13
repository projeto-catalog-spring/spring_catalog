package br.com.compasso.miniecommerce.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.compasso.miniecommerce.models.Sku;

@Repository
public interface SkuRepository extends JpaRepository<Sku, Long> {
	
	Page<Sku> findAllByEnabled(boolean enable, Pageable pageable);
	
	Page<Sku> findByProductId(Long id, Pageable pageable);

}