package com.ebay.tests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.ebay.genericPage.BaseClass;
import com.ebay.pages.ElectronicsPage;

public class ElectronicsTest extends BaseClass {

	ElectronicsPage electro;

	public ElectronicsTest() throws IOException {
		super();

	}

	@BeforeTest
	public void setUp() throws IOException {
		intialization();
		electro = new ElectronicsPage();

	}

	@Test(priority = 1)
	public void testElectronics() throws InterruptedException {
		Logger.info("Move to electronics link and then click on smartphone");
		electro.moveToElectronics();
	}

	@Test(priority = 2)
	public void testClickOnSmartphone() throws InterruptedException {
		Logger.info("click on IPhone");
		electro.clickOnSmartPhone();
	}

	@Test(priority = 3)
	public void testPageNavigation() throws Exception {
		if (electro.validatePagenavigation()) {
			Assert.assertTrue(true);
			Logger.info("sucessfully navigate to the page");
		} else {
			captureScreen(driver, "pageNavigation");
			Assert.assertTrue(false);
			Logger.info("validation test failed");
		}
	}

	@AfterTest
	public void tearDown() {
		driver.close();
	}

}
