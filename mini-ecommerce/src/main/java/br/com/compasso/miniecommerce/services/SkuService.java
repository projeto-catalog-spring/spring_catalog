package br.com.compasso.miniecommerce.services;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import br.com.compasso.miniecommerce.models.SKU;
import br.com.compasso.miniecommerce.models.dto.SkuDtoReqEdit;
import br.com.compasso.miniecommerce.models.dto.SkuDtoRes;
import br.com.compasso.miniecommerce.repository.SKURepository;

public class SkuService {

	public Page<SkuDtoRes> getAllSkus(Pageable pagination, SKURepository repository) {

		Page<SKU> skus = repository.findAll(pagination);

		return SkuDtoRes.convert(skus);
	}

	@Transactional
	public SKU addSku(SKU newSku, SKURepository repository) {

		return repository.save(newSku);

	}

	public SKU getSku(Long id, SKURepository repository) {

		Optional<SKU> skuOp = repository.findById(id);

		if (skuOp.isPresent())
			return skuOp.get();

		return null;
	}

	public SKU editSku(Long id, SkuDtoReqEdit dto, SKURepository repository) {

		Optional<SKU> skuOp = repository.findById(id);

		if (skuOp.isPresent()) {
			return dto.update(id, repository);
		}
		return null;
	}
}
