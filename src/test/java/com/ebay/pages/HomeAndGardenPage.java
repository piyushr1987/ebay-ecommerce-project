package com.ebay.pages;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ebay.genericPage.BaseClass;

public class HomeAndGardenPage extends BaseClass {

	public HomeAndGardenPage() throws IOException {
		super();
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//*[contains(@class,'hl-cat-nav__c')]/li[10]")
	WebElement lnkHomeAndGarden;

	@FindBy(xpath = "//*[contains(text(),'Home im')]/parent::li/parent::ul/child::li[5]")
	WebElement lnkLampAndFan;

	@FindBy(xpath = "//*[contains(@class,'b-module b-carousel b-guidance ')]//li[4]")
	WebElement lstLightBulb;

	@FindBy(xpath = "//section[contains(@class,'b-module b-carousel b-guidance ')]//li[3]")
	WebElement lstFeitLightBulb;
	
	@FindBy(xpath = "//section[contains(@class,'b-module b-list b-l')]//li[@class='s-item s-item--large']/parent::ul/child::li[1]")
	WebElement lstLEDTubeBulb;

	@FindBy(xpath = "//div[@class='ux-image-carousel-container']//button[contains(@class,'btn-n')]")
	WebElement btnNext;

	@FindBy(xpath = "//a[contains(@id,'bin')]")
	WebElement btnBuyItNow;

	@FindBy(id = "sbtBtn")
	WebElement btnCheckOut;

	public void goToHomeAndGarden() {
		Actions act = new Actions(driver);
		act.moveToElement(lnkHomeAndGarden).build().perform();
		lnkLampAndFan.click();
	}

	public boolean validateLampsAndFanPage() {
		return driver.getCurrentUrl().contains("Lamps-Lighting-Ceiling-Fans");

	}

	public void clickOnLightBulb() {
		lstLightBulb.click();
	}

	public boolean validateLightBulbsPage() {
		return driver.getCurrentUrl().contains("Light-Bulbs");

	}

	public void clickOnFeitElectricLightBulb() {
		lstFeitLightBulb.click();
	}
	
	public void clickOnLEDTubeBulb() {
		lstLEDTubeBulb.click();
		Set<String> allWindows = driver.getWindowHandles();
		List<String> hList = new ArrayList<String>(allWindows);
		switchToRightWindow(prop.getProperty("titleHome"), hList);
	}

	public boolean validateLEDTubeBulbPage() {
		return driver.getCurrentUrl().contains("itm/113193616957");

	}

	public void clickOnNextButton() {
		btnNext.click();
	}

	public void clickOnBuyItNow() {
		btnBuyItNow.click();
	}

	public boolean validateCheckOutButton() {
		return btnCheckOut.isDisplayed();

	}
	
	public static boolean switchToRightWindow(String windowTitle, List<String> hList) {

		for (String e : hList) {
			String title = driver.switchTo().window(e).getTitle();
			if (title.contains(windowTitle)) {
				System.out.println("found the right window");
				return true;
			}
		}
		return false;
	}

}
