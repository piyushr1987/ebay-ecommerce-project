package com.ebay.tests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.ebay.genericPage.BaseClass;
import com.ebay.pages.RegisterPage;

public class RegisterTest extends BaseClass {
	RegisterPage register;

	public RegisterTest() throws IOException {
		super();

	}

	@BeforeTest
	public void setUp() throws IOException {
		intialization();
		register = new RegisterPage();

	}

	@Test(priority = 1)
	public void testRegisterPage() throws Exception {
		Logger.info("URL is opened");
		register.clickOnRegisterLink();
		if (driver.getTitle().equals("Register: Create a business account")) {
			Assert.assertTrue(true);
			Logger.info("sucessfully navigate to registration page");
		} else {
			captureScreen(driver, "Register");
			Assert.assertTrue(false);
			Logger.info("Registration test is failed");
		}
	}

	@Test(priority = 2)
	public void fillCustomerDetails() {
		Logger.info("Enter customer details");
		register.fillRegistrationDetails(prop.getProperty("FirstName"), prop.getProperty("LastName"),
				prop.getProperty("Email"), prop.getProperty("Password"));
		Logger.info(" Susessfully enter customer details");
	}

	@AfterTest
	public void tearDown() {
		driver.close();
	}

}
