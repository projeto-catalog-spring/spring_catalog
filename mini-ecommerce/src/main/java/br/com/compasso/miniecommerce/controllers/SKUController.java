package br.com.compasso.miniecommerce.controllers;

import java.net.URI;
import java.util.Optional;

import javax.transaction.Transactional;
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

import br.com.compasso.miniecommerce.models.Product;
import br.com.compasso.miniecommerce.models.SKU;
import br.com.compasso.miniecommerce.models.dto.SkuDtoReq;
import br.com.compasso.miniecommerce.models.dto.SkuDtoReqEdit;
import br.com.compasso.miniecommerce.models.dto.SkuDtoRes;
import br.com.compasso.miniecommerce.repository.ProductRepository;
import br.com.compasso.miniecommerce.repository.SKURepository;

@RestController
@RequestMapping("/api/sku")
public class SKUController {

	@Autowired
	private SKURepository skuRepository;

	@Autowired
	private ProductRepository productRepository;

//	@GetMapping("/")
//	public List<SkuDtoResAddList> listAll() {
//
//		ModelMapper mapper = new ModelMapper();
//
//		List<SKU> list = skuRepository.findAll();
//		return list.stream().map(sku_temp -> mapper.map(sku_temp, SkuDtoResAddList.class)).collect(Collectors.toList());
//	}

	@GetMapping
	public Page<SkuDtoRes> listAll(
			@PageableDefault(sort = "id", direction = Direction.ASC, page = 0, size = 1) Pageable pagination) {

		Page<SKU> skus = skuRepository.findAll(pagination);

		return SkuDtoRes.convert(skus);
	}

	@GetMapping("/{id}")
	public ResponseEntity<SkuDtoRes> getSku(@PathVariable Long id) {

		ModelMapper mapper = new ModelMapper();

		Optional<SKU> skuOp = skuRepository.findById(id);

		if (skuOp.isPresent()) {
			return ResponseEntity.ok(mapper.map(skuOp.get(), SkuDtoRes.class));
		}
		return ResponseEntity.notFound().build();

	}

	@PostMapping
	@Transactional
	public ResponseEntity<SkuDtoRes> add(@RequestBody @Valid SkuDtoReq dto, UriComponentsBuilder uriBuilder) {

		ModelMapper mapper = new ModelMapper();
		SKU sku = mapper.map(dto, SKU.class);

		Optional<Product> prod = productRepository.findById((long) dto.getProductId());

		if (prod.isPresent()) {
			sku.setProduct(prod.get());
			skuRepository.save(sku);
			URI uri = uriBuilder.path("/sku/{id}").buildAndExpand(sku.getId()).toUri();
			return ResponseEntity.created(uri).body(mapper.map(sku, SkuDtoRes.class));
		}
		return ResponseEntity.notFound().build();
	}

	@PutMapping("/{id}")
	@Transactional
	public ResponseEntity<SkuDtoRes> edit(@PathVariable Long id, @RequestBody @Valid SkuDtoReqEdit dto) {

		Optional<SKU> skuOp = skuRepository.findById(id);
		ModelMapper mapper = new ModelMapper();

		if (skuOp.isPresent()) {

			SKU sku = dto.update(id, skuRepository);
			return ResponseEntity.ok(mapper.map(sku, SkuDtoRes.class));
		}

		return ResponseEntity.notFound().build();
	}

}