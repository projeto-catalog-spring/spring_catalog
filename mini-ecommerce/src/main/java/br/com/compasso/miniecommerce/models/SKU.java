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
@Getter
public class SKU {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Setter
	private String name;

	@Setter
	private String description;

	@Setter
	private int stock;

	@Setter
	private boolean enabled;

	@ManyToOne
	@Setter
	private Product product;

	public void add(int qtd) {
		stock += qtd;
	}

	public void remove(int qtd) {
		stock -= qtd;
	}

	@Override
	public String toString() {
		return "SKU [id=" + id + ", name=" + name + ", description=" + description + ", stock=" + stock + ", enabled="
				+ enabled + ", product=" + product + "]";
	}

}
