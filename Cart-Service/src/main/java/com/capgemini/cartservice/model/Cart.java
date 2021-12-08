package com.capgemini.cartservice.model;

import java.util.Objects;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Field;

public class Cart {
	@Field
	private String productType;
	@Field
	private String productName;
	@Field
	private String category;
	@Field
	private int rating;
	@Field
	private String review;
	@Field
	private String image;
	@Field
	private double price;
	@Field
	private String description;
	@Field
	private String specification;
	public Cart() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Cart( String productType, String productName, String category, int rating, String review,
			String image, double price, String description, String specification) {
		super();
		this.productType = productType;
		this.productName = productName;
		this.category = category;
		this.rating = rating;
		this.review = review;
		this.image = image;
		this.price = price;
		this.description = description;
		this.specification = specification;
	}
	public String getProductType() {
		return productType;
	}
	public void setProductType(String productType) {
		this.productType = productType;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public int getRating() {
		return rating;
	}
	public void setRating(int rating) {
		this.rating = rating;
	}
	public String getReview() {
		return review;
	}
	public void setReview(String review) {
		this.review = review;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getSpecification() {
		return specification;
	}
	public void setSpecification(String specification) {
		this.specification = specification;
	}
	@Override
	public String toString() {
		return "Cart [ productType=" + productType + ", productName=" + productName
				+ ", category=" + category + ", rating=" + rating + ", review=" + review + ", image=" + image
				+ ", price=" + price + ", description=" + description + ", specification=" + specification + "]";
	}
	
	
}
