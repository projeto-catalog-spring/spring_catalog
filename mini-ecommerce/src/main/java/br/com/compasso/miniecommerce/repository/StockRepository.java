package br.com.compasso.miniecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.compasso.miniecommerce.models.Brand;

public interface StockRepository extends JpaRepository<Brand, Long> {

}