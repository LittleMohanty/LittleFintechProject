package com.java.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AmazonSearch {
	WebDriver driver;
	
@FindBy (xpath="//*[@type='text']")
private WebElement searchBox;
@FindBy(xpath="//*[contains (@value,'Go')]")
private WebElement searchButton;
@FindBy(xpath="(//span[@class='a-price-whole'])[1]")
private WebElement price;

 public AmazonSearch(WebDriver driver){
	this.driver=driver;
	PageFactory.initElements(this.driver,this );
}

public void sendSearchParameter(String input){
	searchBox.sendKeys(input);
}
public void clickSearchButton(){
	searchButton.click();
}
public String getItemPrice (){
	
	return price.getText();
}


}


