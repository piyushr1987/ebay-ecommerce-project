package com.ebay.pages;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ebay.genericPage.BaseClass;

public class ElectronicsPage extends BaseClass {

	public ElectronicsPage() throws IOException {
		super();
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[contains(text(),'Electronics')]//parent::li[@class='hl-cat-nav__js-tab']")
	WebElement lnkElectronics;

	@FindBy(xpath = "//a[text()='Smartphones and accessories']")
	WebElement lnkSmartphones;

	@FindBy(xpath = "//div[@class='b-visualnav__grid']//a//div[@class='b-visualnav__img b-visualnav__img__default']")
	List<WebElement> allSmartPhones;

	public void moveToElectronics() throws InterruptedException {
		Actions act = new Actions(driver);
		act.moveToElement(lnkElectronics).build().perform();
		Thread.sleep(3000);
		act.moveToElement(lnkSmartphones).build().perform();
		Thread.sleep(3000);
		lnkSmartphones.click();

	}

	public void clickOnSmartPhone() {
		String expPhoneName = "Unlocked Smartphones";
		for (int i = 0; i < allSmartPhones.size(); i++) {
			if (allSmartPhones.get(i).getText().equalsIgnoreCase(expPhoneName)) {
				allSmartPhones.get(i).click();
				break;
			}
		}
	}

	public boolean validatePagenavigation() {
		return driver.getCurrentUrl().contains("Unlocked");

	}

}
