package br.com.compasso.miniecommerce.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.compasso.miniecommerce.exceptions.PriceNotFoundException;
import br.com.compasso.miniecommerce.models.Price;
import br.com.compasso.miniecommerce.models.dto.PriceDto;
import br.com.compasso.miniecommerce.repository.PriceRepository;
import br.com.compasso.miniecommerce.repository.ProductRepository;

@Service
public class PriceService {
	
	@Autowired
	public ProductRepository prodRep;
	public PriceRepository priceRep;
	public org.modelmapper.ModelMapper modelMapper;

	public List<Price> listAll() {
		return priceRep.findAll();
	}

	public Optional<Price> getPrice(Long id) throws PriceNotFoundException {
		try {
			priceRep.findById(id);
		} catch (PriceNotFoundException e) {
			throw new PriceNotFoundException("Preço não encontrado para o id informado.");
		}
		
		return priceRep.findById(id);
	}

	public void addPrice(PriceDto dto) throws IllegalArgumentException {
		try {
			priceRep.save(converterPrice(dto));
		} catch (IllegalArgumentException e) {
			throw new IllegalArgumentException();
		}
	}

	private Price converterPrice(PriceDto dto) {
		return modelMapper.map(dto, Price.class);
	}
}
