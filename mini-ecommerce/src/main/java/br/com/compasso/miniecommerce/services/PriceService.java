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
import br.com.compasso.miniecommerce.models.dto.PriceDtoReq;
import br.com.compasso.miniecommerce.models.dto.PriceDtoRes;
import br.com.compasso.miniecommerce.repository.PriceRepository;

@Service
public class PriceService {

	@Autowired
	private PriceRepository repository;

	private ModelMapper mapper = new ModelMapper();

	public Page<PriceDtoRes> getAllPrices(Pageable pagination) {
		return PriceDtoRes.convert(repository.findAll(pagination));
	}

	@Transactional
	public ResponseEntity<PriceDtoRes> addPrice(Price price, UriComponentsBuilder uriBuilder) {
		Price p = repository.save(price);
		URI uri = uriBuilder.path("/" + p.getId()).buildAndExpand(p.getId()).toUri();
		return ResponseEntity.created(uri).body(this.mapper.map(p, PriceDtoRes.class));
	}

	public ResponseEntity<PriceDtoRes> getPrice(Long id, PriceDtoReq dto, UriComponentsBuilder uriBuilder) {
		Optional<Price> priceOptional = repository.findById(id);

		if (priceOptional.isPresent()) {
			Price p = repository.getOne(id);
			URI uri = uriBuilder.path("/{id}").buildAndExpand(id).toUri();

			return ResponseEntity.created(uri).body(this.mapper.map(p, PriceDtoRes.class));
		} else {
			System.out.println("invalid invalid invalid");
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@Transactional
	public ResponseEntity<PriceDtoRes> editPrice(Long id, PriceDtoReq dto, UriComponentsBuilder uriBuilder) {
		Optional<Price> priceOptional = repository.findById(id);

		if (priceOptional.isPresent()) {
			Price p = dto.update(id, repository);
			URI uri = uriBuilder.path("/{id}").buildAndExpand(id).toUri();
			return ResponseEntity.created(uri).body(this.mapper.map(p, PriceDtoRes.class));
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	public static Page<PriceDtoRes> convert(Page<Price> prices) {
		return prices.map(PriceDtoRes::new);
	}
}
