package com.productstore.web.request;

public class DetailsResponse {
	private String details;

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}

	public DetailsResponse(String details) {
		super();
		this.details = details;
	}

}
