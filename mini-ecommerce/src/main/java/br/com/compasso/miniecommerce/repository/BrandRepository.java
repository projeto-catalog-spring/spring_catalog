package br.com.compasso.miniecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.compasso.miniecommerce.models.Brand;

public interface BrandRepository extends JpaRepository<Brand, Long> {

}