package br.com.compasso.miniecommerce.controllers.dto;


import br.com.compasso.miniecommerce.models.Product;
import lombok.Getter;
import lombok.Setter;

public class PriceDto {
	
    @Getter private Long id; 
    @Getter @Setter private double price;
    @Getter @Setter private double salePrice;
    @Getter @Setter private Product product;
}
