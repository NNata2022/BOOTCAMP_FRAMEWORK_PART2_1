package com.tutorialsninja.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.tutorialsninja.pages.HomePage;
import com.tutorialsninja.pages.SearchPage;
import com.tutorialsninja.testBase.TestBase;

public class SearchProductPageTest extends TestBase{
	public SearchProductPageTest() throws Exception {
		super();
	}


public WebDriver driver;
public HomePage homepage;
public SearchPage searchpage;
	
	@BeforeMethod
	public void registerSetup() {
		driver = initalizeBrowserAndOpenApplication(prop.getProperty("browser"));
		
	}
	
	
	@Test(priority=1)
	public void verifySearchWithValidProduct() {
		homepage = new HomePage(driver);
		homepage.enterProductDetail(dataProp.getProperty("validProduct"));
		searchpage = homepage.clickOnSearchIcon();//System will be re-directed to SearchPage
		//driver.findElement(By.name("search")).sendKeys("HP");
		//driver.findElement(By.cssSelector("button.btn.btn-default.btn-lg")).click();
		//SearchPage searchpage = new SearchPage(driver);
		//Assert.assertTrue(searchpage.verifyDisplayStatusOfInValidProduct()); //deliberate failure
		
		Assert.assertTrue(driver.findElement(By.xpath("//h2[normalize-space()='Products meeting the search criteria']")).isDisplayed());
	}
	
	@Test(priority=2)
	public void verifySearchWithInvalidProduct() {
		homepage = new HomePage(driver);
		searchpage = homepage.clickOnSearchIcon();
		homepage.enterProductDetail(dataProp.getProperty("invalidProduct"));
		//SearchPage searchpage = new SearchPage(driver);
		Assert.assertTrue(searchpage.verifyDisplayStatusOfInValidProduct());
//		driver.findElement(By.name("search")).sendKeys("DELL");
//		driver.findElement(By.cssSelector("button.btn.btn-default.btn-lg")).click();
//		Assert.assertTrue(driver.findElement(By.xpath("//p[text() = 'There is no product that matches the search criteria.']")).isDisplayed());
	}
	
	@Test(priority=3)
	public void verifySearchWithNoProduct() {
		
		homepage = new HomePage(driver);
		searchpage =  homepage.clickOnSearchIcon();
		//SearchPage searchpage = new SearchPage(driver);
		Assert.assertTrue(searchpage.verifyDisplayStatusOfInValidProduct());
		
	}
	
		//driver.findElement(By.cssSelector("button.btn.btn-default.btn-lg")).click();
		//Assert.assertTrue(driver.findElement(By.xpath("//p[text() = 'There is no product that matches the search criteria.']")).isDisplayed());
	
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
