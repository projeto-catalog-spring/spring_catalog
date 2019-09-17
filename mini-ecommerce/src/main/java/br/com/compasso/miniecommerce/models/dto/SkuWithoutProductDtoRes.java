package br.com.compasso.miniecommerce.models.dto;

import org.springframework.data.domain.Page;

import com.fasterxml.jackson.annotation.JsonProperty;

import br.com.compasso.miniecommerce.models.Sku;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class SkuWithoutProductDtoRes {

	@JsonProperty("Id")
	private Long id;

	@JsonProperty("Name")
	private String name;

	@JsonProperty("Description")
	private String description;

	@JsonProperty("Stock")
	private int stock;
	
	@JsonProperty("Enabled")
	private boolean enabled;

	public SkuWithoutProductDtoRes(Sku sku) {
		this.id = sku.getId();
		this.name = sku.getName();
		this.description = sku.getDescription();
		this.stock = sku.getStock();
		this.enabled = sku.isEnabled();
	}

	public static Page<SkuWithoutProductDtoRes> convert(Page<Sku> skus) {
		return skus.map(SkuWithoutProductDtoRes::new);
	}

}