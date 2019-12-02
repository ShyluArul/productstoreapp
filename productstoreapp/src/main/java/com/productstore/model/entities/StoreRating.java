package com.productstore.model.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="storerating_table")
public class StoreRating {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long ratingId;
	private String rating;
	private String review;
	@OneToOne
	@JoinColumn(name="store_id")
	private Store store;


	
	public Store getStore() {
		return store;
	}
	public Long getRatingId() {
		return ratingId;
	}
	public void setRatingId(Long ratingId) {
		this.ratingId = ratingId;
	}
	public void setStore(Store store) {
		this.store = store;
	}

	public String getReview() {
		return review;
	}
	public void setReview(String review) {
		this.review = review;
	}
	
	public String getRating() {
		return rating;
	}
	public void setRating(String rating) {
		this.rating = rating;
	}
	
	public StoreRating(String rating, String review) {
		super();
		this.rating = rating;
		this.review = review;
	}
	@Override
	public String toString() {
		return "StoreRating [ratingId=" + ratingId + ", rating=" + rating + ", review=" + review + "]";
	}
	public StoreRating() {
		super();
		// TODO Auto-generated constructor stub
	}

}
