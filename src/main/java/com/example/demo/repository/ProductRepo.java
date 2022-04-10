package com.example.demo.repository;
import org.springframework.data.mongodb.repository.MongoRepository;


import model.Product;

public interface ProductRepo extends MongoRepository<Product, String>
{

	Product findByName(String name);

	Product deleteByName(String name);

	
    

}
