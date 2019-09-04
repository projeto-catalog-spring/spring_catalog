package br.com.compasso.miniecommerce.controllers;

import java.net.URI;
import java.util.Optional;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.compasso.miniecommerce.models.dto.PriceDto;
import br.com.compasso.miniecommerce.models.Price;
import br.com.compasso.miniecommerce.repository.PriceRepository;


@RestController
@RequestMapping("/prices")
public class PriceController {
	
	@Autowired
	private PriceRepository priceRepository;
	
	
	@SuppressWarnings("unchecked")
	@GetMapping
	@Cacheable(value = "listPrices")
	public Page<PriceDto> list(@RequestParam(required = false) Long id, 
			@PageableDefault(sort = "id", direction = Direction.DESC, page = 0, size = 10) Pageable paginacao) {
		
		if (id == null) {
			ModelMapper modelMapper = new ModelMapper();
			PriceDto pricesDto = modelMapper.map(priceRepository.findAll(paginacao), PriceDto.class);
			return (Page<PriceDto>) pricesDto;
		} else {
			ModelMapper modelMapper = new ModelMapper();
			PriceDto pricesDto = modelMapper.map(priceRepository.findById(id, paginacao), PriceDto.class);
			return (Page<PriceDto>) pricesDto;
		}
	}
	
	@PostMapping
	@Transactional
	@CacheEvict(value = "listPrices", allEntries = true)
	public ResponseEntity<PriceDto> add(@RequestBody @Valid PriceDto priceDto, UriComponentsBuilder uriBuilder) {
		ModelMapper mapper = new ModelMapper();
		Price price =  mapper.map(priceDto, Price.class);
		priceRepository.save(price);
		
		URI uri = uriBuilder.path("/prices/{price}").buildAndExpand(price).toUri();
		return ResponseEntity.created(uri).body(new PriceDto(price));
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<PriceDto> findById(@PathVariable Long id) {
		Optional<Price> price = priceRepository.findById(id);
		if(price.isPresent()) {
			return ResponseEntity.ok(new PriceDto(price.get()));
		}
		return ResponseEntity.notFound().build();
	}
	
	@PutMapping("/{id}")
	@Transactional
	@CacheEvict(value = "listPrices", allEntries = true)
	public ResponseEntity<PriceDto> update(@PathVariable Long id, @RequestBody @Valid PriceDto priceDto) {
		Optional<Price> optional = priceRepository.findById(id);
		if (optional.isPresent()) {
			Price price = priceDto.update(id, priceRepository);
			return ResponseEntity.ok(new PriceDto(price));
		}
		
		return ResponseEntity.notFound().build();
	}
	
	@DeleteMapping("/{id}")
	@Transactional
	@CacheEvict(value = "listPrices", allEntries = true)
	public ResponseEntity<?> remove(@PathVariable Long id) {
		Optional<Price> optional = priceRepository.findById(id);
		if (optional.isPresent()) {
			priceRepository.deleteById(id);
			return ResponseEntity.ok().build();
		}
		
		return ResponseEntity.notFound().build();
	}

}
