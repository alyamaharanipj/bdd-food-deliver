package com.gojek.gofood.jbehave.steps.makanan;

import java.util.ArrayList;
import java.util.List;
import com.gojek.gofood.model.*;
import com.gojek.gofood.services.*;

import org.jbehave.core.annotations.*;
import static org.fest.assertions.Assertions.assertThat;

public class makanan_favorite_steps {
	User user;
	ArrayList<Product> products;
	ArrayList<Product> favoritedProducts;
	ProductService productService;
	
	//Scenario 1
	@Given("a user with no favorited products")
	public void givenUserWithNoFavoritedProducts() {
		user = new User();
	}
	
	@Given("available products : $givenProducts")
	public void givenAvailableProducts(List<String> givenProducts) {
		products = new ArrayList<Product>();
		for(String e : givenProducts) {
			products.add(new Product(e));
		}		
	}
	
	@When("the user favorited $productName")
	public void whenUserFavoritedAProduct(String productName) {
		productService = new ProductService(products);
		Product favoritedProduct = productService.find(productName);
		
		user.addFavoriteProduct(favoritedProduct);
	}
	
	@Then("the user should have : $favoritedProductName in their favorited products")
	public void thenUserShouldHave(String favoritedProductName) {
		Product expected = productService.find(favoritedProductName);
		assertThat(expected).isIn(user.getFavoriteProducts());
	}
	
	//Scenario 2 
	@Given("a user with favorited products")
	public void givenUserWithFavoritedProducts() {
		user = new User();
	}
	
	@Given("List of favorited products are : $favoritedProductName in their favorited products")
	public void givenListOfFavoritedProducts(List<String> favoritedProductName) {
		favoritedProducts = new ArrayList<Product>();
		for (String e : favoritedProductName) {
			user.addFavoriteProduct(new Product(e));
		}		
	}
	
	@When("the user unfavorited $productName")
	public void whenUserUnfavoritedAProduct(String productName) {
		productService = new ProductService(user.getFavoriteProducts());
		Product unfavoritedProduct = productService.find(productName);
		user.removeFavoriteProduct(unfavoritedProduct);
	}
}
