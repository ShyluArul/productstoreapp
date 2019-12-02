package com.productstore.model.service;

import com.productstore.model.entities.Orders;
import com.productstore.model.entities.Product;
import com.productstore.model.entities.User;

public interface OrderService {
	public void findById(Long userId);
	public Orders createOrder(User user,Product product);


}
