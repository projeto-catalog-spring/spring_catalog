package br.com.compasso.miniecommerce.services;

import java.net.URI;
import java.util.Optional;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.compasso.miniecommerce.models.Product;
import br.com.compasso.miniecommerce.models.Sku;
import br.com.compasso.miniecommerce.models.dto.SkuDtoReq;
import br.com.compasso.miniecommerce.models.dto.SkuDtoReqEdit;
import br.com.compasso.miniecommerce.models.dto.SkuDtoRes;
import br.com.compasso.miniecommerce.repository.ProductRepository;
import br.com.compasso.miniecommerce.repository.SkuRepository;

@Service
public class SkuService {

	@Autowired
	private SkuRepository repository;

	@Autowired
	private ProductRepository productRepository;

	@Autowired
	private ModelMapper mapper = new ModelMapper();

	@Transactional
	public ResponseEntity<Page<SkuDtoRes>> getAllSkus(Pageable pagination) {
		return new ResponseEntity<>(SkuDtoRes.convert(repository.findAll(pagination)), HttpStatus.OK);
	}

	@Transactional
	public ResponseEntity<SkuDtoRes> addSku(SkuDtoReq dto, UriComponentsBuilder uriBuilder) {
		Sku sku = repository.save(this.mapper.map(dto, Sku.class));

		URI uri = uriBuilder.path("/" + sku.getId()).buildAndExpand(sku.getId()).toUri();
		return ResponseEntity.created(uri).body(this.mapper.map(sku, SkuDtoRes.class));
	}

	@Transactional
	public ResponseEntity<SkuDtoRes> getSku(Long id) {
		Optional<Sku> sku = repository.findById(id);

		if (sku.isPresent()) {
			return ResponseEntity.ok(this.mapper.map(sku.get(), SkuDtoRes.class));
		}

		return ResponseEntity.notFound().build();
	}

	@Transactional
	public ResponseEntity<SkuDtoRes> editSku(Long id, SkuDtoReqEdit dto) {
		Optional<Sku> skuOp = repository.findById(id);

		if (skuOp.isPresent()) {
			Sku sku = dto.update(id, repository);

			int quantidadeSkusValidas = productRepository.findAllSkus(id);

			if (quantidadeSkusValidas <= 0) {
				Product prod = productRepository.getOne(skuOp.get().getProduct().getId());
				prod.setEnabled(false);
				productRepository.save(prod);
			}

			return ResponseEntity.ok(this.mapper.map(repository.save(sku), SkuDtoRes.class));
		}

		return ResponseEntity.notFound().build();
	}

	@Transactional
	public Sku removeSku(Long id, boolean status) {
		Optional<Sku> skuOp = repository.findById(id);

		if (skuOp.isPresent()) {
			skuOp.get().setEnabled(status);

			Product product = productRepository.getOne(skuOp.get().getProduct().getId());

			int numeroDeSkusAtivas = productRepository.findAllSkus(product.getId());

			if (numeroDeSkusAtivas == 0) {
				product.setEnabled(false);
			}

			return skuOp.get();
		}

		return null;
	}

	public static Page<SkuDtoRes> convert(Page<Sku> skus) {
		return skus.map(SkuDtoRes::new);
	}

}
