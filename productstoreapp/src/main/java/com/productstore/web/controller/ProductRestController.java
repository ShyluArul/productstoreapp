package com.productstore.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.productstore.exceptionhandler.ProductNotFoundEx;
import com.productstore.model.entities.Product;
import com.productstore.model.service.ProductService;
import com.productstore.web.request.DetailsResponse;

@RestController
@RequestMapping(path="/api")
public class ProductRestController {
	private ProductService productService;
	@Autowired
	public ProductRestController(ProductService productService) {
		super();
		this.productService = productService;
	}
	
	@GetMapping(path="/product", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Product>>getAllProducts(){
		return new  ResponseEntity<List<Product>>(productService.getAllProduct(),HttpStatus.OK);
	}
	
	@GetMapping(path="/product/{productId}",produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Product>getAnProduct(@PathVariable(name="id")Long productId){
		Product product=productService.findProductById(productId).orElseThrow(ProductNotFoundEx::new);
		return new ResponseEntity<Product>(product,HttpStatus.OK);
	
	}
	@DeleteMapping(path="/product/{productId}",produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Void>deleteAnProduct(@PathVariable(name="id")Long productId){
	productService.deleteProduct(productId);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}
	@PutMapping(path="product/{productId}",consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Product>updateAnProduct(@PathVariable(name="id")Long productId,@RequestBody Product product){
		return new ResponseEntity<Product>(productService.updateProduct(productId, product),HttpStatus.OK);
	}
		@PostMapping(path="product")
		public ResponseEntity<Product>addAnProduct(/*@Valid*/ @RequestBody Product product){
			return new ResponseEntity<Product>(productService.addProduct(product),HttpStatus.CREATED);
		}
		@GetMapping(path="products",produces=MediaType.APPLICATION_JSON_VALUE)
		public ResponseEntity<DetailsResponse> GetProductDetails(@RequestParam(name="id")Long productId){
			String productDetails = productService.getProductDetails(productId);
			System.out.println(productDetails);
		
			DetailsResponse res = new DetailsResponse(productDetails);
			return new ResponseEntity<DetailsResponse>(res,HttpStatus.OK);
		}
		

}
