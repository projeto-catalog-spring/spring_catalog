package br.com.compasso.miniecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.compasso.miniecommerce.models.Product;
import br.com.compasso.miniecommerce.models.dto.ProductDto;

public interface ProductRepository extends JpaRepository<Product, Long> {

	Product save(ProductDto products);

//	Product findOne(ProductDto id);

}
