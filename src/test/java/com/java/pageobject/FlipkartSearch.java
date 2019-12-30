package com.java.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FlipkartSearch {
	WebDriver driver;
	
@FindBy(xpath="//*[@class='_2AkmmA _29YdH8']")
private WebElement closePopUp;
@FindBy (xpath="//*[@type='text']")
private WebElement searchBox;
@FindBy(xpath="//*[@type='submit']")
private WebElement searchButton;
@FindBy(xpath="//*[@class='_1vC4OE _2rQ-NK']")
private WebElement price;

 public FlipkartSearch(WebDriver driver){
	this.driver=driver;
	PageFactory.initElements(this.driver,this );
}
public void closeLogInPopUp(){
	closePopUp.click();
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
