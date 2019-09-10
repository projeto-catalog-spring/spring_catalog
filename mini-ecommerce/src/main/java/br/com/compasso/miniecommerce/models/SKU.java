package br.com.compasso.miniecommerce.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "sku")
public class SKU {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Getter
	private Long id;

	@Getter
	@Setter
	private String name;

	@Getter
	@Setter
	private String description;

	@Getter
	@Setter
	private int stock;

	@Getter
	@Setter
	private boolean enabled;

	@Getter
	@Setter
	@ManyToOne
	private Product product;
	
	public void add(int qtd){
		stock += qtd;
	}
	
	public void remove(int qtd) {
		stock -= qtd;
	}

}
