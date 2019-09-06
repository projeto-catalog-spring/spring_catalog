package br.com.compasso.miniecommerce.models.dto;

import org.springframework.data.domain.Page;

import br.com.compasso.miniecommerce.models.SKU;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
public class SkuDtoRes {

	@Getter
	@Setter
	private Long id;

	@Getter
	@Setter
	private String name;

	@Getter
	@Setter
	private String description;

	@Getter
	@Setter
	private int stock;

	@Getter
	@Setter
	private String productName;

	@Getter
	@Setter
	private boolean enabled;

	public SkuDtoRes(SKU sku) {
		this.id = sku.getId();
		this.description = sku.getDescription();
		this.name = sku.getName();
		this.stock = sku.getStock();
		this.enabled = sku.isEnabled();
		this.productName = sku.getProduct().getName();
	}

	public static Page<SkuDtoRes> convert(Page<SKU> skus) {

		return skus.map(SkuDtoRes::new);
	}
}

//public static Page<TopicoDto> converter(Page<Topico> topicos) {
//return topicos.map(TopicoDto::new);
//}