package com.alura.appium.PageObjects;

import io.appium.java_client.AppiumDriver;

public abstract class PageObjectBase {
	
	protected AppiumDriver driver;
	
	protected AppiumDriver PageObjectBase(AppiumDriver driver) {
		this.driver = driver;
		
		
		
		return this.driver;
		
	}
	
	public abstract void BuscarElementos();
	
	
	
}
 