package br.com.compasso.miniecommerce.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@NoArgsConstructor @AllArgsConstructor
public class Product {
		@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
		@Getter private Long id; 
	    @Getter @Setter private String nome;
	    @Getter @Setter private String description;
	    @Getter @Setter private boolean enable;
	    @Getter @Setter private Category category;
	    @Getter @Setter private Brand brand;
}