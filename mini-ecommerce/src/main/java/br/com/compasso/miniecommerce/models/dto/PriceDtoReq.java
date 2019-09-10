package br.com.compasso.miniecommerce.models.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;

import br.com.compasso.miniecommerce.models.Price;
import br.com.compasso.miniecommerce.repository.PriceRepository;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
public class PriceDtoReq {
	 
    @Getter @Setter @NotNull @PositiveOrZero
    private double price;
    @Getter @Setter @NotNull @PositiveOrZero
    private double salePrice;
    
    public PriceDtoReq(Price price2) { 
    	  this.price = price2.getPrice();
    	  this.salePrice = price2.getSalePrice();
    }
    
    public Price update(Long id, PriceRepository priceRepository) {
		
		priceRepository.getOne(id).setPrice(this.price);
		priceRepository.getOne(id).setSalePrice(this.salePrice);
		
		return priceRepository.getOne(id);
	}
}