package test.runners;

import com.cucumber.testng.AbstractTestNGCucumberTests;

import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		features = {"src//test//resources//Feature"},
		glue={"com.api.stepDefinition","com.ui.stepDefinition"},
		plugin = {"pretty","html:target/cucumber/cucumber-report.html"},
		tags = "@regression_All")
public class Runners extends AbstractTestNGCucumberTests{
	

}
