package com.java.testcase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.java.pageobject.AmazonSearch;
import com.java.pageobject.FlipkartSearch;

public class PriceComparisonTest extends BaseClass {
 
	private static String amazonURL=config.getAmazonApplicationUrl();
	private static String flipkartURL=config.getFlipkartApplicationUrl();
	private static int iPhoneAmazonPrice,iPhoneFlipkartPrice;
	private static String  searchItem="iPhone XR (64GB) - Yellow";
	
	
	@Test(priority=1)
	public void amazonSearchTest() throws InterruptedException{
		driver.get(amazonURL);
		AmazonSearch amazon= new AmazonSearch(driver);
		amazon.sendSearchParameter(searchItem);
		amazon.clickSearchButton();
		
		Thread.sleep(2000);
		System.out.println(amazon.getItemPrice());
		iPhoneAmazonPrice= convert.conversion(amazon.getItemPrice());
		System.out.println("Amazon item price:"+iPhoneAmazonPrice);
	
	}
	@Test(priority=2)
	public void flipkartSearchTest() throws InterruptedException{
		driver.get(flipkartURL);
		FlipkartSearch filpkart=new FlipkartSearch(driver);
		filpkart.closeLogInPopUp();
		filpkart.sendSearchParameter(searchItem);
		filpkart.clickSearchButton();
		Thread.sleep(2000);
		System.out.println(filpkart.getItemPrice());
		iPhoneFlipkartPrice = convert.conversion(filpkart.getItemPrice());
		System.out.println("Flipkart item price:"+iPhoneFlipkartPrice);
		
	}
	@Test(priority=3)
	public void priceComparisionTest(){
		if(iPhoneAmazonPrice<iPhoneFlipkartPrice){
			System.out.println("Amazon price is "+iPhoneAmazonPrice+" less than flipkart price i.e "+iPhoneFlipkartPrice);
		}else{
			System.out.println("Amazon price is "+iPhoneAmazonPrice+" greater than flipkart price i.e "+iPhoneFlipkartPrice);
		}
	}
	
}
