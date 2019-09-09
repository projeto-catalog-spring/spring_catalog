package br.com.compasso.miniecommerce.repository;


import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import br.com.compasso.miniecommerce.models.Product;



public interface ProductRepository extends JpaRepository<Product, Long> {
	
	Page<Product> findById(Long id, Pageable paginacao);

	Page<Product> findAll(Pageable pag);

	void saveAll(Object dtoToProduct);


	
}
