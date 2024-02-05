package com.api.stepDefinition;

import com.cucumber.testng.AbstractTestNGCucumberTests;

import api.classes.CoinMapApi;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;

public class CoinMapStepDefinition {
	@Before
	public void before(Scenario scenario) {
		AbstractTestNGCucumberTests.scenario = scenario;
	}
	
	CoinMapApi api=new CoinMapApi();
		
	@Given("Make a get call for {string}")
	public void getCoinMap(String endpoint) {
		api.prerequisites();
		api.getCoinMap(AbstractTestNGCucumberTests.scenario);
	}
	
	@And("Get the count of categories list like atm, cafe, shopping, food, lodging , attraction , default are available")
	public void getCategory() {
		api.deserializeClass();
	}
	
	@And("get the names of only “food” category and geo locations")
	public void getFoodCategoryAndLocation() {
		api.getFoodCategoryAndLocation();
	}
}
