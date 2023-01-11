package com.polus.productService.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.polus.productService.entity.Product;
import com.polus.productService.model.ProductRequest;
import com.polus.productService.model.ProductResponse;
import com.polus.productService.respository.ProductRepository;

import lombok.extern.log4j.Log4j2;

@Service
@Log4j2
public class ProductServiceImpl implements ProductService {

	@Autowired
	ProductRepository productRepository;
	
	@Override
	public long addProduct(ProductRequest productRequest) {
		 log.info("Adding Product..");

	        Product product
	                = Product.builder()
	                .productName(productRequest.getProductName())
	                .quantity(productRequest.getQuantity())
	                .price(productRequest.getPrice())
	                .build();

	        productRepository.save(product);

	        log.info("Product Created");
	        return product.getProductId();
		
	}

	@Override
	public ProductResponse getProductById(long productId) {
		log.info("Get the product for productId: {}", productId);

        Product product
                = productRepository.findById(productId)
                .orElseThrow(
                        () -> new RuntimeException("Product with given id not found"));

        ProductResponse productResponse
                = new ProductResponse();
        
        productResponse.setProductId(product.getProductId());
        productResponse.setProductName(product.getProductName());
        productResponse.setPrice(product.getPrice());
        productResponse.setQuantity(product.getQuantity());
        
        return productResponse;
	}

	@Override
	public void reduceQuantity(long productId, long quantity) {
		
		log.info("Reduce Quantity {} for Id: {}", quantity,productId);

        Product product
                = productRepository.findById(productId)
                .orElseThrow(() -> new RuntimeException(
                        "Product with given Id not found"
                        
                ));

        if(product.getQuantity() < quantity) {
            throw new RuntimeException(
                    "Product does not have sufficient Quantity"
                    
            );
        }

        product.setQuantity(product.getQuantity() - quantity);
        productRepository.save(product);
        log.info("Product Quantity updated Successfully");
		
	}

}
