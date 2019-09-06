package br.com.compasso.miniecommerce.models.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import br.com.compasso.miniecommerce.models.Price;
import br.com.compasso.miniecommerce.models.Product;
import lombok.Getter;
import lombok.Setter;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ERPDto {
	
	@Getter @Setter private List<Product> products;
	@Getter @Setter private List<Price> prices;
	//@Getter @Setter private List<SKU> skus;
}
