package com.ui.pages;

import com.cucumber.testng.BaseClass;

public class LaunchApp extends BaseClass {
	
	public void launchApp(String url) {
		getUrl(url, "Chrome");
	}

}
