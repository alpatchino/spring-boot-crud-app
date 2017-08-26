package com.patrick.demo.repositories;

import com.patrick.demo.entity.Product;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository<Product, Integer>{
	
}
