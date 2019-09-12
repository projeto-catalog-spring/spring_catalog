package br.com.compasso.miniecommerce.models;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "product")
@Getter
@Setter
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JsonProperty("Id")
	private Long id;
	
	@JsonProperty("Name")
	private String name;
	
	@JsonProperty("Description")
	private String description;
	
	@JsonProperty("Enabled")
	private boolean enabled;
	
	@JsonProperty("Category")
	@ManyToOne
	private Category category;
	
	@JsonProperty("Brand")
	@ManyToOne
	private Brand brand;
	
	@JsonProperty("Price")
	@OneToOne(cascade = CascadeType.ALL, targetEntity=Price.class)
	private Price price;
	
}