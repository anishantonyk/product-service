package com.polus.productService.respository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.polus.productService.entity.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

}
