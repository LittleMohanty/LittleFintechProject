package com.java.testcase;

import org.testng.annotations.Test;

import com.java.pageobject.TripAdvisorSearch;

public class TripAdvisorTest extends BaseClass {
	public String url=config.getTripadvisorUrl();
	public static TripAdvisorSearch trip;
	public static String searchParam="Club Mahindra";
	public String titleOfReview="Trip Advisor";
	public String reviewSection="Excellent service";
	
	
	
	@Test
	public void tripSearchTest() throws Exception{
		driver.get(url);
		trip = new TripAdvisorSearch(driver);
		searchAsPerPage();
		trip.switchToClubMahindra();
		Thread.sleep(2000);
		
		trip.clickWriteReview();
		trip.switchToWriteAReview();
		trip.titleOfReview(titleOfReview);
		trip.reviewSection(reviewSection);
		trip.selectCheckBox();	
		
	}


	private void searchAsPerPage() {
		if(trip.isSearchTextVisible()){
			trip.searchParis(searchParam);
		}else{
			trip.search(searchParam);
		}
	}
	

}
