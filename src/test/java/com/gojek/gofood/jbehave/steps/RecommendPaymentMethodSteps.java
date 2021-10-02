package com.gojek.gofood.jbehave.steps;
import org.jbehave.core.annotations.*;
import static org.fest.assertions.Assertions.assertThat;
import com.gojek.gofood.model.*;

public class RecommendPaymentMethodSteps {

	private Order pesanan;
	private User user;
	private Product produk;
	
	@Given("$name has balance $balance")
	public void givenUserDetails(String name, float balance) {
		 user = new User(name);
		 user.setBalance(balance);
		 produk = new Product("AyamGaEnak");
		 produk.setPrice(10000);
		 pesanan =  new Order(user,produk,10,false,0);
	}
		
	@When("amount is $amount")
	public void setAmount(float amount) {
		pesanan.setTotalPembayaran(amount);
	}
	
	@Then("system should recommend $expectedPaymentMethod payment method")
	public void checkThePaymentMethod(String expectedPaymentMethod) {
		String proposePaymentMethod = pesanan.getRecommendedPayment(pesanan.getTotalPembayaran(), pesanan.getSaldoUser());
		assertThat(proposePaymentMethod).isEqualTo(expectedPaymentMethod);
	}
}