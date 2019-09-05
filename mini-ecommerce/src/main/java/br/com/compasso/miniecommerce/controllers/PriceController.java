package br.com.compasso.miniecommerce.controllers;

import java.net.URI;
import java.util.Optional;

import javax.transaction.Transactional;
import javax.validation.Valid;
import javax.validation.constraints.PositiveOrZero;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.compasso.miniecommerce.models.dto.PriceDtoRes;
import br.com.compasso.miniecommerce.models.dto.PriceDtoReq;
import br.com.compasso.miniecommerce.models.Price;
import br.com.compasso.miniecommerce.repository.PriceRepository;


@RestController
@RequestMapping("/prices")
public class PriceController {
	
	@Autowired
	private PriceRepository priceRepository;
	
	
	@SuppressWarnings("unchecked")
	@GetMapping
	@Cacheable(value = "listPrices")
	public Page<PriceDtoRes> list(@PageableDefault (sort = "id", direction = Direction.DESC, page = 0, size = 10) Pageable paginacao) {
			Page<Price> prices = priceRepository.findAll(paginacao);
			return PriceDtoRes.toConvert(prices);
	}
	
	@PostMapping
	@Transactional
	@CacheEvict(value = "listPrices", allEntries = true)
	public ResponseEntity<PriceDtoRes> add(@RequestBody @Valid PriceDtoReq priceDtoReq, UriComponentsBuilder uriBuilder) {
		ModelMapper mapper = new ModelMapper();
		Price price =  mapper.map(priceDtoReq, Price.class);
		priceRepository.save(price);
		
		URI uri = uriBuilder.path("/prices/{id}").buildAndExpand(price.getId()).toUri();
		return ResponseEntity.created(uri).body(new PriceDtoRes(price));
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<PriceDtoRes> findById(@PathVariable Long id) {
		Optional<Price> price = priceRepository.findById(id);
		if(price.isPresent()) {
			return ResponseEntity.ok(new PriceDtoRes(price.get()));
		}
		return ResponseEntity.notFound().build();
	}
	
	@PutMapping("/{id}")
	@Transactional
	@CacheEvict(value = "listPrices", allEntries = true)
	public ResponseEntity<PriceDtoRes> update(@PathVariable Long id, @RequestBody @Valid PriceDtoReq priceDtoReq) {
		Optional<Price> optional = priceRepository.findById(id);
		if (optional.isPresent()) {
			Price price = priceDtoReq.update(id, priceRepository);
			return ResponseEntity.ok(new PriceDtoRes(price));
		}
		
		return ResponseEntity.notFound().build();
	}
	
	
	/*
	 * @DeleteMapping("/{id}")
	 * 
	 * @Transactional
	 * 
	 * @CacheEvict(value = "listPrices", allEntries = true) public ResponseEntity<?>
	 * remove(@PathVariable Long id) { Price price = priceRepository.getOne(id); if
	 * (price != null) { price.update(id, priceRepository); return
	 * ResponseEntity.ok().build(); }
	 * 
	 * return ResponseEntity.notFound().build(); }
	 */
	 

}
