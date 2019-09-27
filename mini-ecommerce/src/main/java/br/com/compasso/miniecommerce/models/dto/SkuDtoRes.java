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
public class SkuDtoRes {

	@JsonProperty("Id")
	private Long id;

	@JsonProperty("ProductId")
	private Long productId;

	@JsonProperty("Name")
	private String name;

	@JsonProperty("Description")
	private String description;

	@JsonProperty("Stock")
	private int stock;

	@JsonProperty("ProductName")
	private String productName;

	@JsonProperty("Enabled")
	private boolean enabled;

	public SkuDtoRes(Sku sku) {
		this.id = sku.getId();
		this.name = sku.getName();
		this.description = sku.getDescription();
		this.stock = sku.getStock();
		this.productName = sku.getProduct().getName();
		this.enabled = sku.isEnabled();
		this.productId = sku.getProduct().getId();
	}

	public static Page<SkuDtoRes> convert(Page<Sku> skus) {
		return skus.map(SkuDtoRes::new);
	}

}