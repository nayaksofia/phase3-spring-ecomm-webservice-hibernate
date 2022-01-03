package com.simplilearn.webservice.controller;

import static org.junit.jupiter.api.Assertions.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestClientException;

import com.simplilearn.webservice.entity.EProduct;



import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@SpringBootTest(webEnvironment=WebEnvironment.RANDOM_PORT)
@DisplayName("Test-Product Controller")
public class ProductControllerTest {

	@LocalServerPort
	private int port;
	
	@Autowired
	private TestRestTemplate restTemplate;
	
	@Test
	@DisplayName("Test :: Add Product ")
	public void testAddProduct() throws RestClientException, URISyntaxException {
		final String url = "http://localhost:" +port+ "/products";
		
		//step-1:: Instantiate or create a product object
		EProduct product = new EProduct(100 , "Lenovo Laptop XYZ Series", "It is a Laptop",20000.00);
		
		//step-2:: http entity object
		 HttpEntity<EProduct> requestObj = new HttpEntity<EProduct>(product);
		 
		//step-3::
		 ResponseEntity<EProduct> response = restTemplate.postForEntity(new URI(url), requestObj, EProduct.class);
		 
		 assertEquals(200, response.getStatusCodeValue());
		 assertEquals("Lenovo Laptop XYZ Series", response.getBody().getName());
		 assertEquals(20000.00, response.getBody().getPrice());
	}
   
	
	
	@Test
	@DisplayName("Test :: Add Product Null Value ")
	public void testAddProductForNull() throws RestClientException, URISyntaxException {
		final String url = "http://localhost:" +port+ "/products";
		
		//step-1:: Instantiate or create a product object
		EProduct product = null;
		
		//step-2:: http entity object ---> For Passing Product Data As Request Body. 
		 HttpEntity<EProduct> requestObj = new HttpEntity<EProduct>(product);
		 
		//step-3::
		 ResponseEntity<EProduct> response = restTemplate.postForEntity(new URI(url), requestObj, EProduct.class);
		 
		 assertEquals(415, response.getStatusCodeValue());
	}
	
	

	@Test
	@DisplayName("Test :: List All Product")
	public void testGetAllProducts() throws RestClientException, URISyntaxException {
		final String url = "http://localhost:" +port+ "/products";
		
		 ResponseEntity<List> response = restTemplate.getForEntity(new URI(url), List.class);
		 
		 assertEquals(200, response.getStatusCodeValue());
		 assertEquals(false, response.getBody().isEmpty());
	}
	
}
