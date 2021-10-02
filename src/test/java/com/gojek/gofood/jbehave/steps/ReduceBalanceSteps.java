package com.gojek.gofood.jbehave.steps;
import org.jbehave.core.annotations.*;
import static org.fest.assertions.Assertions.assertThat;
import com.gojek.gofood.model.Order;
import com.gojek.gofood.model.User;
import com.gojek.gofood.model.Product;

public class ReduceBalanceSteps {
		private Order pesanan;
		private User user;
		private Product produk;
		
	
	@Given("$givenName gopay account with balance is $givenBalance")
	public void setUpOfBalance(String givenName, float givenBalance) {
		user = new User(givenName);
		user.setBalance(givenBalance);
		produk = new Product("Ayam Katsu");
		produk.setPrice(100000);
		pesanan =  new Order(user,produk,5,false,0);
	}
	
	@When("amount of order is $totalOfAmount")
	public void setAmountofOrder(float totalOfAmount) {
		pesanan.setTotalPembayaran(totalOfAmount);
	}
	
	@When("promo is $givenPromo")
	public void setPromo(float givenPromo) {
		produk.setDiscount(givenPromo);
	}
	
	@Then("the rest of balance is $restOfBalance and cash $restOfCash")
	public void shouldReduceBalanceOrNot(float restOfBalance, float restOfCash) {
		float totalOfAmount = pesanan.getTotalPembayaran();
		float totalOfBalance = user.getBalance();
		float promo = pesanan.getPromoProdukPesanan();
		float amount = totalOfAmount;
		float cash = restOfCash;
		if(promo != 0) {
			amount = totalOfAmount - (totalOfAmount * (promo/100));
		}
		if(totalOfBalance >= amount) {
			totalOfBalance = totalOfBalance - amount;
		} else {
			cash = amount - totalOfBalance;
			totalOfBalance = 0;
		}
		user.setBalance(totalOfBalance);
		assertThat(totalOfBalance).isEqualTo(restOfBalance);
		assertThat(cash).isEqualTo(restOfCash);
	}
}
