package com.productstore.model.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.productstore.model.entities.Orders;
import com.productstore.model.entities.Product;
import com.productstore.model.entities.User;
import com.productstore.model.repository.OrdersRepo;
import com.productstore.model.repository.UserRepo;

@Service
@Transactional
public class OrderServiceImpl implements OrderService {
@Autowired
private OrdersRepo ordersRepo;
@Autowired
private UserRepo userRepo;

	@Override
	public void findById(Long userId) {
		ordersRepo.findById(userId);
		
	}

	@Override
	public Orders createOrder(User user, Product product) {
	Orders order=new Orders(user,  product);
	order.setUser(user);
	ordersRepo.save(order);
		return order;
	}

}
