package com.ebay.tests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.ebay.genericPage.BaseClass;
import com.ebay.pages.SportsPage;

public class SportsTest extends BaseClass {

	SportsPage sport;

	public SportsTest() throws IOException {
		super();

	}

	@BeforeTest
	public void setUp() throws IOException {
		intialization();
		sport = new SportsPage();

	}

	@Test(priority = 1)
	public void testSports() throws InterruptedException {
		Logger.info("Move to sports and then click on team sports");
		sport.goToSports();

	}

	@Test(priority = 2)
	public void testTeamSportPage() throws Exception {
		if (sport.validateTeamSportPage()) {
			Assert.assertTrue(true);
			Logger.info("sucessfully navigate to the team sport page");
		} else {
			captureScreen(driver, "Team sport page");
			Assert.assertTrue(false);
			Logger.info("validation test failed");
		}
	}

	@Test(priority = 3)
	public void testAdidas() {
		sport.clickOnAdidas();
	}

	@Test(priority = 4)
	public void testAdidasTeamSportPage() throws Exception {
		if (sport.validateAdidasTeamSportPage()) {
			Assert.assertTrue(true);
			Logger.info("sucessfully navigate to the adidas team sport page");
		} else {
			captureScreen(driver, "Adidas Team sport page");
			Assert.assertTrue(false);
			Logger.info("validation test failed");
		}
	}

	@Test(priority = 5)
	public void testGoalAndNet() {
		sport.clickOnGoalAndNet();
	}

	@Test(priority = 6)
	public void testSoccerNet() {
		sport.clickOnSoccerNet();
	}

	@Test(priority = 7)
	public void testAddToCart() {
		sport.clickOnAddToCart();
	}
	
	@AfterTest
	public void tearDown() {
		driver.close();
	}

}
