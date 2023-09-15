package com.ebay.pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ebay.genericPage.BaseClass;

public class SignInPage extends BaseClass {

	public SignInPage() throws IOException {
		super();
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//span[@id='gh-ug']//a[text()='Sign in']")
	WebElement lnkSignIn;

	@FindBy(id = "userid")
	WebElement txtUserName;

	@FindBy(id = "signin-continue-btn")
	WebElement btnContinue;

	@FindBy(id = "pass")
	WebElement txtPassword;

	@FindBy(id = "show-password-checkbox")
	WebElement chkShowPassword;

	@FindBy(id = "sgnBt")
	WebElement btnSignIn;

	@FindBy(xpath = "//button[@id='gh-ug']")
	WebElement btnUser;

	public void clickOnSignIn() {
		lnkSignIn.click();
	}

	public void enterUserName(String uname) {
		txtUserName.sendKeys(uname);
		btnContinue.click();

	}

	public void enterPassword(String pass) {
		txtPassword.sendKeys(pass);
		chkShowPassword.click();
		btnSignIn.click();
	}

	public boolean validUserDisplayOrNot() {
		return btnUser.isDisplayed();

	}

}
