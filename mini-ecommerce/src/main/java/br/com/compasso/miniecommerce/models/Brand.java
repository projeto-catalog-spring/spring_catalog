package br.com.compasso.miniecommerce.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Brand {
		@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
		@Getter private Long id; 
	    @Getter private String name;
}