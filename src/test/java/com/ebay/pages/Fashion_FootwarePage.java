package com.ebay.pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ebay.genericPage.BaseClass;

public class Fashion_FootwarePage extends BaseClass {

	public Fashion_FootwarePage() throws IOException {
		super();
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//div[@class='hl-cat-nav']//li[@class='hl-cat-nav__js-tab']//a[text()='Fashion']")
	WebElement lnkFashion;

	@FindBy(xpath = "//div[@class='hl-cat-nav']//li[@class='hl-cat-nav__js-tab']//a[text()='Footwear']")
	WebElement lnkFootware;

	@FindBy(xpath = "//section[2]//div[2]//a[1]")
	WebElement lnkWomenBoots;

	@FindBy(xpath = "//section[@class='b-module b-carousel b-guidance b-display--landscape']//div[2]//li[1]")
	WebElement lstBlackBoots;

	@FindBy(xpath = "//div[@class='carousel__viewport carousel__viewport--mask']//li[1]//a[1]")
	WebElement lstBlackBootsSize;

	@FindBy(xpath = "//ul[@class='b-list__items_nofooter srp-results srp-grid']//li[28]")
	WebElement lstCostlyShoe;

	public void goToFashionTab() {
		Actions act = new Actions(driver);
		act.moveToElement(lnkFashion).build().perform();
		lnkFootware.click();
	}

	public boolean validateShoesPage() {
		return driver.getCurrentUrl().contains("bn_7000259122");
	}

	public void clickOnWomenBoot() {
		lnkWomenBoots.click();
	}

	public boolean validateWomenBootPage() {
		return driver.getCurrentUrl().contains("bn_738870");
	}

	public void clickOnWomenBootColor() {
		lstBlackBoots.click();
	}

	public boolean validateWomenBlackBootPage() {
		return driver.getCurrentUrl().contains("bn_711704");
	}

	public void clickOnWomenBlackBootSize() {
		lstBlackBootsSize.click();
	}

	public boolean validateBootsPage() {
		return driver.getCurrentUrl().contains("%2520Size=8");
	}

	public void clickOnCostlyShoe() {
		lstCostlyShoe.click();
	}
}
