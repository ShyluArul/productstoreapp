package com.productstore.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.productstore.exceptionhandler.ProductNotFoundEx;
import com.productstore.model.entities.Product;
import com.productstore.model.entities.Store;
import com.productstore.model.service.ProductService;
import com.productstore.model.service.StoreService;

@RestController
@RequestMapping(path = "/api")
public class StoreRestController {
	@Autowired 
	private StoreService storeService;
@Autowired 
	private ProductService productService;

	
	@GetMapping(path = "/store", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Store>> getAllStores() {
		return new ResponseEntity<List<Store>>(storeService.getAllStore(), HttpStatus.OK);
	}

	
	
	  
	  @GetMapping(path="stores/product/{productId}",produces=MediaType.
	  APPLICATION_JSON_VALUE) public
	  ResponseEntity<List<Store>>GetStores(@PathVariable(name="id")Long productId){
	 Product product = productService.findProductById(productId).orElseThrow(ProductNotFoundEx::new);
	  List<Store> storeList =product.getStore();
		
		for (Store store : storeList) {
			System.out.println(store);
			
		}
	//	response.setDetails(productDetails);
		return new ResponseEntity<List<Store>>(storeList,HttpStatus.OK);
	}

}

