package com.gojek.gofood.jbehave.steps;

import com.gojek.gofood.model.*;
import com.gojek.gofood.services.*;

import org.jbehave.core.annotations.*;
import static org.fest.assertions.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;


public class Order_History {
	List<Order> orderInformation;
	List<String> proposedOrders;
	SaveOrder savedOrder;
	
	@Given("List of orders : $givenOrder")
	public void givenOrderGoFood(ArrayList<String> givenOrder) {
		orderInformation = new ArrayList<Order>();
		for (String e : givenOrder) {
			orderInformation.add(new Order(new Product(e)));
		}
	}
	
	@Given("the location : $givenLocation")
	public void givenOrderLocation(List<String> givenLocation) {
		int i = 0;
		for (Order e : orderInformation) {
			e.setLocation(givenLocation.get(i));
			i++;
		}
	}
	
	@Given("the menu : $givenMenu")
	public void givenOrderMenu(List<String> givenMenu) {
		int i = 0;
		for (Order e : orderInformation) {
			e.setMenu(givenMenu.get(i));
			i++;
		}
	}
	
	@When("Order are : $status")
	public void whenOrderAre (List<String> status) {
		int i=0;
		for(Order e : orderInformation){
			e.setOrderStatus(status.get(i));
			i++;
		}
		savedOrder = new SaveOrder(orderInformation);
		proposedOrders = savedOrder.getSavedOrder();
	}
	@Then("Save information to order history : $saveShould")
	public void shouldFindTheseOrder(List<String> saveShould) {
		int j = 0;
		for(String e : proposedOrders) {
			assertThat(proposedOrders.get(j)).isEqualTo(saveShould.get(j));
			j++;
		}
		
	}
}
