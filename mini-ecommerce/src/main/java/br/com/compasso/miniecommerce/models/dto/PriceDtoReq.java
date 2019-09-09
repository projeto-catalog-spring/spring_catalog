package br.com.compasso.miniecommerce.models.dto;


import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.PositiveOrZero;

import br.com.compasso.miniecommerce.models.Price;
import br.com.compasso.miniecommerce.repository.PriceRepository;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
public class PriceDtoReq {
	 
    @Getter @Setter @NotNull @Positive
    private double price;
    @Getter @Setter @NotNull @Positive
    private double salePrice;
    
    public PriceDtoReq(Price price2) { 
    	  this.price = price2.getPrice();
    	  this.salePrice = price2.getSalePrice();
    }
    
    public Price update(Long id, PriceRepository priceRepository) {
		Price price = priceRepository.getOne(id);
		
		price.setPrice(this.price);
		price.setSalePrice(this.salePrice);
		
		return price;
	}
}