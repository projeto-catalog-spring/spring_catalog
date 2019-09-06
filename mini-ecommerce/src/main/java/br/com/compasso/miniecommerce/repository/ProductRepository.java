package br.com.compasso.miniecommerce.repository;

import java.util.Map;

import org.springframework.data.jpa.repository.JpaRepository;
import br.com.compasso.miniecommerce.models.Product;
import br.com.compasso.miniecommerce.models.dto.ProductReqDto;

public interface ProductRepository extends JpaRepository<Product, Long> {
	
}
