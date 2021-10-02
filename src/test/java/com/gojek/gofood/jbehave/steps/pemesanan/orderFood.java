package com.gojek.gofood.jbehave.steps.pemesanan;
import org.jbehave.core.annotations.*;

import com.gojek.gofood.services.*;
import com.gojek.gofood.model.*;
import java.util.ArrayList;

import static org.junit.Assert.assertSame;
import static org.fest.assertions.Assertions.assertThat;


public class orderFood {
	private ArrayList<Product> resto;
	private ArrayList<Integer> voucher;
	private ArrayList<CartItem> myCart;
	private OrderDetails OrderDetails;
	private ArrayList<CartItem> givenCart;
	private ArrayList<String> ListAddress;
	private String location;
	private String addressNotes;
	private String productNotes;
	
	@Given("a list of restaurant : $givenResto")
	public void givenListOfResto(ArrayList<String> givenResto){
		resto = new ArrayList<Product>();
		for (String e : givenResto){
			resto.add(new Product(null,new Merchant(e)));
		}
	}
	
	@Given("the menus are : $givenMenu")
	public void givenListOfMenu(ArrayList<String> givenMenu) {
		int i=0;
		for(Product e:resto) {
			e.setName(givenMenu.get(i));
			i++;
		}
	}
	
	@Given("the price : $givenPrice")
	public void givenListOfPrice(ArrayList<Integer> givenPrice) {
		int i=0;
		for(Product e:resto) {
			e.setPrice(givenPrice.get(i));
			i++;
		}
	}
	
	@When("i choose $menu")
	public void whenIChooseMenu(String menu) {
		OrderDetails = new OrderDetails(resto, menu);
		myCart = OrderDetails.getOrderDetails();
	}
	
	@Then("the order details like restaurant's name : $restoProduct and menu's name : $menuProduct and price : $priceProduct and quantity : $quantityProduct added to cart")
	public void menuAdded(String restoProduct, String menuProduct, float priceProduct, int quantityProduct) {
		givenCart = new ArrayList<CartItem>();
		givenCart.add(new CartItem(new Product(menuProduct, new Merchant(restoProduct), priceProduct), quantityProduct));
		for (int i = 0; i < givenCart.size(); i++) {
			assertThat(myCart.get(i).getProduct().getName()).isEqualTo(givenCart.get(i).getProduct().getName());
			assertThat(myCart.get(i).getProduct().getPrice()).isEqualTo(givenCart.get(i).getProduct().getPrice());
			assertThat(myCart.get(i).getQuantity()).isEqualTo(givenCart.get(i).getQuantity());
			assertThat(myCart.get(i).getProduct().getMerchant().getName()).isEqualTo(givenCart.get(i).getProduct().getMerchant().getName());
			i++;
		}
	}
	
	@Given("an order details in cart like restaurant : $restoProduct and menu : $menuProduct and price : $priceProduct and quantity : $quantityProduct")
	public void detailsInCart(String restoProduct, String menuProduct, int priceProduct, int quantityProduct){
		myCart = new ArrayList<CartItem>();
		myCart.add(new CartItem(new Product(menuProduct, new Merchant(restoProduct), priceProduct), quantityProduct));
	}
	
	@When("i add $quantity more the $food")
	public void addQuantity(int quantity,String food){
		for (CartItem e : myCart){
			if(e.getProduct().getName().equals(food)){
				
				e.setQuantity(e.getQuantity()+quantity);
			}
		}
	}
	
	@Then("the quantity of $food will be change into $newQuantity")
	public void quantityChange(String food, int newQuantity) {
		for (CartItem e : myCart){
			if(e.getProduct().getName().equals(food)) {
				assertSame(newQuantity,e.getQuantity());
			}
		}
	}
	
	@Given("an order details in cart restaurant :  $restoProduct and menu : $menuProduct and price : $priceProduct and quantity : $quantityProduct")
	public void detailOrdersInCart(String restoProduct, String menuProduct, int priceProduct, int quantityProduct){
		myCart = new ArrayList<CartItem>();
		myCart.add(new CartItem(new Product(menuProduct, new Merchant(restoProduct), priceProduct), quantityProduct));
	}
	@When("i reduce $quantity quantity of the $food")
	public void reduceQuantityOfFood(int quantity, String food){
		for (CartItem e : myCart){
			if(e.getProduct().getName().equals(food)) {
				e.setQuantity(e.getQuantity()-quantity);
			}
		}
	}
	@Then("$food quantity will be changed into $newQuantity")
	public void quantityFoodChangedInCart(String food, int newQuantity) {
		for (CartItem e : myCart){
			if(e.getProduct().getName().equals(food)) {
				assertSame(newQuantity,e.getQuantity());
			}
		}
	}
	
