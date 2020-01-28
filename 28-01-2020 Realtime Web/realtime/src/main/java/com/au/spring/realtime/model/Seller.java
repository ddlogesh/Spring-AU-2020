package com.au.spring.realtime.model;

public class Seller {
	private Integer sellerId;
	private String sellerName;
	private double rating;
	private String shopName;
	
	public Seller() {}
	
	public Seller(Integer sellerId, String sellerName, double rating, String shopName) {
		super();
		this.sellerId = sellerId;
		this.sellerName = sellerName;
		this.rating = rating;
		this.shopName = shopName;
	}
	public Integer getSellerId() {
		return sellerId;
	}
	public void setSellerId(Integer sellerId) {
		this.sellerId = sellerId;
	}
	public String getSellerName() {
		return sellerName;
	}
	public void setSellerName(String sellerName) {
		this.sellerName = sellerName;
	}
	public double getRating() {
		return rating;
	}
	public void setRating(double rating) {
		this.rating = rating;
	}
	public String getshopName() {
		return shopName;
	}
	public void setshopName(String shopName) {
		this.shopName = shopName;
	}
	@Override
	public String toString() {
		return "Seller: " + sellerId + ", sellerName=" + sellerName + ", rating=" + rating + ", shopName=" + shopName;
	}
	
	
}
