package br.com.compasso.miniecommerce.models.helpers;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import br.com.compasso.miniecommerce.models.Product;
import br.com.compasso.miniecommerce.models.SKU;
import br.com.compasso.miniecommerce.repository.ProductRepository;
import br.com.compasso.miniecommerce.repository.SKURepository;

@Transactional
public class HelperProduct {
	
	private static ProductRepository productRepo;
	
	private HelperProduct() {}
	
	public static void productValidation(SKURepository skuRepo, long product_id)
	{
		List<SKU> skus = skuRepo.findByProduct(product_id);
		
		boolean skuOk = false; 
		for (SKU sku : skus) {
			if( sku.isEnabled() && sku.getStock() >= 0) {
				skuOk = true;
			}
		}
		
		boolean priceOk = false;
		Optional<Product> productOp = productRepo.findById(product_id);
		if(productOp.isPresent()) {
			Product p = productOp.get();
			
			if(p.getPrice().getPrice() > 0 && p.getPrice().getSalePrice() > 0) {
				priceOk = true;			
			}
			
			if(skuOk && priceOk) {
				p.setEnabled(true);
			} else {
				p.setEnabled(false);
			}
		}
	}

}
