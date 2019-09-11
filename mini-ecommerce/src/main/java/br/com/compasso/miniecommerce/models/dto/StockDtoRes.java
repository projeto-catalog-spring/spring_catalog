package br.com.compasso.miniecommerce.models.dto;

import org.springframework.data.domain.Page;

import br.com.compasso.miniecommerce.models.SKU;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public class StockDtoRes {
	
	@Getter private long id;
	@Getter private String name;
	@Getter private int stock;
	
	public StockDtoRes(SKU sku)
	{
		this.id = sku.getId();
		this.name = sku.getName();
		this.stock = sku.getStock();
	}
	
	public static Page<StockDtoRes> convert(Page<SKU> skuPage)
	{
		return skuPage.map(StockDtoRes::new);
	}
}
