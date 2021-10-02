package com.gojek.gofood.model;

public class CartItem {
	private Product product;
	private int quantity;
	private float price;
	public CartItem(Product product, int quantity) {
		this.product = product;
		this.quantity = quantity;
	}
		
	public String getName() {
		return product.getName();
	}
	public int getQuantity() {
		return this.quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public boolean equals(CartItem other) {
		return this.getName().equals(other.getName()) && this.getQuantity() == other.getQuantity();
	}
	public Product getProduct() {
		return product;
	}
	public float getPrice() {
		return price;
	}
}
