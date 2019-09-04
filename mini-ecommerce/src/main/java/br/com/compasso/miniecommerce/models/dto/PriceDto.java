package br.com.compasso.miniecommerce.models.dto;

import br.com.compasso.miniecommerce.models.Price;
import br.com.compasso.miniecommerce.repository.PriceRepository;

import lombok.Getter;
import lombok.Setter;

public class PriceDto {
	
    @Getter private Long id; 
    @Getter @Setter private double price;
    @Getter @Setter private double salePrice;
    @Getter @Setter private Long idProduct;
    
    public PriceDto(Price price2) {
    	  this.id = price2.getId(); 
    	  this.price = price2.getPrice();
    	  this.salePrice = price2.getSalePrice();
    	  this.idProduct = price2.getProduct().getId();  
    }
    
    public Price update(Long id, PriceRepository priceRepository) {
		Price price = priceRepository.getOne(id);
		
		price.setPrice(this.price);
		price.setSalePrice(this.salePrice);
		price.setSalePrice(this.getIdProduct());
		
		return price;
	}
}
