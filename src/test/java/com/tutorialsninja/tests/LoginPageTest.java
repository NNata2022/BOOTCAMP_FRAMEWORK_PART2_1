package com.tutorialsninja.tests;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.tutorialsninja.dataProviders.ExcelCode;
import com.tutorialsninja.pages.AccountPage;
import com.tutorialsninja.pages.HomePage;
import com.tutorialsninja.pages.LoginPage;
import com.tutorialsninja.testBase.TestBase;
import com.tutorialsninja.utils.Util;

public class LoginPageTest extends TestBase { 
	public LoginPageTest() throws Exception {
		super();
		//to have asses for constructor of parent class
		
	}
	
	public WebDriver driver;
	public LoginPage loginpage;
	public HomePage homepage;
	public AccountPage accountpage;
	
	
	@BeforeMethod
	public void setUp() {
		driver = initalizeBrowserAndOpenApplication(prop.getProperty("browser"));
		//driver.findElement(By.linkText("My Account")).click();
		homepage = new HomePage(driver);
		homepage.clickOnMyAccountDropMenu();
		loginpage = homepage.selectLoginOption();//there system will be redirecter to loginpage
		//driver.findElement(By.linkText("Login")).click();
		
	}
	
	@Test(priority = 1, dataProvider = "TNLogin", dataProviderClass = ExcelCode.class)
	public void verifyLoginWithValidCredentials(String username, String password) {
		
		accountpage = loginpage.navigateToLoginPage(username, password);
//		loginpage.enterEmailAddress(username);
//		//driver.findElement(By.id("input-email")).sendKeys(username);
//		loginpage.enterPassword(password);
		//driver.findElement(By.id("input-password")).sendKeys(password);
		//Object accountpage = loginpage.clickOnloginButton();//system will be redirected to account page
		//driver.findElement(By.cssSelector("input.btn-primary")).click();
		//Assert.assertTrue(driver.findElement(By.linkText("Edit your account information")).isDisplayed());
		//AccountPage accountpage = new AccountPage(driver);
	    Assert.assertTrue(accountpage.getDisplayStatusOfEditAccountInfo());  	
	
	}
	
	@Test(priority = 2)
	public void VerifyLoginWithInvalidEmailValidPassword() {
		
		loginpage.navigateToLoginPage(Util.emailWithDateTimeStamp(), prop.getProperty("validPassword"));
//		loginpage.enterEmailAddress(Util.emailWithTheTimeStamp());
//		driver.findElement(By.id("input-email")).sendKeys(Util.emailWithTheTimeStamp());
//	    loginpage.enterPassword(prop.getProperty("validPassword"));
//		driver.findElement(By.id("input-password")).sendKeys(prop.getProperty("validPassword"));
	    //loginpage.clickOnloginButton();
		//driver.findElement(By.cssSelector("input.btn-primary")).click();
	    //String actualWarningMessage = loginpage.retrieveEmailPasswordNotMatchingWarningText();
	   // String expectedWarningMessage = dataProp.getProperty("emailPasswordNoMatchWarningMessage");
		//String actualWarningMessage = driver.findElement(By.xpath("//div[contains(@class, 'alert-dismissible')]")).getText();
		Assert.assertTrue(loginpage.retrieveEmailPasswordNotMatchingWarningText().contains(dataProp.getProperty("emailPasswordNoMatchWarningMessage")));
		
	}
	
	
	@Test(priority = 3)
	public void VerifyLoginWithValidEmailValidInvalidPassword() {
		loginpage.navigateToLoginPage(prop.getProperty("validEmail"), dataProp.getProperty("invalidPassword"));
//		loginpage.enterEmailAddress(prop.getProperty("validEmail"));
//		loginpage.enterPassword(dataProp.getProperty("invalidPassword"));
//		loginpage.clickOnloginButton();
//		driver.findElement(By.id("input-email")).sendKeys("seleniumpanda@gmail.com");
//		driver.findElement(By.id("input-password")).sendKeys(dataProp.getProperty("invalidPassword"));
//		driver.findElement(By.cssSelector("input.btn-primary")).click();
		//String expectedWarningMessage = dataProp.getProperty("emailPasswordNoMatchWarningMessage");
		//String actualWarningMessage = driver.findElement(By.xpath("//div[contains(@class, 'alert-dismissible')]")).getText();
		//String actualWarningMessage = loginpage.retrieveEmailPasswordNotMatchingWarningText();
		Assert.assertTrue(loginpage.retrieveEmailPasswordNotMatchingWarningText().contains(dataProp.getProperty("emailPasswordNoMatchWarningMessage")));
		
		
	}
	
	@Test(priority = 4)
	public void VerifyLoginWithInValidCredentials() {
		loginpage.navigateToLoginPage(Util.emailWithDateTimeStamp(), dataProp.getProperty("invalidPassword"));
		//loginpage.enterEmailAddress(Util.emailWithTheTimeStamp());
		//loginpage.enterPassword(dataProp.getProperty("invalidPassword"));
		//driver.findElement(By.id("input-email")).sendKeys(Util.emailWithTheTimeStamp());
		//driver.findElement(By.id("input-password")).sendKeys(dataProp.getProperty("invalidPassword"));
		//driver.findElement(By.cssSelector("input.btn-primary")).click();
		//loginpage.clickOnloginButton();
//		String expectedWarningMessage = dataProp.getProperty("emailPasswordNoMatchWarningMessage");
//		String actualWarningMessage = loginpage.retrieveEmailPasswordNotMatchingWarningText();
		//String actualWarningMessage = driver.findElement(By.xpath("//div[contains(@class, 'alert-dismissible')]")).getText();
		Assert.assertTrue(loginpage.retrieveEmailPasswordNotMatchingWarningText().contains(dataProp.getProperty("emailPasswordNoMatchWarningMessage")));
		
		
	}
	@Test(priority = 5)
	public void VerifyLoginWithNoCredentials() {
		
		//driver.findElement(By.cssSelector("input.btn-primary")).click();
		loginpage.clickOnLoginButton();
		//String expectedWarningMessage = "Warning: No match for E-Mail Address and/or Password.";
//		String expectedWarningMessage = dataProp.getProperty("emailPasswordNoMatchWarningMessage");
//		String actualWarningMessage = loginpage.retrieveEmailPasswordNotMatchingWarningText();
		//String actualWarningMessage = driver.findElement(By.xpath("//div[contains(@class, 'alert-dismissible')]")).getText();
		Assert.assertTrue(loginpage.retrieveEmailPasswordNotMatchingWarningText().contains(dataProp.getProperty("emailPasswordNoMatchWarningMessage")));
		
		
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
}
