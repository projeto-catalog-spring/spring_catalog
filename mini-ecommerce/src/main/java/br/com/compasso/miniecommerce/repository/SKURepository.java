package br.com.compasso.miniecommerce.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.compasso.miniecommerce.models.SKU;

@Repository
public interface SKURepository extends JpaRepository<SKU, Long> {
	
	Page<SKU> findAllByEnabled(boolean enable, Pageable pageable);

//	boolean isEnabled(Long id);

//	@Query("SELECT u FROM User u WHERE u.status = 1")
//	ProductRepository findActiveProduct();

}
