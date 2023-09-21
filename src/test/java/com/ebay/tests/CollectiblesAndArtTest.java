package com.ebay.tests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.ebay.genericPage.BaseClass;
import com.ebay.pages.CollectiblesAndArtPage;

public class CollectiblesAndArtTest extends BaseClass {

	CollectiblesAndArtPage collection;

	public CollectiblesAndArtTest() throws IOException {
		super();

	}

	@BeforeTest
	public void setUp() throws IOException {
		intialization();
		collection = new CollectiblesAndArtPage();

	}

	@Test(priority = 1)
	public void testFashionWomenClothing() throws InterruptedException {
		Logger.info("Move to Collectibles And Arts link and then click on movie and TV character");
		collection.goToCollectiblesAndArts();

	}

	@Test(priority = 2)
	public void testCartoonActionFigurePage() throws Exception {
		if (collection.validateCartoonActionsFigure()) {
			Assert.assertTrue(true);
			Logger.info("sucessfully navigate to the cartoon and action figure page");
		} else {
			captureScreen(driver, "cartoon page");
			Assert.assertTrue(false);
			Logger.info("validation test failed");
		}
	}

	@Test(priority = 3)
	public void testPokeman() {
		collection.clickOnPokemon();
	}

	@Test(priority = 4)
	public void testPokemonCartoonAndTVCharacterActionFigurePage() throws Exception {
		if (collection.validatePokemonCartoonAndTVCharacterActionsFigures()) {
			Assert.assertTrue(true);
			Logger.info("sucessfully navigate to the pokemon cartoon and TV character action figure page");
		} else {
			captureScreen(driver, "pokemon page");
			Assert.assertTrue(false);
			Logger.info("validation test failed");
		}
	}

	@Test(priority = 5)
	public void testBurgerKing() {
		collection.clickOnBurgerKing();
	}

	@Test(priority = 6)
	public void testBurgerKingPokemonCartoonAndTVCharacterActionFigurePage() throws Exception {
		if (collection.validateBurgerKingPokemonCartoonAndTVCharacterActionsFigures()) {
			Assert.assertTrue(true);
			Logger.info("sucessfully navigate to the burger king pokemon cartoon and TV character action figure page");
		} else {
			captureScreen(driver, "Burger king pokemon page");
			Assert.assertTrue(false);
			Logger.info("validation test failed");
		}
	}

	@Test(priority = 7)
	public void testSpiderman() {
		collection.clickOnSpiderMan();
	}

	@AfterTest
	public void tearDown() {
		driver.quit();
	}

}
