package com.productstore.model.service;

import java.util.List;
import java.util.Optional;

import com.productstore.model.entities.Product;


public interface ProductService {
	public List<Product>getAllProduct();
	public Optional<Product>findProductById(Long productId);
	public List<Product> findProductByNameLike(String name);

	public void deleteProduct(Long productId);
	public Product addProduct(Product product);
	public Product updateProduct(Long productId,Product product);
	String getProductDetails(Long productId);

}
