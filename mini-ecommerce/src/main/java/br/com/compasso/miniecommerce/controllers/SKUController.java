package br.com.compasso.miniecommerce.controllers;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.compasso.miniecommerce.models.SKU;
import br.com.compasso.miniecommerce.models.dto.SkuDtoReqAdd;

@RestController
@RequestMapping("/sku")
public class SKUController {

	private SKU sku;

	@GetMapping("/")
	public String helloSKU() {
		return "oi";
	}

	@PostMapping("/")
	public SKU addSku(@RequestBody @Valid SkuDtoReqAdd dto, UriComponentsBuilder uriBuilder) {

		ModelMapper mapper = new ModelMapper();
		sku = mapper.map(dto, SKU.class);
		// pegar a id do dto, achar o produto
		// salvo a sku

		return sku;
		// método não finalizado
	}

}