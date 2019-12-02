package com.productstore.model.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.productstore.exceptionhandler.ProductNotFoundEx;
import com.productstore.model.entities.Product;
import com.productstore.model.repository.ProductRepo;

@Service
@Transactional
public class ProductServiceImpl implements ProductService {
@Autowired
private ProductRepo productRepo;

@Override
public List<Product> getAllProduct() {
	
	return productRepo.findAll();
}

@Override
public Optional<Product> findProductById(Long productId) {
	
	return productRepo.findById(productId);
	}

@Override
public void deleteProduct(Long productId) {
	productRepo.deleteById(productId);;
}

@Override
public Product addProduct(Product product) {
	return productRepo.save(product);
}

@Override
public Product updateProduct(Long productId, Product product) {
	Product productToBeUpdated=productRepo.findById(productId)
			.orElseThrow(ProductNotFoundEx::new);
	productToBeUpdated.setPrice(product.getPrice());
	return productRepo.save(productToBeUpdated);
	
	
}

@Override
public List<Product> findProductByNameLike(String name) {
	
	return productRepo.findProductByProductNameContaining(name);
}

@Override
public String getProductDetails(Long productId) {
	String details = productRepo.getProductDetails(productId);
	return details;

}

}
