package com.ebay.tests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.ebay.genericPage.BaseClass;
import com.ebay.pages.SignInPage;

public class SignInTest extends BaseClass {

	SignInPage sign;

	public SignInTest() throws IOException {
		super();

	}

	@BeforeTest
	public void setUp() throws IOException {
		intialization();
		sign = new SignInPage();

	}

	@Test(priority = 1)
	public void testSignInLink() {
		Logger.info("URL is opened");
		Logger.info("click on Sign In link");
		sign.clickOnSignIn();
	}

	@Test(priority = 2)
	public void testUsername() {
		Logger.info("Enter the username");
		sign.enterUserName(prop.getProperty("Email"));
		Logger.info("click on continue button");
	}

	@Test(priority = 3)
	public void testPassword() {
		Logger.info("Enter the password");
		sign.enterPassword(prop.getProperty("Password"));
		Logger.info("click on show password check box");
		Logger.info("click on sign in button");
	}

	@Test(priority = 4)
	public void testUserNameDisplayed() throws Exception {
		if (sign.validUserDisplayOrNot()) {
			Assert.assertTrue(true);
			Logger.info("user name is displayed");
		} else {
			captureScreen(driver, "user");
			Assert.assertTrue(false);
			Logger.info("user name is not displayed");
		}
	}

	@AfterTest
	public void tearDown() {
		driver.close();
	}

}
