package com.ebay.tests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.*;

import com.ebay.genericPage.BaseClass;
import com.ebay.pages.HomePage;

public class HomeTest extends BaseClass {
	HomePage home;

	public HomeTest() throws IOException {
		super();

	}

	@BeforeTest
	public void setUp() throws IOException {
		intialization();
		home = new HomePage();

	}

	@Test(priority = 1)
	public void testSignInLink() throws Exception {
		Logger.info("URL is opened");
		if (home.validateSignInLink()) {
			Assert.assertTrue(true);
			Logger.info("SignIn link is displayed");
		} else {
			captureScreen(driver, "SignIn");
			Assert.assertTrue(false);
			Logger.info("SignIn link is not displayed");
		}
	}

	@Test(priority = 2)
	public void testRegisterLink() throws Exception {
		if (home.validateRegisterLink()) {
			Assert.assertTrue(true);
			Logger.info("Register link is displayed");
		} else {
			captureScreen(driver, "Register");
			Assert.assertTrue(false);
			Logger.info("Register link is not displayed");
		}

	}

	@Test(priority = 3)
	public void testDailyDealsLink() throws Exception {
		if (home.validateDailyDealsLink()) {
			Assert.assertTrue(true);
			Logger.info("Daily deals link is displayed");
		} else {
			captureScreen(driver, "Daily Deals");
			Assert.assertTrue(false);
			Logger.info("Daily deals link is not displayed");
		}
	}

	@Test(priority = 4)
	public void testHelpAndContactLink() throws Exception {
		if (home.validateHelpAndContactLink()) {
			Assert.assertTrue(true);
			Logger.info("Help and contact link is displayed");
		} else {
			captureScreen(driver, "Help and Contact");
			Assert.assertTrue(false);
			Logger.info("Help and conatct link is not displayed");
		}
	}

	@Test(priority = 5)
	public void testSearchBox() {
		Logger.info("enter the value in search box and choose category");
		home.enterValueInSearchBox(prop.getProperty("search"), prop.getProperty("category"));
	}

	@Test(priority = 6)
	public void testPageNavigation() throws Exception {
		if (home.validatePageNavigation()) {
			Assert.assertTrue(true);
			Logger.info("sucessfully navigate to the page");
		} else {
			captureScreen(driver, "page");
			Assert.assertTrue(false);
			Logger.info("navigate to the page is failed");
		}
	}

	@AfterTest
	public void tearDown() {
		driver.close();
	}

}
