package br.com.compasso.miniecommerce.models.dto;

import org.springframework.data.domain.Page;

import com.fasterxml.jackson.annotation.JsonProperty;

import br.com.compasso.miniecommerce.models.SKU;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class SkuDtoRes {
	
	@JsonProperty("Id")
	private Long id;

	@JsonProperty("Name")
	private String name;

	@JsonProperty("Description")
	private String description;

	@JsonProperty("Stock")
	private int stock;

	@JsonProperty("Name")
	private String productName;
	
	@JsonProperty("Enabled")
	private boolean enabled;

	public SkuDtoRes(SKU sku) {
		this.id = sku.getId();
		this.name = sku.getName();
		this.description = sku.getDescription();
		this.stock = sku.getStock();
		this.productName = sku.getProduct().getName();
		this.enabled = sku.isEnabled();
	}

	public static Page<SkuDtoRes> convert(Page<SKU> skus) {

		return skus.map(SkuDtoRes::new);
	}
}

//public static Page<TopicoDto> converter(Page<Topico> topicos) {
//return topicos.map(TopicoDto::new);
//}