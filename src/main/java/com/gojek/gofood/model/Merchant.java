package com.gojek.gofood.model;

import java.util.ArrayList;

public class Merchant {
	private String name;
	private float rating;
	private String location;
	private float distanceFromCustomer;
	private ArrayList<Product> productsList;
	
	// CONSTRUCTORS
	public Merchant(String name, float rating, String location, float distanceFromCustomer) {
		this.name = name;
		this.rating = rating;
		this.location = location;
		this.distanceFromCustomer = distanceFromCustomer;		
		productsList = new ArrayList<Product>();
	}
	
	public Merchant() {
		this("",0,"",0);
	}
	public Merchant(String name) {
		this(name,0,"",0);
	}
	public Merchant(String name, float distance) {
		this(name,0,"",distance);
	}
	public Merchant(float rating) {
		this("",rating,"",0);
	}
	
	//GETTERS & SETTERS
	public String getName() {
		return this.name;
	}
	public float getRating() {
		return this.rating;
	}
	public void setRating(float rating) {
		this.rating = rating;
		}
	public String getLocation() {
		return this.location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public float getDistanceFromCustomer() {
		return this.distanceFromCustomer;
	}
	public void setDistanceFromCustomer(float distanceFromCustomer) {
		this.distanceFromCustomer = distanceFromCustomer;
	}
	public ArrayList<Product> getProductsList(){
		return productsList;
	}
	public void addProduct(Product p) {
		productsList.add(p);
		p.setMerchant(this);
	}
}
