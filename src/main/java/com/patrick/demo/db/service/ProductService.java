package com.patrick.demo.db.service;

import com.patrick.demo.db.entity.Product;

public interface ProductService {
	
	Iterable<Product> listAllProducts();
	 
    Product getProductById(Integer id);
 
    Product saveProduct(Product product);

	void deleteProduct(Integer id);

}
