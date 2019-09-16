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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.compasso.miniecommerce.models.Sku;
import br.com.compasso.miniecommerce.models.dto.SkuDtoRes;
import br.com.compasso.miniecommerce.models.dto.StockDtoReq;
import br.com.compasso.miniecommerce.models.dto.StockDtoRes;
import br.com.compasso.miniecommerce.repository.SkuRepository;
import br.com.compasso.miniecommerce.services.StockService;

@RestController
@RequestMapping("/stock")
public class StockController {

	@Autowired
	private SkuRepository skuRep;

	@Autowired
	private StockService stockService;

	@GetMapping
	public ResponseEntity<Page<StockDtoRes>> stockLevel(
			@PageableDefault(sort = "id", direction = Direction.ASC, page = 0, size = 10) Pageable pageable) {
		Page<Sku> skus = skuRep.findAllByEnabled(true, pageable);

		return ResponseEntity.ok(StockDtoRes.convert(skus));
	}

	@PutMapping("/add")
	public ResponseEntity<SkuDtoRes> addStock(@Valid @RequestBody StockDtoReq stockReq, BindingResult result) {
		if (result.hasErrors()) {
			return ResponseEntity.badRequest().build();
		}

		return stockService.add(skuRep, stockReq);
	}

	@PutMapping("/remove")
	public ResponseEntity<SkuDtoRes> removeStock(@Valid @RequestBody StockDtoReq stockReq, BindingResult result) {
		if (result.hasErrors())
			return ResponseEntity.badRequest().build();

		return stockService.remove(skuRep, stockReq);
	}
}