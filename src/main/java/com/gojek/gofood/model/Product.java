package com.gojek.gofood.model;

public class Product {
	private String name;
	private float discount;
	private float price;
	private Merchant merchant;
	private String category;
	private int stock;

	
	//Constructors
	public Product(String name, float discount, float price, Merchant merchant) {
		this.name = name;
		this.discount = discount;
		this.price = price;
		this.merchant = merchant;
	}

	public Product(String name) {
		this(name, 0, 0, null);
	}
	
	public Product(String name, Merchant m) {
		this(name, 0, 0, m);
		merchant.addProduct(this);
	}
	public Product(String name, Merchant m, float price) {
		this(name, 0, price, m);
		merchant.addProduct(this);
	}
	
	public Product(String name, int stock) {
		this(name,0,0,null);
		this.stock = stock;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String newName) { 
		name = newName;
	}
	public float getDiscount() {
		return discount;
	}
	public void setDiscount(float newDiscount) { 
		discount = newDiscount;
	}
	
	public float getPrice() {
		return price - (price*discount);
	}
	public void setPrice(float newPrice) { 
		price = newPrice;
	}
	public Merchant getMerchant() {
		return merchant;
	}
	public void setMerchant(Merchant m) {
		merchant = m;
	}
	public float getDistance() {
		return merchant != null ? merchant.getDistanceFromCustomer() : null;
	}
	public float getRating() {
		return merchant != null ? merchant.getRating() : null;
	}

	public String getCategory() {return category;}
	public void setCategory(String newCategory) {category = newCategory;}

	public void setStock(int stock) {
		this.stock = stock;
	}
	
	public int getStock() {
		return stock;
	}

}
