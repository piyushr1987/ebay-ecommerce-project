package com.ebay.tests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.ebay.genericPage.BaseClass;
import com.ebay.pages.Fashion_FootwarePage;

public class Fashion_FootwareTest extends BaseClass {

	Fashion_FootwarePage footware;

	public Fashion_FootwareTest() throws IOException {
		super();

	}

	@BeforeTest
	public void setUp() throws IOException {
		intialization();
		footware = new Fashion_FootwarePage();

	}

	@Test(priority = 1)
	public void testFashion() throws InterruptedException {
		Logger.info("Move to fashion link and then click on footware");
		footware.goToFashionTab();

	}

	@Test(priority = 2)
	public void testShoePage() throws Exception {
		if (footware.validateShoesPage()) {
			Assert.assertTrue(true);
			Logger.info("sucessfully navigate to the shoe page");
		} else {
			captureScreen(driver, "shoe page");
			Assert.assertTrue(false);
			Logger.info("validation test failed");
		}
	}

	@Test(priority = 3)
	public void testWomenBoot() throws Exception {
		footware.clickOnWomenBoot();
		if (footware.validateWomenBootPage()) {
			Assert.assertTrue(true);
			Logger.info("sucessfully navigate to the women boot page");
		} else {
			captureScreen(driver, "women boot page");
			Assert.assertTrue(false);
			Logger.info("validation test failed");
		}
	}

	@Test(priority = 4)
	public void testWomenBootColor() throws Exception {
		footware.clickOnWomenBootColor();
		if (footware.validateWomenBlackBootPage()) {
			Assert.assertTrue(true);
			Logger.info("sucessfully navigate to the women black boot page");
		} else {
			captureScreen(driver, "women black boot page");
			Assert.assertTrue(false);
			Logger.info("validation test failed");
		}
	}

	@Test(priority = 5)
	public void testWomenBlackBootSize() throws Exception {
		footware.clickOnWomenBlackBootSize();
		if (footware.validateBootsPage()) {
			Assert.assertTrue(true);
			Logger.info("sucessfully navigate to the women boots page");
		} else {
			captureScreen(driver, "women boots page");
			Assert.assertTrue(false);
			Logger.info("validation test failed");
		}
	}

	@Test(priority = 6)
	public void testClickOnCostlyItem() {
		Logger.info("Sucessfully click on costly item");
		footware.clickOnCostlyShoe();
	}

	@AfterTest
	public void tearDown() {
		driver.close();
	}

}
