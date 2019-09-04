package br.com.compasso.miniecommerce.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor @AllArgsConstructor
public class Price {
 
    @Id @GeneratedValue
    @Getter private Long id; 
    @Getter @Setter private double price;
    @Getter @Setter private double salePrice;
    @Getter @Setter private Product product;
 }