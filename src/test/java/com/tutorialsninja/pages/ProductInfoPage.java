package com.tutorialsninja.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductInfoPage {
	
	public WebDriver driver;
	
	@FindBy(xpath = "//a[normalize-space()='Samsung Galaxy Tab 10.1']")
	private WebElement ProductCodeInfo;
	
	@FindBy(xpath = "//span[normalize-space()='Add to Cart']")
	private WebElement addToCartButtonInProductInfoPage;
	
	
	
	public ProductInfoPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void clickOnAddToCartButtonInProdInfo() {
		addToCartButtonInProductInfoPage.click();
	}
	
	public boolean validateDisplayStatusProdInfo() {
		boolean displayStatus = ProductCodeInfo.isDisplayed();
		return displayStatus;
	}

}
