package br.com.compasso.miniecommerce.ERP;

import java.util.List;

import br.com.compasso.miniecommerce.models.Price;
import br.com.compasso.miniecommerce.models.Product;
import br.com.compasso.miniecommerce.models.SKU;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ERPDtoSend {

	private List<Product> products;
	private List<Price> prices;
	private List<SKU> skus;

}
