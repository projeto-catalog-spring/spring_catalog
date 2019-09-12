package br.com.compasso.miniecommerce.controllers;

import java.net.URI;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
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
import br.com.compasso.miniecommerce.services.PriceService;

@RestController
@RequestMapping("/prices")
public class PriceController {

	@Autowired
	private PriceService priceService;

	@GetMapping
	public Page<PriceDtoRes> list(
			@PageableDefault(sort = "id", direction = Direction.ASC, page = 0, size = 10) Pageable pagination) {
		return priceService.getAllPrices(pagination);
	}

	@PostMapping
	@Transactional
	public ResponseEntity<PriceDtoRes> add(@RequestBody @Valid PriceDtoReq priceDtoReq,
			UriComponentsBuilder uriBuilder) {
		Price price = new ModelMapper().map(priceDtoReq, Price.class);
		priceService.addPrice(price);

		URI uri = uriBuilder.path("/{id}").buildAndExpand(price.getId()).toUri();
		return ResponseEntity.created(uri).body(new PriceDtoRes(price));
	}

	@GetMapping("/{id}")
	public ResponseEntity<PriceDtoRes> getPrice(@PathVariable Long id, @Valid PriceDtoReq dto, BindingResult result,
			UriComponentsBuilder uriBuilder) {

		if (result.hasErrors())
			return ResponseEntity.notFound().build();

		return priceService.getPrice(id, dto, uriBuilder);
	}

	@PutMapping("/{id}")
	@Transactional
	public ResponseEntity<PriceDtoRes> update(@PathVariable Long id, @RequestBody @Valid PriceDtoReq dto,
			BindingResult result, UriComponentsBuilder uriBuilder) {
		if (result.hasErrors()) {
			return ResponseEntity.notFound().build();
		}

		return priceService.editPrice(id, dto, uriBuilder);
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
