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
import org.springframework.web.bind.annotation.RestController;

import com.productstore.exceptionhandler.ProductNotFoundEx;
import com.productstore.exceptionhandler.UserNotFoundEx;
import com.productstore.model.entities.Product;
import com.productstore.model.entities.User;
import com.productstore.model.service.ProductService;
import com.productstore.model.service.UserService;

@RestController
@RequestMapping(path = "/api")
public class UserRestController {
	private UserService userService;

	@Autowired
	public UserRestController(UserService userService) {
		super();
		this.userService = userService;
	}

	@GetMapping(path = "/user", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<User>> getAllUsers() {
		return new ResponseEntity<List<User>>(userService.getAllUser(), HttpStatus.OK);
	}

	/*
	 * @GetMapping(path="/user/{userId}",produces =
	 * MediaType.APPLICATION_JSON_VALUE) public
	 * ResponseEntity<User>getAnUser(@PathVariable(name="id")Long userId){ User
	 * user=userService.findUserById(userId).orElseThrow(UserNotFoundEx::new);
	 * return new ResponseEntity<User>(user,HttpStatus.OK);
	 * 
	 * }
	 * 
	 * @DeleteMapping(path="/user/{userId}",produces =
	 * MediaType.APPLICATION_JSON_VALUE) public
	 * ResponseEntity<Void>deleteAnUser(@PathVariable(name="id")Long userId){
	 * userService.deleteUser(userId); return new
	 * ResponseEntity<Void>(HttpStatus.NO_CONTENT); }
	 * 
	 * @PutMapping(path="user/{userId}",consumes =
	 * MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
	 * public ResponseEntity<User>updateAnUser(@PathVariable(name="id")Long
	 * userId,@RequestBody User user){ return new
	 * ResponseEntity<User>(userService.updateUser(userId, user),HttpStatus.OK); }
	 * 
	 * @PostMapping(path="user") public
	 * ResponseEntity<User>addAnProduct(@Valid @RequestBody User user){ return new
	 * ResponseEntity<User>(userService.addUser(user),HttpStatus.CREATED); }
	 * 
	 */
}
