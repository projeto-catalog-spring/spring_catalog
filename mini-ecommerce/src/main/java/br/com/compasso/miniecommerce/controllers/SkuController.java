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

import br.com.compasso.miniecommerce.models.dto.SkuDtoReq;
import br.com.compasso.miniecommerce.models.dto.SkuDtoReqEdit;
import br.com.compasso.miniecommerce.models.dto.SkuDtoRes;
import br.com.compasso.miniecommerce.services.SkuService;

@RestController
@RequestMapping("/skus")
public class SkuController {

	@Autowired
	private SkuService service;

	@GetMapping
	public ResponseEntity<Page<SkuDtoRes>> getAllSkus(
			@PageableDefault(sort = "id", direction = Direction.ASC, page = 0, size = 10) Pageable pagination) {
		return service.getAllSkus(pagination);
	}

	@PostMapping
	public ResponseEntity<SkuDtoRes> addSku(@RequestBody @Valid SkuDtoReq dto, BindingResult result,
			UriComponentsBuilder uriBuilder) {
		if (result.hasErrors())
			return ResponseEntity.badRequest().build();

		return service.addSku(dto, uriBuilder);
	}

	@GetMapping("/{id}")
	public ResponseEntity<SkuDtoRes> getSku(@PathVariable Long id) {
		return service.getSku(id);
	}

	@PutMapping("/{id}")
	public ResponseEntity<SkuDtoRes> editSku(@PathVariable Long id, @RequestBody @Valid SkuDtoReqEdit dto,
			BindingResult result) {
		if (result.hasErrors())
			return ResponseEntity.badRequest().build();

		return service.editSku(id, dto);
	}

	@PutMapping("/{id}/{status}")
	public ResponseEntity<SkuDtoRes> removeSku(@PathVariable Long id, @PathVariable boolean status) {
		return service.removeSku(id, status);
	}

}