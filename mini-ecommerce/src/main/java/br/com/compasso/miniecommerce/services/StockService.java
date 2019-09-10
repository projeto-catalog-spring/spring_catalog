package br.com.compasso.miniecommerce.services;

import java.net.URI;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.compasso.miniecommerce.models.SKU;
import br.com.compasso.miniecommerce.models.dto.SkuDtoRes;
import br.com.compasso.miniecommerce.models.dto.StockDtoReq;
import br.com.compasso.miniecommerce.repository.SKURepository;

public class StockService {

	public ResponseEntity<SkuDtoRes> add(SKURepository skuRep, StockDtoReq stockReq, UriComponentsBuilder uriBuilder) {

		ModelMapper mapper = new ModelMapper();
		
		Optional<SKU> skuOptional = skuRep.findById(stockReq.getId());

		if (skuOptional.isPresent()) {
			SKU sku = skuOptional.get();
			sku.add(stockReq.getQtd());
			
			URI uri = uriBuilder.path("/stock/{id}").buildAndExpand(sku.getId()).toUri();
			return ResponseEntity.created(uri).body(mapper.map(sku, SkuDtoRes.class));
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	public ResponseEntity<SkuDtoRes> remove(SKURepository skuRep, StockDtoReq stockReq, UriComponentsBuilder uriBuilder) {
		
		ModelMapper mapper = new ModelMapper();
		
		Optional<SKU> skuOptional = skuRep.findById(stockReq.getId());

		if (skuOptional.isPresent()) {
			SKU sku = skuOptional.get();
			if (sku.getStock() < stockReq.getQtd())
				return new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
			else {
				sku.remove(stockReq.getQtd());
				URI uri = uriBuilder.path("/stock/{id}").buildAndExpand(sku.getId()).toUri();
				return ResponseEntity.created(uri).body(mapper.map(sku, SkuDtoRes.class));
			}
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

}
