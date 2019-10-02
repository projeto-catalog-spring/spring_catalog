package br.com.compasso.miniecommerce.services;

import java.util.Optional;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.com.compasso.miniecommerce.models.Product;
import br.com.compasso.miniecommerce.models.Sku;
import br.com.compasso.miniecommerce.models.dto.SkuDtoRes;
import br.com.compasso.miniecommerce.models.dto.StockDtoReq;
import br.com.compasso.miniecommerce.repository.ProductRepository;
import br.com.compasso.miniecommerce.repository.SkuRepository;

@Service
public class StockService {

	@Autowired
	private ModelMapper mapper = new ModelMapper();

	@Autowired
	private ProductRepository productRepository;

	@Transactional
	public ResponseEntity<SkuDtoRes> add(SkuRepository skuRep, StockDtoReq stockReq) {

		Optional<Sku> skuOptional = skuRep.findById(stockReq.getId());

		if (skuOptional.isPresent()) {
			Sku sku = skuOptional.get();
			sku.add(stockReq.getQtd());

			return ResponseEntity.ok(this.mapper.map(new SkuDtoRes(sku)));
		}

		return ResponseEntity.notFound().build();
	}

	@Transactional
	public ResponseEntity<SkuDtoRes> remove(SkuRepository skuRep, StockDtoReq stockReq) {

		Optional<Sku> skuOptional = skuRep.findById(stockReq.getId());

		if (skuOptional.isPresent()) {
			Sku sku = skuOptional.get();
			if (sku.getStock() < stockReq.getQtd())
				return new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
			else {
				sku.remove(stockReq.getQtd());

				int quantidadeSkusValidas = productRepository.findAllSkus(sku.getId());

				if (quantidadeSkusValidas <= 0) {
					Product prod = productRepository.getOne(sku.getProduct().getId());
					prod.setEnabled(false);
					productRepository.save(prod);
				}

				return ResponseEntity.ok(this.mapper.map(new SkuDtoRes(sku));
			}
		} else {
			return ResponseEntity.notFound().build();
		}
	}

}
