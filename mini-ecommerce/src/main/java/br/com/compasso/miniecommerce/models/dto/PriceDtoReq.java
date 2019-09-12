package br.com.compasso.miniecommerce.models.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;

import br.com.compasso.miniecommerce.models.Price;
import br.com.compasso.miniecommerce.repository.PriceRepository;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class PriceDtoReq {

	@NotNull
	@PositiveOrZero
	private double price;

	@NotNull
	@PositiveOrZero
	private double salePrice;

	public PriceDtoReq(Price p) {
		this.price = p.getPrice();
		this.salePrice = p.getSalePrice();
	}

	public Price update(Long id, PriceRepository priceRepository) {
		Price p = priceRepository.getOne(id);

		if (this.price > 0) {
			p.setPrice(this.price);
		}
		
		if (this.salePrice > 0) {
			p.setSalePrice(this.salePrice);			
		}

		return p;
	}
}