package com.gojek.gofood.services;
import com.gojek.gofood.model.*;
import java.util.ArrayList;

public class OrderDetails {
	private ArrayList<Product> restoList;
	private ArrayList<CartItem> myCart;
	public String menu;
	
	public OrderDetails(ArrayList<Product> resto, String menu) {
		this.restoList = resto;
		this.menu = menu;
	}
	
	public ArrayList<CartItem> getOrderDetails(){
		myCart = new ArrayList<CartItem>();
		for(Product e : restoList) {
			if(menu.equals(e.getName())) {
				myCart.add(new CartItem(e, 1));
			}
		}
		return myCart;
	}
}
