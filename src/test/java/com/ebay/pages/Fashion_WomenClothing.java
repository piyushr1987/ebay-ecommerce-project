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

public class Fashion_WomenClothing extends BaseClass {

	public Fashion_WomenClothing() throws IOException {
		super();
		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "//li[@class='hl-cat-nav__js-tab']//a[contains(text(),'Fashion')]")
	WebElement lnkFashion;

	@FindBy(css = "li[class='hl-cat-nav__js-tab hl-cat-nav__js-show'] nav[aria-label='Most popular categories'] li:nth-child(2) a:nth-child(1)")
	WebElement lnkWomenClothing;

	@FindBy(xpath = "//section[@class='b-module b-carousel b-guidance b-display--landscape']//li[1]//a[1]")
	WebElement lnkTops;

	@FindBy(xpath = "//div[@class='s-item__info clearfix']//*[contains(text(),'Nurse Uniform Tunic Dentist Therapist Maid Nursing Healthcare Hospitality Carers')]")
	WebElement lstChampionTshirt;

	@FindBy(xpath = "//div[@class='x-ads-placements adp-vim vim x-ads-placements--101195']//li[1]")
	WebElement lstChampionLifeCropTshirt;

	public void goToFashionTab() {
		Actions act = new Actions(driver);
		act.moveToElement(lnkFashion).build().perform();
		lnkWomenClothing.click();
	}

	public boolean validateWomenClothingPage() {
		return driver.getTitle().contains("Womens-Clothing");

	}

	public void clickOnWomenTop() {
		lnkTops.click();
	}

	public boolean validateWomenTopPage() {
		return driver.getTitle().contains("Womens-Tops");

	}

	public void clickOnWomenChampionTshirt() {
		lstChampionTshirt.click();
		Set<String> allWindows = driver.getWindowHandles();
		List<String> hList = new ArrayList<String>(allWindows);
		switchToRightWindow("Nurse Uniform Tunic Dentist", hList);
	}

	public boolean validateWomenChampionTshirt() {
		return driver.getTitle().contains("itm/265065953193?hash");

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
