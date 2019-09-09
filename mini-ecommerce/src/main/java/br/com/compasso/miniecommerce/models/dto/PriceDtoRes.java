package br.com.compasso.miniecommerce.models.dto;

import org.springframework.data.domain.Page;

import br.com.compasso.miniecommerce.models.Price;
import br.com.compasso.miniecommerce.repository.PriceRepository;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
public class PriceDtoRes {
	
    @Getter private Long id; 
    @Getter @Setter private double price;
    @Getter @Setter private double salePrice;
    
    public PriceDtoRes(Price price2) {
    	  this.id = price2.getId(); 
    	  this.price = price2.getPrice();
    	  this.salePrice = price2.getSalePrice();
    }
    
    public static Page<PriceDtoRes> toConvert(Page<Price> prices) {
		return prices.map(PriceDtoRes::new);
	}
}
