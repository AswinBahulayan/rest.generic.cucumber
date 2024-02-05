package com.cucumber.testng;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BaseClass {

	private static WebDriver Driver;

	public WebDriver getDriver() {
		return Driver;
	}

	private void setDriver(WebDriver driver) {
		Driver = driver;
	}

	public void getUrl(String url, String Browser) {
		WebDriver Driver = null;
		switch (Browser) {
		case "Chrome":
			Driver = new ChromeDriver();
			setDriver(Driver);
			break;
		case "Edge":
			Driver = new EdgeDriver();
			setDriver(Driver);
			break;
		case "FireFox":
			Driver = new FirefoxDriver();
			setDriver(Driver);
			break;
		case "Safari":
			Driver = new SafariDriver();
			setDriver(Driver);
			break;
		default:
			break;
		}
		getDriver().get(url);
	}

	public void click(WebElement element, String description) {
		AbstractTestNGCucumberTests.scenario.attach(takeScreenShot(), "image/png", description + " Before click");
		element.click();
		AbstractTestNGCucumberTests.scenario.attach(takeScreenShot(), "image/png", description + " After click");
	}

	public byte[] takeScreenShot() {
		byte[] screenshotAs = null;
		try {
			TakesScreenshot scrShot = ((TakesScreenshot) getDriver());
			screenshotAs = scrShot.getScreenshotAs(OutputType.BYTES);
		} catch (WebDriverException e) {
			e.printStackTrace();
		}
		return screenshotAs;
	}
	
	public void logger(String message) {
		AbstractTestNGCucumberTests.scenario.log(message);
	}
	
	public void addScreenShotToReport(String message) {
		AbstractTestNGCucumberTests.scenario.attach(takeScreenShot(), "image/png", message);
	}
	
	public boolean waitForElementToDisplay(List<WebElement> ele,int seconds) {
		try {
			WebDriverWait wait=new WebDriverWait(Driver, Duration.ofSeconds(seconds));
			wait.until(ExpectedConditions.visibilityOfAllElements(ele));
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			return false;
		}
	}

}
