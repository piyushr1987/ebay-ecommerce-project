package com.ebay.tests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.ebay.genericPage.BaseClass;
import com.ebay.pages.IndustrialEquipmentPage;

public class IndustrialEquipmentTest extends BaseClass {

	IndustrialEquipmentPage industry;

	public IndustrialEquipmentTest() throws IOException {
		super();
	}

	@BeforeTest
	public void setUp() throws IOException {
		intialization();
		industry = new IndustrialEquipmentPage();

	}

	@Test(priority = 1)
	public void testSports() throws InterruptedException {
		Logger.info("Move to industrial equipment and then click on restaurent and food services");
		industry.goToIndustrialEquipment();

	}

	@Test(priority = 2)
	public void testRestaurantAndFoodServicePage() throws Exception {
		if (industry.validateRestaurantAndFoodServicePage()) {
			Assert.assertTrue(true);
			Logger.info("sucessfully navigate to the restaurent and food service page");
		} else {
			captureScreen(driver, "food services page");
			Assert.assertTrue(false);
			Logger.info("validation test failed");
		}
	}

	@Test(priority = 3)
	public void testRefrigator() {
		industry.clickOnRefrigator();
	}

	@Test(priority = 4)
	public void testCommercialRefrigatorEquipmentPagePage() throws Exception {
		if (industry.validateCommercialRefrigatorEquipmentPage()) {
			Assert.assertTrue(true);
			Logger.info("sucessfully navigate to the Commercial Refrigator Equipment Page");
		} else {
			captureScreen(driver, "commercial refrigator page");
			Assert.assertTrue(false);
			Logger.info("validation test failed");
		}
	}

	@Test(priority = 5)
	public void testIceCreamEquiment() {
		industry.clickOnIceCreamEquiment();
	}

	@Test(priority = 6)
	public void testCommercialIceCreamEquipmentPage() throws Exception {
		if (industry.validateCommercialIceCreamEquipmentPage()) {
			Assert.assertTrue(true);
			Logger.info("sucessfully navigate to the Commercial IceCream Equipment Page");
		} else {
			captureScreen(driver, "ice cream equipment page");
			Assert.assertTrue(false);
			Logger.info("validation test failed");
		}
	}

	@Test(priority = 7)
	public void testCostlyMachine() {
		industry.clickOnCostlyMachine();
	}

	@Test(priority = 8)
	public void testBuyNow() {
		industry.clickOnBuyNow();
	}

	@Test(priority = 9)
	public void testCheckOutButton() throws Exception {
		if (industry.validatePayementPage()) {
			Assert.assertTrue(true);
			Logger.info("sucesfully navigate to payment page");
		} else {
			captureScreen(driver, "payment page");
			Assert.assertTrue(false);
			Logger.info("validation test failed");
		}
	}

	@AfterTest
	public void tearDown() {
		driver.quit();
	}

}
