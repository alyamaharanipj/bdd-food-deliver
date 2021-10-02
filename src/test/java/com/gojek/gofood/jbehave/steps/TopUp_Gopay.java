package com.gojek.gofood.jbehave.steps;
import org.jbehave.core.annotations.*;
import static org.fest.assertions.Assertions.assertThat;
import com.gojek.gofood.model.User;


public class TopUp_Gopay {
	
	private User user;
	private float saldoGoPay_before;
	private float saldoGoPay_after;
	private float nominalTopUp;
	
	@Given("gofood account $name with the balance is $balance")
	public void givenNameAndBalance(String name, float balance) {
		user = new User(name);
		user.setBalance(balance);
	}
	
	@When("ichwan want top up $nominal")
	public void topUp(float nominal) {
		nominalTopUp = nominal;
		saldoGoPay_before = user.getBalance();
	}
	
	@Then("the total balance should be $supposedBalance")
	public void sumBalance(float supposedBalance) {
		this.saldoGoPay_after = this.saldoGoPay_before + nominalTopUp;
		user.setBalance(saldoGoPay_after);
		assertThat(saldoGoPay_after).isEqualTo(saldoGoPay_after);
	}
}