package br.com.compasso.miniecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.compasso.miniecommerce.models.SKU;

@Repository
public interface SKURepository extends JpaRepository<SKU, Long> {
	
	//public boolean findByEnabled(Long id);
}
