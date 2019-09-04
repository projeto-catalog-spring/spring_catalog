package br.com.compasso.miniecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.compasso.miniecommerce.models.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
