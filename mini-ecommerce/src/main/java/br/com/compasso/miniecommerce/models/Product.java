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
@Table(name="product")
public class Product {
		@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
		@Getter private Long id; 
	    @Getter @Setter private String name;
	    @Getter @Setter private String description;
	    @Getter @Setter private boolean enable;
	    @Getter @Setter @ManyToOne private Category category;
	    @Getter @Setter @ManyToOne private Brand brand;
	    //criar campo sku e setar relacionamento
	    //@Getter @Setter @oneToMany(MappedBy = "product <- nome do atributo na classe sku") private List<Sku> skus;
}