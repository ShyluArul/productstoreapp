package com.productstore.model.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


@Entity
@Table(name="User_table")
public class User {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
			private Long userId;
	private String name;
	private String email;
	private String password;
	private static BCryptPasswordEncoder encoder=new BCryptPasswordEncoder();


	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "user")

	private List<Orders>  myOrders=new ArrayList<Orders>();
	
	public void addOrder(Orders order){
		myOrders.add(order);
	}
		

	 	
	
	public List<Orders> getOrders() {
		return myOrders;
	}
	public void setOrders(List<Orders> orders) {
		this.myOrders = orders;
	}
	public List<Orders> getMyOrders() {
		return myOrders;
	}




	public void setMyOrders(List<Orders> myOrders) {
		this.myOrders = myOrders;
	}




	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password= encoder.encode(password);
	}
	
	@Override
	public String toString() {
		return "User [userId=" + userId + ", name=" + name + ", "
				+ "email=" + email + ", password=" + password
				+  "]";
	}
	public User(String name, String email, String password) {
		super();
		this.name = name;
		this.email = email;
		setPassword(password);

	}
	public User() {
		
	}
	

}
