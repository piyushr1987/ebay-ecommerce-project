package com.ebay.pages;

import java.io.IOException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ebay.genericPage.BaseClass;

public class SportsPage extends BaseClass {

	public SportsPage() throws IOException {
		super();
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//ul[@class='hl-cat-nav__container']//li[@class='hl-cat-nav__js-tab']/a[text()='Sports']")
	WebElement lnkSports;

	@FindBy(css = ".hl-cat-nav__js-link[href='https://www.ebay.com/b/Team-Sports/159049/bn_1865097']")
	WebElement lnkTeamSports;

	@FindBy(xpath = "//section[contains(@class,'b-module b-carousel b-g')]//li[2]")
	WebElement lstAdidasBrand;

	@FindBy(xpath = "//section[contains(@class,'b-module b-c')]//li[3]")
	WebElement lstGoalNet;

	@FindBy(xpath = "//section[@class='c']//li[@class='s-item s-item--large']/parent::ul/child::li[2]")
	WebElement lstSoccerGoalNet;

	@FindBy(xpath = "//div[@id='CenterPanel']//ul//div[@data-testid='x-atc-action']")
	WebElement btnAddToCart;

	@FindBy(id = "sbtBtn")
	WebElement btnCheckOut;

	public void goToSports() {
		Actions act = new Actions(driver);
		act.moveToElement(lnkSports).build().perform();
		lnkTeamSports.click();
	}

	public boolean validateTeamSportPage() {
		return driver.getCurrentUrl().contains("b/Team-Sports");

	}

	public void clickOnAdidas() {
		lstAdidasBrand.click();
	}

	public boolean validateAdidasTeamSportPage() {
		return driver.getCurrentUrl().contains("Soccer-Equipment");

	}

	public void clickOnGoalAndNet() {
		lstGoalNet.click();
	}

	public boolean validateSoccerGoalNetPage() {
		return driver.getCurrentUrl().contains("Soccer-Goals-Nets");

	}

	public void clickOnSoccerNet() {
		lstSoccerGoalNet.click();
		// logic
	}

	public void clickOnAddToCart() {
		btnAddToCart.click();
	}

}
