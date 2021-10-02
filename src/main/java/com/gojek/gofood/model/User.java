package com.gojek.gofood.model;

import java.util.ArrayList;

public class User {
	private String name;
	private ArrayList<Product> favoriteProducts;

	private float saldoGoPay;
	
	public User(String name) {
		this.name = name;
		this.favoriteProducts = new ArrayList<Product>();
	}
	public User() {
		this("");
	}

	public float getBalance() { return this.saldoGoPay; }

	public void setBalance(float newSaldo) { this.saldoGoPay = newSaldo; }
	
	public String getName() {
		return name;
	}
	public void setName(String newName) { 
		name = newName;
	}
	public ArrayList<Product> getFavoriteProducts(){
		return favoriteProducts;
	}
	
	public void addFavoriteProduct(Product favoritedProduct) {
		favoriteProducts.add(favoritedProduct);
	}
	
	public void removeFavoriteProduct(Product unfavoritedProduct) {
		favoriteProducts.remove(unfavoritedProduct);
	}
	
}
