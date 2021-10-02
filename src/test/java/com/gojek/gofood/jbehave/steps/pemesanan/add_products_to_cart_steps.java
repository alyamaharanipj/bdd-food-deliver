package com.gojek.gofood.jbehave.steps.pemesanan;
import java.util.ArrayList;
import java.util.List;
import com.gojek.gofood.model.*;
import com.gojek.gofood.services.*;

import org.jbehave.core.annotations.*;
import static org.fest.assertions.Assertions.assertThat;

public class add_products_to_cart_steps {
	private ShoppingCart cart;
	private List<Product> products;
	private ProductService productService;
	
	//Scenario 1
	@Given("an empty cart")
	public void givenAnEmptyCart() {
		cart = new ShoppingCart();
	}
	
	@Given("a list of products name : $givenProducts")
	public void givenListOfProducts(List<String> givenProducts) {
		products = new ArrayList<Product>();
		for(String e : givenProducts) {
			products.add(new Product(e));
		}		
	}
	@Given("the product's merchants in the same order are : $productsMerchants")
	public void givenTheProductsMerchants(List<String> productsMerchants) {
		int i = 0;
		productService = new ProductService(products);
		for(Product e : products) {
			Merchant m = productService.findMerchant(productsMerchants.get(i));
			if(m != null) {
				e.setMerchant(m);				
			}else {
				e.setMerchant(new Merchant(productsMerchants.get(i)));
			}
			i++;
		}		
	}
	
	@When("I add $quantity of $productName to the cart")
	public void whenAddingProductToCart(int quantity, String productName) {
		Product addedProduct;
		addedProduct = productService.find(productName);
		CartItem item = new CartItem(addedProduct, quantity);
		cart.add(item);
	}
	
	@Then("there should be $expectedQty of $expectedProductName inside the cart")
	public void thenThereShouldBeAddedProductInsideTheCart(int expectedQty, String expectedProductName) {
		CartItem addedItem = cart.find(expectedProductName);
		CartItem expectedItem = new CartItem(productService.find(expectedProductName), expectedQty);
		assertThat(addedItem.getName()).isEqualTo(expectedItem.getName());
		assertThat(addedItem.getQuantity()).isEqualTo(expectedItem.getQuantity());
	}
	
	//Scenario 2 
	@Given("a cart filled with $quantity of $productName from $productsMerchants")
	public void givenAFilledCart(int quantity, String productName, String productMerchants) {
		Product addedProduct;
		cart = new ShoppingCart();
		addedProduct = productService.find(productName);
		CartItem item = new CartItem(addedProduct, quantity);
		cart.add(item);
	}	


}
