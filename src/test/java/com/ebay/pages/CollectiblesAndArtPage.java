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

public class CollectiblesAndArtPage extends BaseClass {

	public CollectiblesAndArtPage() throws IOException {
		super();
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//li[@class='hl-cat-nav__js-tab']/a[text()='Collectibles and Art']")
	WebElement lnkCollectbleAndArt;

	@FindBy(css = ".hl-cat-nav__js-link[href='https://www.ebay.com/b/TV-Movie-Character-Toys/2624/bn_1865498']")
	WebElement lnkMoviesAndTv;

	@FindBy(xpath = "//section[@class='b-module b-carousel b-guidance b-display--landscape']//li[1]//a[1]")
	WebElement lnkPokeman;

	@FindBy(xpath = "//section[@class='b-module b-carousel b-guidance b-display--landscape']//li[4]")
	WebElement lnkBurgerKing;

	@FindBy(xpath = "//ul[@class='b-list__items_nofooter srp-results srp-grid']//li[1]")
	WebElement lnkSpiderMan;

	public void goToCollectiblesAndArts() {
		Actions act = new Actions(driver);
		act.moveToElement(lnkCollectbleAndArt).build().perform();
		lnkMoviesAndTv.click();
	}

	public boolean validateCartoonActionsFigure() {
		return driver.getCurrentUrl().contains("b/Cartoon-Action-Figures");

	}

	public void clickOnPokemon() {
		lnkPokeman.click();
	}

	public boolean validatePokemonCartoonAndTVCharacterActionsFigures() {
		return driver.getCurrentUrl().contains("Pokemon-Cartoon-TV-Character-Action-Figures");

	}

	public void clickOnBurgerKing() {
		lnkBurgerKing.click();
	}

	public boolean validateBurgerKingPokemonCartoonAndTVCharacterActionsFigures() {
		return driver.getCurrentUrl().contains("Burger-King-Pokemon-Cartoon-TV-Character-Action");

	}

	public void clickOnSpiderMan() {
		lnkSpiderMan.click();
		Set<String> allWindows = driver.getWindowHandles();
		List<String> hList = new ArrayList<String>(allWindows);
		switchToRightWindow("item40464f8962", hList);
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
