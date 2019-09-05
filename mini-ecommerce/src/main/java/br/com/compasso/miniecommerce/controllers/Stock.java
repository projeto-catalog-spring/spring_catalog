package br.com.compasso.miniecommerce.controllers;

import java.net.URI;
import java.util.Optional;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
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
import br.com.compasso.miniecommerce.models.dto.StockDtoReq;
import br.com.compasso.miniecommerce.models.dto.StockDtoRes;
import br.com.compasso.miniecommerce.repository.SKURepository;

@RestController
@RequestMapping("/stock")
public class Stock {

	@Autowired
	private SKURepository skuRep;

	@GetMapping
	public ResponseEntity<Page<StockDtoRes>> stockLevel(
			@PageableDefault(sort = "id", direction = Direction.DESC, page = 0, size = 10) Pageable pageable) {

		Page<SKU> skus = skuRep.findAllByEnable(true, pageable);
		
		return new ResponseEntity<>(StockDtoRes.convert(skus), HttpStatus.OK);
	}

	@PutMapping("/add")
	public ResponseEntity<SKU> addStock(@Valid @RequestBody StockDtoReq stockReq, BindingResult result, UriComponentsBuilder uriBuilder) {

		ModelMapper mapper = new ModelMapper();
		
		if (result.hasErrors())
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

		Optional<SKU> skuOptional = skuRep.findById(stockReq.getId());

		if (skuOptional.isPresent()) {
			SKU sku = skuOptional.get();
			sku.setStock(sku.getStock() + stockReq.getQtd());
			URI uri = uriBuilder.path("/stock/{id}").buildAndExpand(sku.getId()).toUri();
			return ResponseEntity.created(uri).body(sku);
			//body(mapper.map(sku, SkuDtoResAdd.class))
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

	}

	@PutMapping("/remove")
	public ResponseEntity<SKU> removeStock(@Valid @RequestBody StockDtoReq stockReq, BindingResult result, UriComponentsBuilder uriBuilder) {

		ModelMapper mapper = new ModelMapper();
		
		if (result.hasErrors())
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

		Optional<SKU> skuOptional = skuRep.findById(stockReq.getId());

		if (skuOptional.isPresent()) {
			SKU sku = skuOptional.get();
			if (sku.getStock() < stockReq.getQtd())
				return new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
			else {
				sku.setStock(sku.getStock() - stockReq.getQtd());
				URI uri = uriBuilder.path("/stock/{id}").buildAndExpand(sku.getId()).toUri();
				return ResponseEntity.created(uri).body(sku);
				//body(mapper.map(sku, SkuDtoResAdd.class))
			}
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
}