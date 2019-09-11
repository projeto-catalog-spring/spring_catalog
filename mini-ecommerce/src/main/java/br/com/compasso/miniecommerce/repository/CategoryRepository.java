package br.com.compasso.miniecommerce.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.compasso.miniecommerce.models.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
	
	public Optional<Category> findByName(String name);

}
