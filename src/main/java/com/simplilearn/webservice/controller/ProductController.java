package com.simplilearn.webservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.simplilearn.webservice.entity.EProduct;
import com.simplilearn.webservice.exception.InvalidProductException;
import com.simplilearn.webservice.exception.ProductNotFoundException;
import com.simplilearn.webservice.repository.ProductRepository;

@RestController
public class ProductController {
	
	//Inject dependency
	@Autowired 
	private ProductRepository productRepository;
	
	//GET All Product
	@GetMapping("/products")
	public List<EProduct>getAllProduct(){
		return this.productRepository.findAll();
	}
	
	//Get One Product By Id
	@GetMapping("/products/{id}")
	public EProduct getProductById(@PathVariable("id")long productId) {
		return this.productRepository.findById(productId).orElseThrow(()->{
			throw new ProductNotFoundException("Product Not Found With Id " + productId);
		});	
	}
	
	
	// Add A Product
	@PostMapping("/products")
	public EProduct addProduct(@RequestBody EProduct product) {
		
		return this.productRepository.save(product);
	}
    
	//Update product
	@PutMapping("/products/{id}")
	public EProduct updateProduct(@RequestBody EProduct product) {
		
		//1. find product
		EProduct fetchedProduct = this.productRepository.findById(product.getId()).orElseThrow(()->{
			throw new InvalidProductException("Invalid Product Value! " + product.getId());
		});
		
		//2. set new values
		fetchedProduct.setName(product.getName());
		fetchedProduct.setPrice(product.getPrice());
		fetchedProduct.setDescription(product.getDescription());
		
		//3. save product
		return this.productRepository.save(fetchedProduct);
	}
	
	//Delete Product
	@DeleteMapping("/products/{id}")
	public void deleteProduct(@PathVariable(value="id") long productId) {
		
		//1. find product
		EProduct fetchedProduct = this.productRepository.findById(productId).orElseThrow(()->{
			throw new ProductNotFoundException("Product Not Found With Id " + productId);
		});
		
		//2. delete product
		this.productRepository.delete(fetchedProduct);
		
	}
}
