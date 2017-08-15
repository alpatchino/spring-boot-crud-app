package com.patrick.demo.services;


import com.patrick.demo.domain.Product;

public interface ProductService {
	
    Iterable<Product> listAllProducts();

    Product getProductById(Integer id);

    Product saveProduct(Product product);
}