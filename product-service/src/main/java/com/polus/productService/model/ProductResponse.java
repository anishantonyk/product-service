package com.polus.productService.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductResponse {
	
	private long productId;
	
	private String productName;
	
	private long quantity;
	
	private double price;	
}
