package com.ebay.tests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.ebay.genericPage.BaseClass;
import com.ebay.pages.Fashion_WomenClothing;

public class Fashion_WomenClothingTest extends BaseClass {

	Fashion_WomenClothing clothing;

	public Fashion_WomenClothingTest() throws IOException {
		super();

	}

	@BeforeTest
	public void setUp() throws IOException {
		intialization();
		clothing = new Fashion_WomenClothing();

	}

	@Test(priority = 1)
	public void testFashionWomenClothing() throws InterruptedException {
		Logger.info("Move to fashion link and then click on women clothing");
		clothing.goToFashionTab();

	}

	@Test(priority = 2)
	public void testWomenClothingPage() throws Exception {
		if (clothing.validateWomenClothingPage()) {
			Assert.assertTrue(true);
			Logger.info("sucessfully navigate to the women clothing page");
		} else {
			captureScreen(driver, "clothing page");
			Assert.assertTrue(false);
			Logger.info("validation test failed");
		}
	}

	@Test(priority = 3)
	public void testWomenTop() {
		clothing.clickOnWomenTop();
	}

	@Test(priority = 4)
	public void testWomenTopPage() throws Exception {
		if (clothing.validateWomenTopPage()) {
			Assert.assertTrue(true);
			Logger.info("sucessfully navigate to the women top page");
		} else {
			captureScreen(driver, "women top page");
			Assert.assertTrue(false);
			Logger.info("validation test failed");
		}
	}

	@Test(priority = 5)
	public void testWomenChampionShirt() {
		clothing.clickOnWomenChampionTshirt();

	}

	@Test(priority = 6)
	public void testWomenChampionTshirt() throws Exception {
		if (clothing.validateWomenChampionTshirt()) {
			Assert.assertTrue(true);
			Logger.info("sucessfully navigate to the women champion tshirt page");
		} else {
			captureScreen(driver, "women ctshirt page");
			Assert.assertTrue(false);
			Logger.info("validation test failed");
		}
	}

	@AfterTest
	public void tearDown() {
		driver.close();
	}

}
