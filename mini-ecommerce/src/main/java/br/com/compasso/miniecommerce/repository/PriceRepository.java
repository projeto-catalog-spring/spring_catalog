package br.com.compasso.miniecommerce.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import br.com.compasso.miniecommerce.models.Price;

public interface PriceRepository extends JpaRepository<Price, Long> {
	Page<Price> findById(Long id, Pageable paginacao);
}