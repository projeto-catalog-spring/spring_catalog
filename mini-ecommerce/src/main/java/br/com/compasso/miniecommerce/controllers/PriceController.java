package br.com.compasso.miniecommerce.controllers;

import javax.validation.Valid;

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

import br.com.compasso.miniecommerce.models.dto.PriceDtoReq;
import br.com.compasso.miniecommerce.models.dto.PriceDtoRes;
import br.com.compasso.miniecommerce.services.PriceService;

@RestController
@RequestMapping("/prices")
public class PriceController {

	@Autowired
	private PriceService service;

	@GetMapping
	public ResponseEntity<Page<PriceDtoRes>> getAllPrices(
			@PageableDefault(sort = "id", direction = Direction.ASC, page = 0, size = 10) Pageable pagination) {
		return service.getAllPrices(pagination);
	}

	@PostMapping
	public ResponseEntity<PriceDtoRes> addPrice(@RequestBody @Valid PriceDtoReq dto, BindingResult result,
			UriComponentsBuilder uriBuilder) {
		if (result.hasErrors())
			return ResponseEntity.badRequest().build();

		return service.addPrice(dto, uriBuilder);
	}

	@GetMapping("/{id}")
	public ResponseEntity<PriceDtoRes> getPrice(@PathVariable Long id) {
		return service.getPrice(id);
	}

	@PutMapping("/{id}")
	public ResponseEntity<PriceDtoRes> editPrice(@PathVariable Long id, @RequestBody @Valid PriceDtoReq dto,
			BindingResult result) {
		if (result.hasErrors()) {
			return ResponseEntity.notFound().build();
		}

		return service.editPrice(id, dto);
	}

}
