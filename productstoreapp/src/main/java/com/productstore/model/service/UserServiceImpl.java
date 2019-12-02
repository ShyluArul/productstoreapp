package com.productstore.model.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.productstore.exceptionhandler.StoreNotFoundEx;
import com.productstore.exceptionhandler.UserNotFoundEx;
import com.productstore.model.entities.Store;
import com.productstore.model.entities.User;
import com.productstore.model.repository.UserRepo;

@Service
@Transactional
public class UserServiceImpl implements UserService {
@Autowired
private UserRepo userRepo;

	@Override
	public List<User> getAllUser() {
		
		return userRepo.findAll();
	}

	/*
	 * @Override public Optional<User> findUserById(Long userId) {
	 * 
	 * return userRepo.findById(userId); }
	 * 
	 * @Override public void deleteUser(Long userId) { userRepo.deleteById(userId);
	 * 
	 * }
	 * 
	 * @Override public User addUser(User user) { return userRepo.save(user); }
	 * 
	 * @Override public User updateUser(Long userId, User user) { User
	 * userToBeUpdated=userRepo.findById(userId) .orElseThrow(UserNotFoundEx::new);
	 * userToBeUpdated.setName(user.getName()); return
	 * userRepo.save(userToBeUpdated); }
	 */
	@Override
	public User findStoreByUserName(String userName) {
		// TODO Auto-generated method stub
		return userRepo.findUserByName(userName);
	}

}
