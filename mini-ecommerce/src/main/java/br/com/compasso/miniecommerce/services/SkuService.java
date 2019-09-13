package br.com.compasso.miniecommerce.services;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.com.compasso.miniecommerce.models.Product;
import br.com.compasso.miniecommerce.models.SKU;
import br.com.compasso.miniecommerce.models.dto.SkuDtoReqEdit;
import br.com.compasso.miniecommerce.models.dto.SkuDtoRes;
import br.com.compasso.miniecommerce.repository.ProductRepository;
import br.com.compasso.miniecommerce.repository.SKURepository;

@Service
public class SkuService {

	@Autowired
	private SKURepository repository;

	@Autowired
	private ProductRepository productRepository;

	@Transactional
	public Page<SkuDtoRes> getAllSkus(Pageable pagination) {
		Page<SKU> skus = repository.findAll(pagination);
		return SkuDtoRes.convert(skus);
	}

	@Transactional
	public SKU addSku(SKU sku) {
		Optional<Product> product = productRepository.findById(sku.getProduct().getId());

		if (product.isPresent()) {
			sku.setProduct(product.get());
		}

		return repository.save(sku);
	}

	@Transactional
	public SKU getSku(Long id) {
		Optional<SKU> skuOp = repository.findById(id);

		if (skuOp.isPresent()) {
			return skuOp.get();
		}

		return null;
	}

	@Transactional
	public SKU editSku(Long id, SkuDtoReqEdit dto) {
		Optional<SKU> skuOp = repository.findById(id);

		if (skuOp.isPresent()) {
			int quantidadeSkusValidas = productRepository.findAllSkus(id);

			if (quantidadeSkusValidas <= 0) {
				Product prod = productRepository.getOne(skuOp.get().getProduct().getId());
				prod.setEnabled(false);
				productRepository.save(prod);
			}

			return dto.update(id, repository);
		}

		return null;
	}

	@Transactional
	public SKU removeSku(Long id, boolean status) {
		Optional<SKU> skuOp = repository.findById(id);

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

	public static Page<SkuDtoRes> convert(Page<SKU> skus) {
		return skus.map(SkuDtoRes::new);
	}

}
