package br.com.compasso.miniecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.compasso.miniecommerce.models.SKU;

public interface SKURepository extends JpaRepository<SKU, Long> {

//	boolean isEnabled(Long id);

//	@Query("SELECT u FROM User u WHERE u.status = 1")
//	ProductRepository findActiveProduct();

}
