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
public class Brand {
		@Id @Generated
		@Getter private Long id; 
	    @Getter @Setter private String nome;
}