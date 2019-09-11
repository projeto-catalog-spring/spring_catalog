package br.com.compasso.miniecommerce.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.compasso.miniecommerce.models.Brand;

public interface BrandRepository extends JpaRepository<Brand, Long> {
	
	public Optional<Brand> findByName(String name);

	//@Query("");
	

}