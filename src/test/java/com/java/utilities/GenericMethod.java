package com.java.utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GenericMethod {
	
	public int conversion(String value){
		value=value.replace(",", "");
		value=value.replace("₹", "");
		int i=Integer.valueOf(value);
		return i;  
	}
	public static void explicitWait(WebElement element,WebDriver driver){
		WebDriverWait wait=new WebDriverWait(driver,20);
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	
}

