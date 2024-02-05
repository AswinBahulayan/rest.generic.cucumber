package com.ui.stepDefinition;

import com.cucumber.testng.AbstractTestNGCucumberTests;
import com.reactJs.pages.PageObjectFactory;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ReactJsStepDefinition {
	PageObjectFactory pageObjectFactory=new PageObjectFactory();

	@Before
	public void before(Scenario scenario) {
		AbstractTestNGCucumberTests.scenario = scenario;
	}

	@Given("Navigate to React JS site {string}")
	public void launchBroswer(String url) {
		pageObjectFactory.getApp().launchApp(url);
	}

	@When("Click on Docs Tab")
	public void clickDocsTab() {
		pageObjectFactory.getReact().clickDocsTab();
	}

	@And("Expand the main Concepts and highlight all the sub elements or link references and get the text dynamically and save it in file")
	public void clickMainConcepts() {
		pageObjectFactory.getReact().clickMainConcepts();
	}

	@And("Similarly Do it for Advanced Guides Tab also")
	public void clickAdvancedGuides() {
		pageObjectFactory.getReact().clickAdvanceGuides();
	}

	@And("Verify Scroll Functionality in tutorial tab")
	public void scrollFunctionality() {
		pageObjectFactory.getReact().clickTutorialTab();
	}

	@Then("On scrolling down, verify the respected content is Bolded on Right Navigation and Blue color line is seen")
	public void verifyElementAtrribute() {
		pageObjectFactory.getReact().scrollTutorialPage();
	}

}
