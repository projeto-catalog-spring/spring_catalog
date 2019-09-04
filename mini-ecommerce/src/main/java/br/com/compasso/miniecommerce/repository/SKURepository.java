package br.com.compasso.miniecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.compasso.miniecommerce.models.Category;

public interface SKURepository extends JpaRepository<Category, Long> {

}
