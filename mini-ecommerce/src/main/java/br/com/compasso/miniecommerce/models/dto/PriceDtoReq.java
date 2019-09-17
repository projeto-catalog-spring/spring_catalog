package br.com.compasso.miniecommerce.models.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;

import br.com.compasso.miniecommerce.models.Price;
import br.com.compasso.miniecommerce.repository.PriceRepository;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
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

		p.setPrice(this.price);
		p.setSalePrice(this.salePrice);

		return p;
	}
}