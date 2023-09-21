package com.ebay.tests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.ebay.genericPage.BaseClass;
import com.ebay.pages.SignInPage;
import com.ebay.utilities.XLUtils;

public class SignInTest_DDT extends BaseClass {

	SignInPage sign;

	public SignInTest_DDT() throws IOException {
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

	@Test(priority = 2, dataProvider = "LoginData")
	public void testSignIn(String user, String pwd) {
		Logger.info("Enter the username");
		sign.enterUserName(user);
		Logger.info("click on continue button");
		Logger.info("Enter the password");
		sign.enterPassword(pwd);
		Logger.info("click on show password check box");
		Logger.info("click on sign in button");
	}

	@Test(priority = 3)
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

	@DataProvider(name = "LoginData")
	String[][] getData() throws Exception {
		String path = System.getProperty("user.dir") + "/src/test/java/com/ebay/TestData/LoginDataebay.xlsx";
		int rownum = XLUtils.getRowCount(path, "Sheet1");
		int colcount = XLUtils.getCellCount(path, "Sheet1", 1);
		String logindata[][] = new String[rownum][colcount];
		for (int i = 1; i < rownum; i++) {
			for (int j = 0; j < colcount; j++) {
				logindata[i - 1][j] = XLUtils.getCellData(path, "Sheet1", i, j);
			}
		}
		return logindata;
	}

}
