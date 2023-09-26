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

public class IndustrialEquipmentPage extends BaseClass {

	public IndustrialEquipmentPage() throws IOException {
		super();
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//*[@class='hl-cat-nav']/ul/li[9]")
	WebElement lnkIndustrialEquipment;

	@FindBy(xpath = "//*[contains(text(),'Rest')]/parent::li/parent::ul/child::li[4]")
	WebElement lnkRestaurent;

	@FindBy(xpath = "//*[contains(text(),'Refr')]/parent::li/parent::ul/child::li[7]")
	WebElement lnkRefrigator;

	@FindBy(xpath = "//*[contains(@class,'b-module b-carousel b-guidance b-di')]//li[4]")
	WebElement lstIceCream;

	@FindBy(xpath = "//section[contains(@class,'b-module b-list b-l')]/ul/li[3]")
	WebElement lstCostlyMachine;

	@FindBy(xpath = "//div[@class='vim vi-evo-row-gap']//li[2]")
	WebElement btnAddToCart;

	@FindBy(id = "sbtBtn")
	WebElement btnCheckOut;

	public void goToIndustrialEquipment() {
		Actions act = new Actions(driver);
		act.moveToElement(lnkIndustrialEquipment).build().perform();
		lnkRestaurent.click();
	}

	public boolean validateRestaurantAndFoodServicePage() {
		return driver.getCurrentUrl().contains("Restaurant-Food-Service");

	}

	public void clickOnRefrigator() {
		lnkRefrigator.click();
	}

	public boolean validateCommercialRefrigatorEquipmentPage() {
		return driver.getCurrentUrl().contains("Commercial-Refrigeration-Equipment");

	}

	public void clickOnIceCreamEquiment() {
		lstIceCream.click();
	}

	public boolean validateCommercialIceCreamEquipmentPage() {
		return driver.getCurrentUrl().contains("Commercial-Ice-Cream-Equipment");

	}

	public void clickOnCostlyMachine() {
		lstCostlyMachine.click();
		Set<String> allWindows = driver.getWindowHandles();
		List<String> hList = new ArrayList<String>(allWindows);
		switchToRightWindow(prop.getProperty("titleRes"), hList);
	}

	public void clickOnBuyNow() {
		btnAddToCart.click();
	}

	public boolean validatePayementPage() {
		return driver.getCurrentUrl().contains("reg/Upgrade?ru");

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
