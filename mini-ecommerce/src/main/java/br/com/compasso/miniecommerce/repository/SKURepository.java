package br.com.compasso.miniecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.compasso.miniecommerce.models.SKU;

public interface SKURepository extends JpaRepository<SKU, Long> {

	boolean isEnabled(Long id);
}
