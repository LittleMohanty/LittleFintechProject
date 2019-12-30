package com.java.testcase;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import com.java.utilities.GenericMethod;
import com.java.utilities.Readconfig;

public class BaseClass {
	public static WebDriver driver;
	public static Readconfig config=new Readconfig();
	public GenericMethod convert=new GenericMethod();

    
	@BeforeClass
	public void setUp(){
		System.setProperty("webdriver.chrome.driver", config.Chrome());
		 driver=new ChromeDriver();
		 driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		 driver.manage().window().maximize();
	}
	@AfterClass
	public void tearDown(){
		driver.quit();
	}
}
