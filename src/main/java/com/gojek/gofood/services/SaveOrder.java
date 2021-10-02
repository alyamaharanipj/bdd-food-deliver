package com.gojek.gofood.services;
import java.util.ArrayList;
import java.util.List;
import com.gojek.gofood.model.*;

public class SaveOrder {
	private List<Order> orderInfo;
	
	public SaveOrder(List<Order> pl) {
		orderInfo = pl;
	}
	public List<String> getSavedOrder() {
		ArrayList<String> result= new ArrayList<String>() ;
		String temp2 ="Complete";
		for (Order e : orderInfo) {
			if (e.getOrderStatus().equals(temp2)) {
				result.add(e.getNamaProdukPesanan()+" "+e.getLocation()+" "+e.getMenu());
			}
		}
		return result;
	}
}
