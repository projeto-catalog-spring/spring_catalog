package br.com.compasso.miniecommerce.config;

import org.modelmapper.Conditions;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import br.com.compasso.miniecommerce.models.Product;
import br.com.compasso.miniecommerce.models.dto.ProductDtoReq;

@Configuration
public class MapperConfigurations {

	@Bean
	public ModelMapper modelMapper() {
		ModelMapper modelMapper = new ModelMapper();
		modelMapper.getConfiguration().setSkipNullEnabled(true).setMatchingStrategy(MatchingStrategies.STRICT)
				.setPropertyCondition(Conditions.isNotNull());

		modelMapper.addMappings(productMap);

		return modelMapper;
	}

	private PropertyMap<ProductDtoReq, Product> productMap = new PropertyMap<ProductDtoReq, Product>() {
		protected void configure() {
			map().getPrice().setId(source.getPrice().getId());
		}
	};

}