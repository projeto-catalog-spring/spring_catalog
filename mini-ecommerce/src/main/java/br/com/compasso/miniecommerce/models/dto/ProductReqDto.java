package br.com.compasso.miniecommerce.models.dto;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import com.fasterxml.jackson.annotation.JsonAlias;

import br.com.compasso.miniecommerce.models.Brand;
import br.com.compasso.miniecommerce.models.Category;
import br.com.compasso.miniecommerce.models.Price;
import br.com.compasso.miniecommerce.models.Product;
import br.com.compasso.miniecommerce.repository.BrandRepository;
import br.com.compasso.miniecommerce.repository.CategoryRepository;
import br.com.compasso.miniecommerce.repository.ProductRepository;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Data
public class ProductReqDto {
	@Autowired
    ModelMapper modelMapper = new ModelMapper();
	@Autowired
	public CategoryRepository catrep;
	@Autowired
	public BrandRepository brandrep;
			
	@JsonAlias({"name", "Name"})
	private String name;
	
	@JsonAlias({"description", "Description"})
	private String description;
	
	@JsonAlias({"enabled", "Enabled"})
	private boolean enabled;
	
	@JsonAlias({"category", "Category"})
	private Category category;
	
	@JsonAlias({"brand", "Brand"})
	private Brand brand;
	
	@JsonAlias({"price", "Price"})
	private Price price;
	
	public Product dtoToProduct(ProductReqDto productDTO) {
		Product entproduct = modelMapper.map(productDTO, Product.class);
		return entproduct;
	}
	
	@Transactional
	public Product update(Long id, ProductRepository productrep) {
		Product product = productrep.getOne(id);
		
		product.setName(this.name);
		product.setDescription(this.description);
		product.setEnabled(this.enabled);
		product.setBrand(this.brand);
		//catrep.setName(this.category.getId());
		//brandrep.setName(this.brand.getId());
		
		
		return product;

	}
	/*
	public void setNamecategory(Product product) {
		long id = product.getCategory().getId();
		Optional<Category> cat = catrep.findById(id);
	
		if(cat.isPresent()) {
			category.setName(cat.get().getName());
		}
	}
	
	public void setNamebrand(Product product) {
		long id = product.getCategory().getId();
		Optional<Brand> brandid = brandrep.findById(id);
	
		if(brandid.isPresent()) {
			brand.setName(brandid.get().getName());
		}
	}
	*/

	
		
}