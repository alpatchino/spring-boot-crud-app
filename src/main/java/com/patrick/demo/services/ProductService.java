package com.patrick.demo.services;


import com.patrick.demo.entity.Product;

public interface ProductService {
	
    Iterable<Product> listAllProducts();

    Product getProductById(Integer id);

    Product saveProduct(Product product);
}