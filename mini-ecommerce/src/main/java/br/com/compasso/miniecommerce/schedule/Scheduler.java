package br.com.compasso.miniecommerce.schedule;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import br.com.compasso.miniecommerce.clients.ConsumerERP;
import br.com.compasso.miniecommerce.models.Price;
import br.com.compasso.miniecommerce.models.Product;
import br.com.compasso.miniecommerce.models.SKU;
import br.com.compasso.miniecommerce.models.helpers.HelperUpdate;
import br.com.compasso.miniecommerce.repository.BrandRepository;
import br.com.compasso.miniecommerce.repository.CategoryRepository;
import br.com.compasso.miniecommerce.repository.PriceRepository;
import br.com.compasso.miniecommerce.repository.ProductRepository;
import br.com.compasso.miniecommerce.repository.SKURepository;
import feign.Feign;
import feign.Logger;
import feign.gson.GsonDecoder;
import feign.gson.GsonEncoder;
import feign.okhttp.OkHttpClient;
import feign.slf4j.Slf4jLogger;

@Component
@Transactional
public class Scheduler {

	@Autowired
	private BrandRepository brandRepo;

	@Autowired
	private CategoryRepository categoryRepo;

	@Autowired
	private ProductRepository productRepo;

	@Autowired
	private PriceRepository priceRepo;

	@Autowired
	private SKURepository skuRepo;

	@Scheduled(cron = "0 0 0/1 * * *")
	public void jobSchedule() {

		ConsumerERP erp = Feign.builder().client(new OkHttpClient()).encoder(new GsonEncoder())
				.decoder(new GsonDecoder()).logger(new Slf4jLogger(ConsumerERP.class)).logLevel(Logger.Level.FULL)
				.target(ConsumerERP.class, "http://localhost:8080/ERP");

		for (Price price : erp.getData().getPrices()) {
			HelperUpdate.updatePrice(priceRepo, price);
		}

		for (Product product : erp.getData().getProducts()) {
			HelperUpdate.updateBrand(brandRepo, product.getBrand());
			HelperUpdate.updateCategory(categoryRepo, product.getCategory());
			HelperUpdate.updateProduct(productRepo, product);
		}

		for (SKU sku : erp.getData().getSkus()) {
			HelperUpdate.updateSKU(skuRepo, sku);
		}

	}
}
