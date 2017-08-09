package com.patrick.demo.db.repository;

import org.springframework.data.repository.CrudRepository;

import com.patrick.demo.db.entity.Product;

public interface ProductRepository extends CrudRepository<Product, Integer>{

}
