package com.productstore.model.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="product_table")
public class Product {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long productId;
	private String productName;
	private double productQuantity;
	private double price;
	private String details;
	
	@ManyToMany
	@JoinTable(name="storeProduct_table",joinColumns={@JoinColumn(name="product_fk")},
	inverseJoinColumns={@JoinColumn(name="store_fk")})
	@JsonIgnore
	private List<Store> stores = new ArrayList<Store>();
	
	public void addStore(Store store){
		stores.add(store);
	}

	@ManyToMany
	@JoinColumn(name="product_id")
	@JsonIgnore
	private List<Orders>orders=new ArrayList<Orders>();
	
	
	public List<Orders> getOrders() {
		return orders;
	}
	
	public List<Store> getStore() {
		return stores;
	}

	public void setStore(List<Store> store) {
		this.stores= store;
	}

	public void setOrders(List<Orders> orders) {
		this.orders = orders;
	}
	public Long getProductId() {
		return productId;
	}
	public void setProductId(Long productId) {
		this.productId = productId;
	}
	@Override
	public String toString() {
		return "Product [productId=" + productId + ", productName=" + productName + ", productQuantity="
				+ productQuantity + ", price=" + price + ", details=" + details + "]";
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getDetails() {
		return details;
	}
	public void setDetails(String details) {
		this.details = details;
	}
	public double getProductQuantity() {
		return productQuantity;
	}
	public void setProductQuantity(double productQuantity) {
		this.productQuantity = productQuantity;
	}
	public Product(String productName, double productQuantity, double price, String details) {
		super();
		this.productName = productName;
		this.productQuantity = productQuantity;
		this.price = price;
		this.details = details;
	}
	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
