package com.ui.pages;

public class PageObjectFactory {
	
	private LaunchApp app=null;
	private ReactJsPage react=null;
	
	public LaunchApp getApp() {
		if(app==null) {
			app=new LaunchApp();
		}
		return app;
	}
	
	public ReactJsPage getReact() {
		if(react==null) {
			react=new ReactJsPage();
		}
		return react;
	}
	
	
	

}
