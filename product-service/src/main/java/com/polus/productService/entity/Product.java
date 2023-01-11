package com.polus.productService.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="_product")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Product {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	@Column(name = "product_id")
	private long productId;
		
	@Column(name = "Product_name")
	private String productName;
	
	@Column(name = "quantity_available")
	private long quantity;
	
	@Column(name = "price")
	private double price;	
}
