package com.reactJs.pages;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

import com.cucumber.testng.BaseClass;

public class ReactJsPage extends BaseClass {

	public ReactJsPage() {
		PageFactory.initElements(getDriver(), this);
	}

	@FindBy(xpath = "//a[text()='Docs']")
	private WebElement btnDocsTab;

	@FindBy(xpath = "//a[text()='Tutorial']")
	private WebElement btnTutorialTab;

	@FindBy(xpath = "//div[text()='Main Concepts']/..")
	private WebElement btnMainConcept;

	@FindBy(xpath = "//div[text()='Main Concepts']/../..//li/a")
	private List<WebElement> btnMainSubElements;

	@FindBy(xpath = "//div[text()='Advanced Guides']/..")
	private WebElement btnAdvancedGuides;

	@FindBy(xpath = "//div[text()='Advanced Guides']/../..//li/a")
	private List<WebElement> btnAdvancedSubElements;

	@FindBy(xpath = "//div[text()='Tutorial']/../..//ul//a")
	private List<WebElement> txtRightNavigationMenu;
	
	@FindBy(xpath = "//div[text()='Tutorial']/../..//ul//a/span")
	private WebElement txtRightNavigationBlueLine;

	public void clickDocsTab() {
		click(btnDocsTab, "click on docs tab");
	}

	public void clickMainConcepts() {
		click(btnMainConcept, "Click on main concepts");
		getDataAndWriteToFile(btnMainSubElements, "Main_concepts");
	}

	public void clickAdvanceGuides() {
		click(btnAdvancedGuides, "Click on advance guides");
		getDataAndWriteToFile(btnAdvancedSubElements, "Advanced_guides");
	}

	public void getDataAndWriteToFile(List<WebElement> ele, String tabName) {
		try {
			File dest = new File(System.getProperty("user.dir") + File.separatorChar + "dataFromUI" + File.separatorChar
					+ tabName + ".txt");
			if (dest.exists()) {
				dest.delete();
			} else {
				dest.getParentFile().mkdir();
				dest.createNewFile();
			}
			FileWriter writer = new FileWriter(dest);
			BufferedWriter bufferedWriter = new BufferedWriter(writer);
			for (WebElement e : ele) {
				bufferedWriter.append(e.getText());
				bufferedWriter.newLine();
			}
			bufferedWriter.flush();
			bufferedWriter.close();
			System.out.println("data from main concept written to file : " + dest.getPath() + " successfully");
			logger("data from main concept written to file : " + dest.getPath() + " successfully");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void scrollTutorialPage() {
		int i = 800;
		SoftAssert softAssert = new SoftAssert(); 
		if (waitForElementToDisplay(txtRightNavigationMenu, 20)) {
			JavascriptExecutor executor = (JavascriptExecutor) getDriver();
			for (WebElement e : txtRightNavigationMenu) {
				// verify each element in navigation bar is changing as per the scroll action
				// done by user.
				while (!checkAttribute(e, "class", "css-1xy1fx4")) {
					executor.executeScript("window.scroll(0," + i + ")", "");
					i += 50;
				}
				String color = txtRightNavigationBlueLine.getCssValue("border-left-color");
				String asHex = Color.fromString(color).asRgb();
				System.out.println(asHex);
				if(!asHex.equals("rgb(97, 218, 251)") && Integer.parseInt(e.getCssValue("font-weight"))<700) {
					logger("color of the line in navigation is not blue and the letters are not bold");
					softAssert.assertEquals(true, false);
				}
				addScreenShotToReport("taking screenshot of navigation bar for element : <b>" + e.getText() + "</b>");
			}
		}
	}

	public boolean checkAttribute(WebElement e, String attribute, String value) {
		try {
			WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(1));
			Boolean until = wait.until(ExpectedConditions.attributeToBe(e, attribute, value));
			return until;
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			return false;
		}
	}

	public void clickTutorialTab() {
		click(btnTutorialTab, "click on tutorials tab");
	}

}
