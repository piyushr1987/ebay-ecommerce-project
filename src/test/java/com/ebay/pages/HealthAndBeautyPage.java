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

public class HealthAndBeautyPage extends BaseClass {

	public HealthAndBeautyPage() throws IOException {
		super();
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//*[@id='mainContent']//ul//li[@class='hl-cat-nav__js-tab']/a[text()='Health & Beauty']")
	WebElement lnkHealthAndBeauty;

	@FindBy(xpath = "//div[@class='hl-cat-nav__sub-cats']//a[normalize-space()='K-Beauty']")
	WebElement lnkKbeauty;

	@FindBy(xpath = "//div[@id='mainContent']//div[@id='s0-28_1-9-0-1[0]-1-2-0']//li[2]")
	WebElement lstLipBalm;

	@FindBy(xpath = "//div[@id='mainContent']//li[@class='s-item s-item--large']/parent::ul/child::li[6]")
	WebElement lstExpensiveLipBalm;

	@FindBy(xpath = "//select[@id='x-msku__select-box-1000']/option")
	List<WebElement> drpMPN;

	@FindBy(id = "qtyTextBox")
	WebElement txtQuantity;

	@FindBy(xpath = "//div[@id='mainContent']//li[3]")
	WebElement lstAddToWatchlist;
	
	@FindBy(xpath = "//div[@class='id-first']/div[2]/h1")
	WebElement txtHello;

	public void goToHealthAndbeauty() {
		Actions act = new Actions(driver);
		act.moveToElement(lnkHealthAndBeauty).build().perform();
		lnkKbeauty.click();
	}

	public boolean validateKoreanBeautyPage() {
		return driver.getCurrentUrl().contains("Korean-Health-and-Beauty");

	}

	public void clickOnLipBalm() {
		lstLipBalm.click();
	}

	public boolean validateLipBalmAndTratmentPage() {
		return driver.getCurrentUrl().contains("Lip-Balm-Treatments");

	}

	public void clickOnExpensiveLipBalm() {
		lstExpensiveLipBalm.click();
		Set<String> allWindows = driver.getWindowHandles();
		List<String> hList = new ArrayList<String>(allWindows);
		switchToRightWindow(prop.getProperty("title"), hList);
	}
	
	public boolean validateLipBalmItemPage() {
		return driver.getCurrentUrl().contains("165979768674?hash=item26a52a4762");

	}

	public void selectQuality(String value) {
		for (int i = 0; i < drpMPN.size(); i++) {
			if (drpMPN.get(i).getText().equalsIgnoreCase(value)) {
				drpMPN.get(i).click();
			}
		}
	}
	
	public void enterQuantity(String num) {
		txtQuantity.clear();
		txtQuantity.sendKeys(num);
	}
	
	public void clickOnAddToWatchList() {
		lstAddToWatchlist.click();
	}
	
	public boolean validateHelloTitle() {
		return txtHello.isDisplayed();

	}
	
	public static boolean switchToRightWindow(String windowTitle, List<String> hList) 
	{
		
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
