package br.com.compasso.miniecommerce.services;

import java.net.URI;
import java.util.Optional;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.compasso.miniecommerce.models.Price;
import br.com.compasso.miniecommerce.models.Product;
import br.com.compasso.miniecommerce.models.dto.PriceDtoReq;
import br.com.compasso.miniecommerce.models.dto.PriceDtoRes;
import br.com.compasso.miniecommerce.repository.PriceRepository;
import br.com.compasso.miniecommerce.repository.ProductRepository;

@Service("PriceService")
public class PriceService {

	@Autowired
	private PriceRepository repository;

	@Autowired
	private ProductRepository productRepository;

	private ModelMapper mapper = new ModelMapper();

	@Transactional
	public Page<PriceDtoRes> getAllPrices(Pageable pagination) {
		return PriceDtoRes.convert(repository.findAll(pagination));
	}

	@Transactional
	public ResponseEntity<PriceDtoRes> addPrice(Price price, UriComponentsBuilder uriBuilder) {
		Price p = repository.save(price);
		URI uri = uriBuilder.path("/" + p.getId()).buildAndExpand(p.getId()).toUri();
		return ResponseEntity.created(uri).body(this.mapper.map(p, PriceDtoRes.class));
	}

	@Transactional
	public ResponseEntity<PriceDtoRes> getPrice(Long id) {
		if (repository.findById(id).isPresent()) {
			return ResponseEntity.ok(this.mapper.map(repository.getOne(id), PriceDtoRes.class));
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

	@Transactional
	public ResponseEntity<PriceDtoRes> editPrice(Long id, PriceDtoReq dto) {
		Optional<Price> priceOptional = repository.findById(id);

		if (priceOptional.isPresent()) {

			Price p = dto.update(id, repository);

			if (dto.getPrice() <= 0) {
				Product prod = productRepository.findProductByPrice(id);
				if (prod.isEnabled()) {
					prod.setEnabled(false);
				}
			}

			return ResponseEntity.ok(this.mapper.map(p, PriceDtoRes.class));
		} 

		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

	public static Page<PriceDtoRes> convert(Page<Price> prices) {
		return prices.map(PriceDtoRes::new);
	}
}
