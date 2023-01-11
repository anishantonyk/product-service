package com.polus.productService.service;

import com.polus.productService.model.ProductRequest;
import com.polus.productService.model.ProductResponse;

public interface ProductService {

	long addProduct(ProductRequest productRequest);

	ProductResponse getProductById(long productId);

	void reduceQuantity(long productId, long quantity);

}
