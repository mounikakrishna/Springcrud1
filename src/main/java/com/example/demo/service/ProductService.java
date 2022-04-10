package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repository.ProductRepo;

import model.Product;

@Service
public class ProductService {
	
	@Autowired
	private ProductRepo productrepo;
	  
	public Product saveProd(Product prod) {
		return productrepo.insert(prod);
	}
		
		public List<Product> findAll() {
			return productrepo.findAll();
		
		
	}

		public Product getProductByName(String name ) {
			return productrepo.findByName(name);
		}

		public Product updateProduct(String name, Product prod) {
			Product _prod = productrepo.findByName(name);
			
		
		
			_prod.setPrice(prod.getPrice());
			
			return  productrepo.save(_prod); 
			
			
				
		}
		
		public Product deleteProduct(String name) {
			
			return productrepo.deleteByName(name);
			
		}
			
			
			
	
		
		
		
}
