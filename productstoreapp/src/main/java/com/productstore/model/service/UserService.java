package com.productstore.model.service;

import java.util.List;
import java.util.Optional;

import com.productstore.model.entities.Store;
import com.productstore.model.entities.User;

public interface UserService {
	public List<User>getAllUser();
	
	public User findStoreByUserName(String userName);
	

}
