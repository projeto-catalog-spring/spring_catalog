package br.com.compasso.miniecommerce.ERP;

import java.util.List;

import br.com.compasso.miniecommerce.models.Price;
import br.com.compasso.miniecommerce.models.Product;
import br.com.compasso.miniecommerce.models.SKU;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
public class ERPDtoSend {
	
	@Getter @Setter private List<Product> products;
	@Getter @Setter private List<Price> prices;
	@Getter @Setter private List<SKU> skus;

}
