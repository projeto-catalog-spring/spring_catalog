package br.com.compasso.miniecommerce.models.dto;

import org.springframework.data.domain.Page;

import com.fasterxml.jackson.annotation.JsonProperty;

import br.com.compasso.miniecommerce.models.SKU;
import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class StockDtoRes {

	@JsonProperty("Id")
	private long id;

	@JsonProperty("Name")
	private String name;

	@JsonProperty("Stock")
	private int stock;

	public StockDtoRes(SKU sku) {
		this.id = sku.getId();
		this.name = sku.getName();
		this.stock = sku.getStock();
	}

	public static Page<StockDtoRes> convert(Page<SKU> skuPage) {
		return skuPage.map(StockDtoRes::new);
	}
}
