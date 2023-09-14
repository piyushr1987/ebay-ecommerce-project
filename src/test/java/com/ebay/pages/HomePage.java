package com.ebay.pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.ebay.genericPage.BaseClass;

public class HomePage extends BaseClass {

	public HomePage() throws IOException {
		super();
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//span[@id='gh-ug']//a[text()='Sign in']")
	WebElement lnkSignIn;

	@FindBy(xpath = "//span[@id='gh-ug']//a[text()='register']")
	WebElement lnkRegister;

	@FindBy(xpath = "//input[@name='_nkw']")
	WebElement txtSearchBox;

	@FindBy(xpath = "//select[@id='gh-cat']")
	WebElement drpCategories;

	@FindBy(id = "gh-btn")
	WebElement btnSearch;

	@FindBy(xpath = "//a[text()=' Daily Deals']")
	WebElement lnkDailyDeals;

	@FindBy(xpath = "//a[text()=' Help & Contact']")
	WebElement lnkHelpAndContact;

	public boolean validateSignInLink() {
		return lnkSignIn.isDisplayed();

	}

	public boolean validateRegisterLink() {
		return lnkRegister.isDisplayed();

	}

	public void enterValueInSearchBox(String text, String value) {
		txtSearchBox.sendKeys(text);
		Select sel = new Select(drpCategories);
		sel.selectByVisibleText(value);
		btnSearch.click();
	}

	public boolean validateDailyDealsLink() {
		return lnkDailyDeals.isDisplayed();

	}

	public boolean validateHelpAndContactLink() {
		return lnkHelpAndContact.isDisplayed();

	}

	public boolean validatePageNavigation() {
		return driver.getCurrentUrl().contains("sam");

	}

}
