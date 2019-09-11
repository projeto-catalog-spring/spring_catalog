package br.com.compasso.miniecommerce.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.compasso.miniecommerce.models.Brand;

@Repository
public interface BrandRepository extends JpaRepository<Brand, Long> {

	public Optional<Brand> findByName(String name);
	
}