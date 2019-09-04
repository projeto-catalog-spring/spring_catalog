package br.com.compasso.miniecommerce.models;

import lombok.AllArgsConstructor;
import lombok.Generated;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@NoArgsConstructor @AllArgsConstructor
public class Product {
		@Id @Generated
		@Getter private Long id; 
	    @Getter @Setter private String nome;
	    @Getter @Setter private String description;
	    @Getter @Setter private boolean enable;
	    @Getter @Setter private Long idCategory;
	    @Getter @Setter private Long idBrand;
	    @Getter @Setter private Long idPrice;
}