package com.ebay.pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ebay.genericPage.BaseClass;

public class RegisterPage extends BaseClass {

	public RegisterPage() throws IOException {
		super();
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//span[@id='gh-ug']//a[text()='register']")
	WebElement lnkRegister;

	@FindBy(id = "personalaccount-radio")
	WebElement radioPersonal;

	@FindBy(id = "firstname")
	WebElement txtFirstName;

	@FindBy(id = "lastname")
	WebElement txtLastName;

	@FindBy(id = "Email")
	WebElement txtEmail;

	@FindBy(id = "password")
	WebElement txtPassword;

	@FindBy(id = "EMAIL_REG_FORM_SUBMIT")
	WebElement btnRegister;

	public void clickOnRegisterLink() {
		lnkRegister.click();
	}

	public void fillRegistrationDetails(String fname, String lname, String email, String password) {

		radioPersonal.click();
		txtFirstName.sendKeys(fname);
		txtLastName.sendKeys(lname);
		txtEmail.sendKeys(email);
		txtPassword.sendKeys(password);
		btnRegister.click();
	}

}
