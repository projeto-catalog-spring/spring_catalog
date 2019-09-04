package br.com.compasso.miniecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.compasso.miniecommerce.models.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {

}
