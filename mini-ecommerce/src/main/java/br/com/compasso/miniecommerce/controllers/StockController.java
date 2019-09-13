package br.com.compasso.miniecommerce.controllers;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.compasso.miniecommerce.models.SKU;
import br.com.compasso.miniecommerce.models.dto.SkuDtoRes;
import br.com.compasso.miniecommerce.models.dto.StockDtoReq;
import br.com.compasso.miniecommerce.models.dto.StockDtoRes;
import br.com.compasso.miniecommerce.repository.ProductRepository;
import br.com.compasso.miniecommerce.repository.SKURepository;
import br.com.compasso.miniecommerce.services.StockService;

@RestController
@RequestMapping("/stock")
public class StockController {

	@Autowired
	private SKURepository skuRep;
	
	@Autowired
	private StockService stockService;

	@Autowired
	private ProductRepository productRep;

	@GetMapping
	public ResponseEntity<Page<StockDtoRes>> stockLevel(
			@PageableDefault(sort = "id", direction = Direction.ASC, page = 0, size = 10) Pageable pageable) {

		Page<SKU> skus = skuRep.findAllByEnabled(true, pageable);

		return new ResponseEntity<>(StockDtoRes.convert(skus), HttpStatus.OK);
	}

	@PutMapping("/add")
	public ResponseEntity<SkuDtoRes> addStock(@Valid @RequestBody StockDtoReq stockReq, BindingResult result,
			UriComponentsBuilder uriBuilder) {

		if (result.hasErrors())
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

		return stockService.add(skuRep, stockReq, uriBuilder);
	}

	@PutMapping("/remove")
	public ResponseEntity<SkuDtoRes> removeStock(@Valid @RequestBody StockDtoReq stockReq, BindingResult result,
			UriComponentsBuilder uriBuilder) {

		if (result.hasErrors())
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

		StockService stockService = new StockService();
		return stockService.remove(skuRep, stockReq, uriBuilder);
	}
}