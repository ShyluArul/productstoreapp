package com.productstore.model.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="store_table")
public class Store {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long storeId;
	private String storeName;
	private String address;
	private String city;
	private double postalCode;
	private String country;
	
	@ManyToMany(fetch=FetchType.EAGER,mappedBy="stores")
	@JsonIgnore
	private List<Product> products = new ArrayList<Product>();

	public void addProduct(Product product){
		products.add(product);
	}

	
	@OneToOne(mappedBy = "store")
	private StoreRating storeRating;
	

	public List<Product> getProduct() {
		return products;
	}
	public List<Product> getProducts() {
		return products;
	}
	public void setProducts(List<Product> products) {
		this.products = products;
	}
	public void setProduct(List<Product> product) {
		this.products = product;
	}
	public StoreRating getStoreRating() {
		return storeRating;
	}
	public void setStoreRating(StoreRating storeRating) {
		this.storeRating = storeRating;
	}
	
	public Long getStoreId() {
		return storeId;
	}
	public void setStoreId(Long storeId) {
		this.storeId = storeId;
	}
	public String getStoreName() {
		return storeName;
	}
	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public double getPostalCode() {
		return postalCode;
	}
	public void setPostalCode(double postalCode) {
		this.postalCode = postalCode;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	@Override
	public String toString() {
		return "Store [storeId=" + storeId + ", storeName=" + storeName + ", address=" + address + ", city=" + city
				+ ", postalCode=" + postalCode + ", country=" + country + "]";
	}
	public Store(String storeName, String address, String city, double postalCode, String country) {
		super();
		this.storeName = storeName;
		this.address = address;
		this.city = city;
		this.postalCode = postalCode;
		this.country = country;
	}
	public Store() {
		super();
		// TODO Auto-generated constructor stub
	}
	

}
