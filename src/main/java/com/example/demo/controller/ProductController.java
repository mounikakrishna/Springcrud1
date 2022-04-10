package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.repository.ProductRepo;
import com.example.demo.service.ProductService;

import model.Product;

@RestController
public class ProductController {
	
		  
	   @Autowired
	    private ProductService ps;
	   
	  
	    @PostMapping
	    public ResponseEntity<Product> saveProd(@RequestBody Product prod){
	 
	        return new ResponseEntity<Product>(ps.saveProd(prod), HttpStatus.CREATED);
	        
	    }
	    @GetMapping
	    public ResponseEntity<List<Product>> findAll()
	    {
	 
	         return new ResponseEntity<List<Product>>(ps.findAll(), HttpStatus.ACCEPTED);
	}
	    
	    @GetMapping("/{name}")
	    public ResponseEntity<Product> getProductByName(@PathVariable("name") String pname)
	    {
	            Product prod= ps.getProductByName(pname);
	            
	         return new ResponseEntity<>(prod, HttpStatus.OK);
	         
	       
	}
	    @PostMapping("/{name}")
	    public ResponseEntity<Product> updateProduct1(@PathVariable("name") String pname, @RequestBody Product prod)
	    {
	            Product updateprod = ps.updateProduct(pname ,prod);
	            
	         return new ResponseEntity<>(updateprod, HttpStatus.CREATED);
	    
}
	    
	    @PutMapping("/{name}")
	    public ResponseEntity<Product> updateProduct(@PathVariable("name") String pname, @RequestBody Product prod)
	    {
	            Product updateprod = ps.updateProduct(pname ,prod);
	            
	         return new ResponseEntity<>(updateprod, HttpStatus.CREATED);
	    }
	    @DeleteMapping("/{name}")
	    public ResponseEntity<String> deleteProduct(@PathVariable("name") String pname)
	    {
	            Product prod= ps.deleteProduct(pname);
	            
	         return new ResponseEntity<>("deleted",HttpStatus.OK);
	         }
}