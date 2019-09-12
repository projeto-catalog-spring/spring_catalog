package br.com.compasso.miniecommerce.controllers;

import java.net.URI;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.compasso.miniecommerce.models.SKU;
import br.com.compasso.miniecommerce.models.dto.SkuDtoReq;
import br.com.compasso.miniecommerce.models.dto.SkuDtoReqEdit;
import br.com.compasso.miniecommerce.models.dto.SkuDtoRes;
import br.com.compasso.miniecommerce.services.SkuService;

@RestController
@RequestMapping("/sku")
public class SKUController {

	@Autowired
	private SkuService skuService;

	private ModelMapper mapper = new ModelMapper();

	@GetMapping
	public Page<SkuDtoRes> getAllSkus(
			@PageableDefault(sort = "id", direction = Direction.ASC, page = 0, size = 10) Pageable pagination) {
		return skuService.getAllSkus(pagination);
	}

	@PostMapping
	public ResponseEntity<SkuDtoRes> addSku(@RequestBody @Valid SkuDtoReq dto, UriComponentsBuilder uriBuilder) {
		SKU sku = this.mapper.map(dto, SKU.class);
		skuService.addSku(sku);

		URI uri = uriBuilder.path("/{id}").buildAndExpand(sku.getId()).toUri();
		return ResponseEntity.created(uri).body(new SkuDtoRes(sku));
	}

	@GetMapping("/{id}")
	public ResponseEntity<SkuDtoRes> getSku(@PathVariable Long id) {
		return ResponseEntity.ok(this.mapper.map(skuService.getSku(id), SkuDtoRes.class));
	}

	@PutMapping("/{id}")
	public ResponseEntity<SkuDtoRes> editSku(@PathVariable Long id, @RequestBody @Valid SkuDtoReqEdit dto) {
		SKU sku = skuService.editSku(id, dto);

		if (sku != null) {
			return ResponseEntity.ok(this.mapper.map(sku, SkuDtoRes.class));
		}

		return ResponseEntity.notFound().build();
	}

	@PutMapping("/{id}/{status}")
	public ResponseEntity<SkuDtoRes> removeSku(@PathVariable Long id, @PathVariable boolean status,
			@RequestBody @Valid SkuDtoReqEdit dto) {
		SKU sku = skuService.removeSku(id, status);

		if (sku != null) {
			return ResponseEntity.ok(this.mapper.map(sku, SkuDtoRes.class));
		}

		return ResponseEntity.notFound().build();
	}

}