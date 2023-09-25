package com.ebay.tests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.ebay.genericPage.BaseClass;
import com.ebay.pages.HealthAndBeautyPage;

public class HealthAndBeautyTest extends BaseClass {

	HealthAndBeautyPage health;

	public HealthAndBeautyTest() throws IOException {
		super();
	}

	@BeforeTest
	public void setUp() throws IOException {
		intialization();
		health = new HealthAndBeautyPage();

	}

	@Test(priority = 1)
	public void testSports() throws InterruptedException {
		Logger.info("Move to health and beauty and then click on K-bueaty");
		health.goToHealthAndbeauty();

	}

	@Test(priority = 2)
	public void testTeamSportPage() throws Exception {
		if (health.validateKoreanBeautyPage()) {
			Assert.assertTrue(true);
			Logger.info("sucessfully navigate to the korean beauty page");
		} else {
			captureScreen(driver, "Korean beauty page");
			Assert.assertTrue(false);
			Logger.info("validation test failed");
		}
	}

	@Test(priority = 3)
	public void testLipBalm() {
		health.clickOnLipBalm();
	}

	@Test(priority = 4)
	public void testLipBalmAndTratementPage() throws Exception {
		if (health.validateLipBalmAndTratmentPage()) {
			Assert.assertTrue(true);
			Logger.info("sucessfully navigate to the korean lip balm and treatement page");
		} else {
			captureScreen(driver, "Korean lip balm page");
			Assert.assertTrue(false);
			Logger.info("validation test failed");
		}
	}

	@Test(priority = 5)
	public void testExpensiveLipBalm() {
		health.clickOnExpensiveLipBalm();
	}

	@Test(priority = 6)
	public void testLipBalmItemPage() throws Exception {
		if (health.validateLipBalmItemPage()) {
			Assert.assertTrue(true);
			Logger.info("sucessfully navigate to the korean lip balm item page");
		} else {
			captureScreen(driver, "lip balm item page");
			Assert.assertTrue(false);
			Logger.info("validation test failed");
		}
	}

	@Test(priority = 7)
	public void testSelectQuanity() {
		health.selectQuality(prop.getProperty("quantity"));
	}

	@Test(priority = 8)
	public void testEntertQuanity() {
		health.enterQuantity(prop.getProperty("figure"));
	}

	@Test(priority = 9)
	public void testAddToWatchlist() {
		health.clickOnAddToWatchList();
	}

	@Test(priority = 10)
	public void testHelloText() throws Exception {
		if (health.validateHelloTitle()) {
			Assert.assertTrue(true);
			Logger.info("sucessfully displayed hello text");
		} else {
			captureScreen(driver, "text page");
			Assert.assertTrue(false);
			Logger.info("validation test failed");
		}
	}

	@AfterTest
	public void tearDown() {
		driver.quit();
	}

}
