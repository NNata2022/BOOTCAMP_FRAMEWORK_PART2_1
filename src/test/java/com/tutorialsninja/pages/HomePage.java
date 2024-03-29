package com.tutorialsninja.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	
	public WebDriver driver;
	//I will list down all the Objects that I see in this Webpage
	
	@FindBy(linkText = "My Account")
	private WebElement myAccountDropdown;
	
	
	@FindBy(linkText = "Login")
	private WebElement loginOption;
	
	
	@FindBy(linkText = "Register")
	private WebElement registerOption;
	
	
	@FindBy(name = "search")
	private WebElement searchTextBoxField;
	
	
	@FindBy(css = "button.btn.btn-default.btn-lg")
	private WebElement searchButton;
	
	//Need to initialize the Objects which I have defined above
	
	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		//PageFactory.initElements(driver, HomePage.class);	
	}
	
	//Actions for each WebElement
	
	
	public void clickOnMyAccountDropMenu() {
		myAccountDropdown.click();
	}
	
	public LoginPage selectLoginOption() {
		loginOption.click();
		return new LoginPage(driver);
	}
	
	public RegisterPage selectRegisterOption() {
		registerOption.click();
		return new RegisterPage(driver);
	}
	
	public void enterProductDetail(String productNameText) {
		searchTextBoxField.sendKeys(productNameText);
	}
	
	public SearchPage clickOnSearchIcon() {
		searchButton.click();
		return new SearchPage(driver);
	}

}
