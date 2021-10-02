package com.gojek.gofood.jbehave.steps;

import com.gojek.gofood.model.*;
import com.gojek.gofood.services.*;
import org.jbehave.core.annotations.*;
import static org.fest.assertions.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;


public class Search_products {
	List<Product> products;
	List<String> proposedProduct;
	ProductService productService;
	
	@Given("a list of products are : $givenProducts")
	public void givenAlistOfProduct(List<String> givenProducts) {
		products = new ArrayList<Product>();
		for (String e : givenProducts) {
			products.add(new Product(e, new Merchant()));
		}
	}
	@Given("its rating : $givenRating")
	public void givenRating(List<String> givenRating) {
		int i = 0;
		for (Product e : products) {
			e.getMerchant().setRating(Float.parseFloat(givenRating.get(i)));
			i++;
		}
	}

	@When("The distances between these products and my location are : $distance")
	public void whenOrderAre (List<String> distance) {
		int i=0;
		for(Product e : products){
			e.getMerchant().setDistanceFromCustomer(Float.parseFloat(distance.get(i)));
			i++;
		}
		productService = new ProductService(products);
		proposedProduct = productService.getBestProduct();
	}
	@Then("The sistem should pick product : $Should")
	public void shouldChooseTheseProduct(List<String> Should) {
		int j = 0;
		assertThat(proposedProduct.get(j)).isEqualTo(Should.get(j));
	}
}
