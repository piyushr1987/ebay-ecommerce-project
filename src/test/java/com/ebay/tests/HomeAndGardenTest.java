package com.ebay.tests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.ebay.genericPage.BaseClass;
import com.ebay.pages.HomeAndGardenPage;

public class HomeAndGardenTest extends BaseClass {
	HomeAndGardenPage home;

	public HomeAndGardenTest() throws IOException {
		super();

	}

	@BeforeTest
	public void setUp() throws IOException {
		intialization();
		home = new HomeAndGardenPage();

	}

	@Test(priority = 1)
	public void testHomeAndGarden() throws InterruptedException {
		Logger.info("Move to home and garden and then click light,fan and bulbs");
		home.goToHomeAndGarden();

	}

	@Test(priority = 2)
	public void testLampAndFanPage() throws Exception {
		if (home.validateLampsAndFanPage()) {
			Assert.assertTrue(true);
			Logger.info("sucessfully navigate to the lamp and fan page");
		} else {
			captureScreen(driver, "lamp page");
			Assert.assertTrue(false);
			Logger.info("validation test failed");
		}
	}

	@Test(priority = 3)
	public void testLightBulb() {
		home.clickOnLightBulb();
	}

	@Test(priority = 4)
	public void testLightBulbsPage() throws Exception {
		if (home.validateLightBulbsPage()) {
			Assert.assertTrue(true);
			Logger.info("sucessfully navigate to the light and bulb page");
		} else {
			captureScreen(driver, "bulb page");
			Assert.assertTrue(false);
			Logger.info("validation test failed");
		}
	}

	@Test(priority = 5)
	public void testFeitElectricLightBulb() {
		home.clickOnFeitElectricLightBulb();
	}

	@Test(priority = 6)
	public void testLEDTubeBulb() {
		home.clickOnLEDTubeBulb();
	}

	@Test(priority = 7)
	public void testFeitElectricLightBulbsPage() throws Exception {
		if (home.validateLEDTubeBulbPage()) {
			Assert.assertTrue(true);
			Logger.info("sucessfully navigate to the LED tube bulb page");
		} else {
			captureScreen(driver, "feit bulb page");
			Assert.assertTrue(false);
			Logger.info("validation test failed");
		}
	}

	@Test(priority = 8)
	public void testNextButton() {
		home.clickOnNextButton();
	}

	@Test(priority = 9)
	public void testBuyItNowButton() {
		home.clickOnBuyItNow();
	}

	//@Test(priority = 10)
	public void testcheckOutButton() throws Exception {
		if (home.validateCheckOutButton()) {
			Assert.assertTrue(true);
			Logger.info("check out button is displayed");
		} else {
			captureScreen(driver, "check out button");
			Assert.assertTrue(false);
			Logger.info("validation test failed");
		}
	}

	@AfterTest
	public void tearDown() {
		driver.quit();
	}

}
