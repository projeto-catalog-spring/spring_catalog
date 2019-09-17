package br.com.compasso.miniecommerce.schedule;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import br.com.compasso.miniecommerce.clients.ConsumerERP;
import br.com.compasso.miniecommerce.models.Price;
import br.com.compasso.miniecommerce.models.helpers.HelperUpdate;
import br.com.compasso.miniecommerce.repository.PriceRepository;
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
	private PriceRepository priceRepo;

	@Scheduled(cron = "0 0 0/1 * * *")
	public void jobSchedule() {
		System.out.println("teste");
		
		ConsumerERP erp = Feign.builder().client(new OkHttpClient()).encoder(new GsonEncoder())
				.decoder(new GsonDecoder()).logger(new Slf4jLogger(ConsumerERP.class)).logLevel(Logger.Level.FULL)
				.target(ConsumerERP.class, "http://localhost:8080/ERP");

		for (Price price : erp.getData().getPrices()) {
			HelperUpdate.updatePrice(priceRepo, price);
		}

	}
}
