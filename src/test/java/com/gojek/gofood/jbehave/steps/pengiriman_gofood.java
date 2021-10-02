package com.gojek.gofood.jbehave.steps;

import com.gojek.gofood.model.*;
import com.gojek.gofood.services.*;

import org.jbehave.core.annotations.*;
import static org.fest.assertions.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;

public class pengiriman_gofood {
	List<Driver> drivers;
	List<String> proposedDrivers;
	DriverService DriverService;
	List<String> highestRating;
	List<String> highestScore;
	@Given("a list of drivers : $givenDrivers")
	public void givenListOfDrivers(List<String> givenDrivers) {
		drivers = new ArrayList<Driver>();
		for (String e : givenDrivers) {
			drivers.add(new Driver(e));
		}
	}
	
	@When("The distances between these drivers and the merchant location are : $distance")
	public void whenDistanceBetweenDriversAndMerchant (List<Float> distance) {
		int i = 0;
		for(Driver e : drivers){
			e.setDistance(distance.get(i));
			i++;
		}
		DriverService = new DriverService(drivers);
		proposedDrivers = DriverService.getNearestDriverName();
	}
	
	@Then("The sistem should pick : $nearestDriver")
	public void shouldFindTheseDriver(List<String> nearestDriver) {
		assertThat(proposedDrivers).isEqualTo(nearestDriver);
	}
	
	@Given("drivers list : $givenlistDrivers")
	public void givenListOfRatedDrivers(List<String> givenlistDrivers) {
		drivers = new ArrayList<Driver>();
		for (String e : givenlistDrivers) {
			drivers.add(new Driver(e));
		}
	}
	
	@When("The rating of each driver : $rating")
	public void whenRating (List<Float> rating) {
		int i = 0;
		for(Driver e : drivers){
			e.setRating(rating.get(i));
			i++;
		}
		DriverService = new DriverService(drivers);
		highestRating = DriverService.getTopRatedName();
	}
	
	@Then("The sistem should choose : $highestRatingDrivers")
	public void shouldChoose(List<String> highestRatingDrivers) {
		assertThat(highestRating).isEqualTo(highestRatingDrivers);
	}
	
	@Given("list of driver : $givenlistDrivers")
	public void givenListOfScoredDrivers(List<String> givenlistDrivers) {
		drivers = new ArrayList<Driver>();
		for (String e : givenlistDrivers) {
			drivers.add(new Driver(e));
		}
	}
	
	@When("The score from rating and distance of each driver : $score")
	public void whenScore (List<Float> score) {
		int i = 0;
		for(Driver e : drivers){
			e.setRatingDist(score.get(i));
			i++;
		}
		DriverService = new DriverService(drivers);
		highestScore = DriverService.getTopName();
	}
	
	@Then("The sistem should choose the best name : $highestScoredriver")
	public void shouldChooseBestName(List<String> highestScoredriver) {
		assertThat(highestScore).isEqualTo(highestScoredriver);
	}
}
