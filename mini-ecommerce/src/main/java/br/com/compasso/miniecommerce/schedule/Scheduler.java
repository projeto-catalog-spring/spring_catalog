package br.com.compasso.miniecommerce.schedule;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import br.com.compasso.miniecommerce.models.Brand;
import br.com.compasso.miniecommerce.models.Category;
import br.com.compasso.miniecommerce.models.Price;
import br.com.compasso.miniecommerce.models.Product;
import br.com.compasso.miniecommerce.models.SKU;
import br.com.compasso.miniecommerce.models.dto.ERPDto;
import br.com.compasso.miniecommerce.repository.BrandRepository;
import br.com.compasso.miniecommerce.repository.CategoryRepository;
import br.com.compasso.miniecommerce.repository.PriceRepository;
import br.com.compasso.miniecommerce.repository.ProductRepository;
import br.com.compasso.miniecommerce.repository.SKURepository;

@Component
public class Scheduler {

	@Autowired
	private ProductRepository productRepo;

	@Autowired
	private PriceRepository priceRepo;

	@Autowired
	private CategoryRepository categoryRepo;

	@Autowired
	private BrandRepository brandRepo;
	
	@Autowired
	private SKURepository SKURepo;

	@Scheduled(cron = "0 0 0/1 * * *")
	public void jobSchedule() {

		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<ERPDto> response = restTemplate.getForEntity("http://localhost:8080/ERP", ERPDto.class);

		//persistir dados

	}

}
