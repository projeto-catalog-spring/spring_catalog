package br.com.compasso.miniecommerce.models.dto;

import org.springframework.data.domain.Page;

import com.fasterxml.jackson.annotation.JsonProperty;

import br.com.compasso.miniecommerce.models.Price;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class PriceDtoRes {

	@JsonProperty("Id")
	private Long id;

	@JsonProperty("Price")
	private double price;

	@JsonProperty("SalePrice")
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
