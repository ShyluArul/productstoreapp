package com.productstore.model.entities;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="order_table")
public class Orders {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private LocalDate orderDate;
	
	
	@ManyToOne
	@JoinColumn(name="user_fk")
	private User user;
	
	

	@ManyToMany
	@JoinTable(name="orderproduct_table",joinColumns={@JoinColumn(referencedColumnName="id")},
	inverseJoinColumns={@JoinColumn(referencedColumnName="productId")})
	private List<Product> product=new ArrayList<Product>();

	
	
	
	public List<Product> getProduct() {
		return product;
	}
	

	public LocalDate getOrderDate() {
		return orderDate;
	}


	public void setOrderDate(LocalDate orderDate) {
		this.orderDate = orderDate;
	}


	public void setProduct(List<Product> product) {
		this.product = product;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	

	

	public Orders(User user,Product product) {
	
		this.user = user;
		this.orderDate = LocalDate.now();
		this.product.add(product);
	}





	@Override
	public String toString() {
		return "Orders [id=" + id + ", orderDate=" + orderDate + ", user=" + user + ", product=" + product + "]";
	}

	public Orders() {
		super();
		// TODO Auto-generated constructor stub
	}


}
