package com.tutorialsninja.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.tutorialsninja.pages.HomePage;
import com.tutorialsninja.pages.ProductInfoPage;
import com.tutorialsninja.pages.SearchPage;
import com.tutorialsninja.testBase.TestBase;

public class CompleteCheckoutPageTest extends TestBase{
public CompleteCheckoutPageTest() throws Exception {
		super();
	}

public WebDriver driver;
	
	@BeforeMethod
	public void setup() {
		driver = initalizeBrowserAndOpenApplication(prop.getProperty("browser"));
	}
	
	@Test(priority=1)
	public void checkingOutValidProduct() throws Exception {
		HomePage homepage = new HomePage(driver);
		homepage.enterProductDetail(dataProp.getProperty("validProduct"));
		SearchPage searchpage = homepage.clickOnSearchIcon();
		Assert.assertTrue(searchpage.verifyDisplayStatusOfValidProduct());
		ProductInfoPage productinfopage = searchpage.clickOnAddToCartButton(); // system is re-directed to ProductInfoPage
		Thread.sleep(3000);
		Assert.assertTrue(productinfopage.validateDisplayStatusProdInfo());
	
		driver.findElement(By.xpath("//button[@id = 'button-cart']")).click();
		String expectedMessage = dataProp.getProperty("productAddedSuccessfullyToCartMessage");
		Thread.sleep(3000);
		String actualMessage = driver.findElement(By.xpath("//div[contains(@class, 'alert-dismissible')]")).getText();
		Assert.assertTrue(actualMessage.contains(expectedMessage));
		driver.findElement(By.xpath("//div[@id = 'cart']")).click();
		Thread.sleep(3000);
		driver.findElement(By.linkText("Checkout")).click();
		
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
