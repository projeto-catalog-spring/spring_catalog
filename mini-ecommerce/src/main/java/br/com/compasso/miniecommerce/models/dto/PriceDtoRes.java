package br.com.compasso.miniecommerce.models.dto;

import org.springframework.data.domain.Page;

import br.com.compasso.miniecommerce.models.Price;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
public class PriceDtoRes {

	@Getter
	@Setter
	private Long id;
	@Getter
	@Setter
	private double price;
	@Getter
	@Setter
	private double salePrice;

	public PriceDtoRes(Price p) {
		this.id = p.getId();
		this.price = p.getPrice();
		this.salePrice = p.getSalePrice();
	}

	public static Page<PriceDtoRes> convert(Page<Price> prices) {
		return prices.map(PriceDtoRes::new);
	}
}