	@Given("an order details in cart : $restoProduct and menu : $menuProduct and price : $priceProduct and quantity : $quantityProduct")
	public void givenCartIsNull(String restoProduct, String menuProduct, int priceProduct, int quantityProduct){
		myCart = new ArrayList<CartItem>();
		myCart.add(new CartItem(new Product(menuProduct, new Merchant(restoProduct), priceProduct),0));
	}

	@When("i remove $menu")
	public void whenIRemoveMenu(String menu) {
		myCart.remove(0);
	}
	
	@Then("my cart is empty")
	public void cartisNull() {
		assertSame(myCart.size(),0);
	}
	
	@Given("a list of address : $givenAddress")
	public void givenListOfAddress(ArrayList<String> givenAddress) {
		ListAddress = new ArrayList<String>();
		for(String e : givenAddress) {
			ListAddress.add(e);
		}
	}

	@When("i pick address : $address")
	public void whenIChooseAddress(String address) {
		for(String e : ListAddress) {
			if(e.equals(address)) {
				location = address;
			}
		}
	}

	@Then("$address added to location")
	public void locationAdded(String address) {
		assertThat(address).isEqualTo(location);
	}
	
	@Given("a blank address notes")
	public void givenBlankAddressNotes(){
		addressNotes = "";
		}
	
	@When("I write my details address : $address")
	public void whenIWriteAddress(String address) {
		addressNotes = address;
	}
	
	@Then("address notes contain $address")
	public void thenNotesContainAddress(String address) {
		assertThat(addressNotes).isEqualTo(address);
	}

	@Given("a blank product notes")
	public void givenBlankProductNotes(){
		productNotes = "";
	}
			
	@When("I write details request : $Notes")
	public void whenIWriteProductNotes(String Notes) {
		productNotes = Notes;
	}
	
	@Then("product notes contain $Notes")
	public void thenNotesContrain(String Notes) {
		assertThat(productNotes).isEqualTo(Notes);
	}
	
	@Given("i've food in my cart with details restaurant's name : $restoProduct and menu's name : $menuProduct and price : $priceProduct and quantity : $quantityProduct")
	public void foodInMyCart(String restoProduct, String menuProduct, int priceProduct, int quantityProduct) {
		myCart = new ArrayList<CartItem>();
		myCart.add(new CartItem(new Product(menuProduct, new Merchant(restoProduct), priceProduct), quantityProduct));
	}
	
	@When("i want to know total price of $food that i buy")
	public void iWantToKnowTotalPrice(String food) {
		for (CartItem e : myCart){
			if(e.getProduct().getName().equals(food)) {
				e.setPrice(e.getProduct().getPrice()*e.getQuantity());
			}
		}
	}
	
	@Then("the total price of $food that i buy is $totalPrice")
	public void nowIKnow(String food, float totalPrice) {
		for (CartItem e : myCart){
			if(e.getProduct().getName().equals(food)) {
				assertThat(totalPrice).isEqualTo(e.getPrice());
			}
		}
	}
	
	@Given("I have list of discount voucher : $givenVoucher in %")
	public void listDiscountVoucher(ArrayList<Integer> givenVoucher) {
		voucher = givenVoucher;
	}
	
	@Given("my cart with details restaurant's name : $restoProduct and menu's name : $menuProduct and price : $priceProduct and quantity : $quantityProduct")
	public void foodDetailsInMyCart(String restoProduct, String menuProduct, int priceProduct, int quantityProduct) {
		myCart = new ArrayList<CartItem>();
		myCart.add(new CartItem(new Product(menuProduct, new Merchant(restoProduct), priceProduct), quantityProduct));
	}
	
	@When("I use voucher for $voucherUsed % discount for $food")
	public void useVoucherDiscount(Integer voucherUsed, String food) {
		for (Integer e : voucher){
			if(e == voucherUsed) {
				for (CartItem i : myCart) {
					if(i.getProduct().getName().equals(food)) {
						i.setPrice((i.getProduct().getPrice()*i.getQuantity())-(((float)voucherUsed/100)*i.getProduct().getPrice()*i.getQuantity()));
					}
				}
			}
		}
	}
	
	@Then("total price of $food will change into $price")
	public void priceWillChange(String food, float price) {
		for (CartItem e : myCart){
			if(e.getProduct().getName().equals(food)) {
				assertThat(e.getPrice()).isEqualTo(price);
			}
		}
	}
}