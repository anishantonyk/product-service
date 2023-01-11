package com.polus.productService.model;

import lombok.Data;
import lombok.Getter;

@Data
public class ProductRequest {

	private String productName;
	
	private long quantity;
	
	private double price;	
}
