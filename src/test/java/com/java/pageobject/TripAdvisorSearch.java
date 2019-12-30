package com.java.pageobject;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.java.utilities.GenericMethod;

public class TripAdvisorSearch {
	WebDriver driver;
	@FindBy(xpath="//div[@title='Search']")
	WebElement Searchbox;
	@FindBy(xpath="//input[@id='mainSearch']")
	WebElement nextsearch;
	
	@FindBy(xpath="//input[contains(@placeholder,'Paris')]")
	WebElement searchText;
	@FindBy(xpath="//button[@title='Search']")
	WebElement searchButton2;
	
    @FindBy(xpath="//*[@id='SEARCH_BUTTON_CONTENT']")
     WebElement searchbutton;
    
    
    @FindBy(xpath="(//div[@class='result-title']/span)[1]")
    WebElement hotel;
    @FindBy(xpath="//a[contains(text(),'Write a review')]")
    WebElement reviewbutton;
    @FindBy(xpath="//*[@id='bubble_rating' and @data-value='5']")
     WebElement reviewRate;
    @FindBy(xpath="//*[@id='ReviewTitle']")
    WebElement titleOfReview;
    @FindBy(xpath="//*[@id='ReviewText']")
    WebElement reviewSection;
    @FindBy(xpath="//*[@id='qid12_bubbles' and @data-value='5']")
    WebElement hotelService;
    @FindBy(xpath="//*[@id='qid190_bubbles' and @data-value='5']")
    WebElement sleepQuality;
    @FindBy(xpath="//*[@id='qid47_bubbles' and @data-value='5']")
    WebElement location;
    @FindBy(xpath="//*[@type='checkbox']")
    WebElement checkbox;
    
    
    public TripAdvisorSearch(WebDriver driver){
    	this.driver=driver;
    	PageFactory.initElements(this.driver, this);
    	
    }
    public void searchParis(String search){
    	searchText.click();
    	searchText.sendKeys(search);
    	searchButton2.click();    	
    }
    public void search(String search){
    	Searchbox.click();
    	nextsearch(search);
    	searchbutton();
    }
    
    public boolean isSearchTextVisible(){
    	try{
    		return searchText.isDisplayed();
    	}catch(Exception e){
    		return false;
    	}
    }
    public void nextsearch(String input){
    	nextsearch.sendKeys(input);
    }
    public void searchbutton(){
    	searchbutton.click();
    }
    
    public void switchToClubMahindra(){
    	Actions action=new Actions(driver);
    	String window=hotel.getText();
       action.moveToElement(hotel).click().build().perform();
       switchToWindow(window);
       
         
        }
        
    
    public void clickWriteReview() throws InterruptedException{
    	JavascriptExecutor js = (JavascriptExecutor) driver;
    	//js.executeScript("arguments[0].scrollIntoView();",reviewbutton );
    	
    	GenericMethod.explicitWait(reviewbutton, driver);
    	reviewbutton.click();
    	
    }
    public void switchToWindow(String title){
        Set<String>window=  driver.getWindowHandles();
        Iterator<String>it=window.iterator();
        while(it.hasNext()){
         String newWindow=it.next();
         driver.switchTo().window(newWindow);
         if(driver.getTitle().contains(title)){
        	 break;
         }
    }
}
    public void switchToWriteAReview(){
    	switchToWindow("Write a review");
    }
    public void overAllRate(){
    	Actions action=new Actions(driver);
    	action.moveToElement(reviewRate).click().build().perform();
    }
    public void titleOfReview(String Review){
    	titleOfReview.sendKeys(Review);
    }
    public void reviewSection(String comment){
    	reviewSection.sendKeys(comment);
    }
    public void hotelServiceRatting(){
    	JavascriptExecutor js = (JavascriptExecutor) driver;
    	js.executeScript("arguments[0].scrollIntoView();",hotelService );
    	Actions action=new Actions(driver);
    	action.moveToElement(hotelService).click().build().perform();
    }
    public void hotelSleepQualityRatting(){
    	JavascriptExecutor js = (JavascriptExecutor) driver;
    	js.executeScript("arguments[0].scrollIntoView();",sleepQuality );
    	Actions action=new Actions(driver);
    	action.moveToElement(sleepQuality).click().build().perform();
    }
    public void hotelLocationRating(){
    	JavascriptExecutor js = (JavascriptExecutor) driver;
    	js.executeScript("arguments[0].scrollIntoView();",location );
    	Actions action=new Actions(driver);
    	action.moveToElement(location).click().build().perform();
    }
    
  
    public void selectCheckBox(){
    	JavascriptExecutor js = (JavascriptExecutor) driver;
    	//js.executeScript("arguments[0].scrollIntoView();",checkbox );
    	GenericMethod.explicitWait(checkbox, driver);
    	checkbox.click();
    }
}
