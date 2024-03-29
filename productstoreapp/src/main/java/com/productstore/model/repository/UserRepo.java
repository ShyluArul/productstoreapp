package com.productstore.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.productstore.model.entities.User;

@Repository
public interface UserRepo extends JpaRepository<User, Long>{
	public User findUserByName(String name);
	public User findUserByEmail(String email);

}
