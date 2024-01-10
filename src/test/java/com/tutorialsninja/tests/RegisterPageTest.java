package com.tutorialsninja.tests;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.tutorialsninja.pages.AccountSuccessPage;
import com.tutorialsninja.pages.HomePage;
import com.tutorialsninja.pages.RegisterPage;
import com.tutorialsninja.testBase.TestBase;
import com.tutorialsninja.utils.Util;



public class RegisterPageTest extends TestBase {

public RegisterPageTest() throws Exception {
		super();
	}
		
		public WebDriver driver;
		public HomePage homepage;
		public RegisterPage registerpage;
		public AccountSuccessPage accountSuccessPage;
		
		@BeforeMethod
		public void setup() {
			driver = initalizeBrowserAndOpenApplication(prop.getProperty("browser"));
			homepage = new HomePage(driver);
			homepage.clickOnMyAccountDropMenu();
			homepage.selectRegisterOption();
			
			registerpage = homepage.selectRegisterOption();//system will be redirected to registerpage
			
			//homepage.selectRegisterOption();
			//driver.findElement(By.linkText("My Account")).click();
			//driver.findElement(By.linkText("Register")).click();
		}
		
		@Test(priority=1)
		public void verifyingRegisterWithMandatoryFields() {
			accountSuccessPage = registerpage.registerPageMandatoryDetails(dataProp.getProperty("firstName"),
					dataProp.getProperty("lastName"), Util.emailWithDateTimeStamp(), 
					dataProp.getProperty("mobile"), prop.getProperty("validPassword"),
					prop.getProperty("validPassword"));
			//registerpage = new RegisterPage(driver);
//			registerpage.enterFirstName(dataProp.getProperty("firstName"));
//			//driver.findElement(By.xpath("//fieldset[@id = 'account']/descendant::input[@name = 'firstname']")).sendKeys(dataProp.getProperty("firstName"));
//			registerpage.enterLastName(dataProp.getProperty("lastName"));
//			//driver.findElement(By.xpath("//fieldset[@id = 'account']/descendant::input[@name = 'lastname']")).sendKeys(dataProp.getProperty("lastName"));
//			registerpage.enterEmail(Util.emailWithTheTimeStamp());
//			//driver.findElement(By.xpath("//fieldset[@id = 'account']/descendant::input[@name = 'email']")).sendKeys(Util.emailWithTheTimeStamp());
//			registerpage.enterTelephone(dataProp.getProperty("mobile"));
//			//driver.findElement(By.xpath("//aside[@id = 'column-right']/preceding::input[@id = 'input-telephone']")).sendKeys(dataProp.getProperty("mobile"));
//			registerpage.enterPassword(prop.getProperty("validPassword"));
//			//driver.findElement(By.xpath("//input[@name = 'telephone']/following::input[@name = 'password']")).sendKeys(prop.getProperty("validPassword"));
//			registerpage.enterConfirmPassword(prop.getProperty("validPassword"));
//			//driver.findElement(By.xpath("//input[@name = 'telephone']/following::input[@name = 'confirm']")).sendKeys(prop.getProperty("validPassword"));
//			registerpage.clickOnPrivacyPolicyCheckBox();
			//driver.findElement(By.xpath("//div[@class = 'pull-right']/child::a[1]/following-sibling::input[@name = 'agree']")).click();
			//accountSuccessPage = registerpage.clickOnContinueButton();//system will redirect you to account sucsses page
			//driver.findElement(By.xpath("//div[@class = 'pull-right']/descendant::input[@class = 'btn btn-primary']")).click();
			//accountsuccesspage = new AccountSuccesPage(driver);
			//String expectedSuccesMessage = dataProp.getProperty("accountSuccessMessage");
			//String actualSuccesMessage = accountSuccessPage.retrieveAccountSuccessMessage();
			//String actualSuccesMessage = driver.findElement(By.xpath("//p[contains(text(),'Congratulations! Your new account has been successfully created!')]")).getText();;
			Assert.assertEquals(accountSuccessPage.retrieveAccountSuccessMessage(), dataProp.getProperty("accountSuccessMessage"));
			
		}
		
		@Test(priority=2)
		public void verifyingRegisterWithAllFields() throws Exception {
			accountSuccessPage = registerpage.registerPageAllDetails(dataProp.getProperty("firstName"), dataProp.getProperty("lastName"),
					Util.emailWithDateTimeStamp(), dataProp.getProperty("mobile"), prop.getProperty("validPassword"), prop.getProperty("validPassword"));
//			registerpage = new RegisterPage(driver);
//			registerpage.enterFirstName(dataProp.getProperty("firstName"));
//			registerpage.enterLastName(dataProp.getProperty("lastName"));
//			registerpage.enterEmail(Util.emailWithTheTimeStamp());
//			registerpage.enterTelephone(dataProp.getProperty("mobile"));
//			registerpage.enterPassword(prop.getProperty("validPassword"));
//			registerpage.enterConfirmPassword(prop.getProperty("validPassword"));
//			registerpage.clickOnNewsLetterYesOptionRadioButton();
//			registerpage.clickOnPrivacyPolicyCheckBox();
//			registerpage.clickOnContinueButton();
			//driver.findElement(By.xpath("//fieldset[@id = 'account']/descendant::input[@name = 'firstname']")).sendKeys(dataProp.getProperty("firstName"));
			//driver.findElement(By.xpath("//fieldset[@id = 'account']/descendant::input[@name = 'lastname']")).sendKeys(dataProp.getProperty("lastName"));
			//driver.findElement(By.xpath("//fieldset[@id = 'account']/descendant::input[@name = 'email']")).sendKeys(Util.emailWithTheTimeStamp());
			//driver.findElement(By.xpath("//aside[@id = 'column-right']/preceding::input[@id = 'input-telephone']")).sendKeys(dataProp.getProperty("mobile"));
			//driver.findElement(By.xpath("//input[@name = 'telephone']/following::input[@name = 'password']")).sendKeys(prop.getProperty("validPassword"));
//			driver.findElement(By.xpath("//input[@name = 'telephone']/following::input[@name = 'confirm']")).sendKeys(prop.getProperty("validPassword"));
//			driver.findElement(By.xpath("//aside[@id = 'column-right']/preceding::input[@name = 'newsletter' and @value = '1']")).click();
//			driver.findElement(By.xpath("//div[@class = 'pull-right']/child::a[1]/following-sibling::input[@name = 'agree']")).click();
//			driver.findElement(By.xpath("//div[@class = 'pull-right']/descendant::input[@class = 'btn btn-primary']")).click();
//			Thread.sleep(2000);
			//accountSuccessPage = new AccountSuccesPage(driver);
//			String expectedSuccesMessage = dataProp.getProperty("accountSuccessMessage");
//			String actualSuccesMessage = accountSuccessPage.retrieveAccountSuccessMessage();
			//String actualSuccesMessage = driver.findElement(By.xpath("//p[contains(text(),'Congratulations! Your new account has been successfully created!')]")).getText();;
			Assert.assertEquals(accountSuccessPage.retrieveAccountSuccessMessage(), dataProp.getProperty("accountSuccessMessage"));
		}
		
		@Test(priority=3)
		public void verifyingRegisterWithExistingEmail() {
			accountSuccessPage = registerpage.registerPageAllDetails(dataProp.getProperty("firstName"), dataProp.getProperty("lastName"),
					prop.getProperty("validEmail"), dataProp.getProperty("mobile"), prop.getProperty("validPassword"),
					prop.getProperty("validPassword"));
			//registerpage = new RegisterPage(driver);
//			registerpage.enterFirstName(dataProp.getProperty("firstName"));
//			registerpage.enterLastName(dataProp.getProperty("lastName"));
//			registerpage.enterEmail(prop.getProperty("validEmail"));
//			registerpage.enterTelephone(dataProp.getProperty("mobile"));
//			registerpage.enterPassword(prop.getProperty("validPassword"));
//			registerpage.enterConfirmPassword(prop.getProperty("validPassword"));
//			registerpage.clickOnNewsLetterYesOptionRadioButton();
//			registerpage.clickOnPrivacyPolicyCheckBox();
//			registerpage.clickOnContinueButton();
			
//			driver.findElement(By.xpath("//fieldset[@id = 'account']/descendant::input[@name = 'firstname']")).sendKeys(dataProp.getProperty("firstName"));
//			driver.findElement(By.xpath("//fieldset[@id = 'account']/descendant::input[@name = 'lastname']")).sendKeys(dataProp.getProperty("lastName"));
//			driver.findElement(By.xpath("//fieldset[@id = 'account']/descendant::input[@name = 'email']")).sendKeys(prop.getProperty("validEmail"));
//			driver.findElement(By.xpath("//aside[@id = 'column-right']/preceding::input[@id = 'input-telephone']")).sendKeys(dataProp.getProperty("mobile"));
//			driver.findElement(By.xpath("//input[@name = 'telephone']/following::input[@name = 'password']")).sendKeys(prop.getProperty("validPassword"));
//			driver.findElement(By.xpath("//input[@name = 'telephone']/following::input[@name = 'confirm']")).sendKeys(prop.getProperty("validPassword"));
//			driver.findElement(By.xpath("//aside[@id = 'column-right']/preceding::input[@name = 'newsletter' and @value = '1']")).click();
//			driver.findElement(By.xpath("//div[@class = 'pull-right']/child::a[1]/following-sibling::input[@name = 'agree']")).click();
//			driver.findElement(By.xpath("//div[@class = 'pull-right']/descendant::input[@class = 'btn btn-primary']")).click();
//			String actualDuplicateWarningMessage = registerpage.retrieveDuplicateEmailWarning();
//			//String actualDuplicateWarningMessage = driver.findElement(By.xpath("//div[contains(@class, 'alert-dismissible')]")).getText();
//			String expectedDuplicateWarningMessage = dataProp.getProperty("duplicateEmailWarningMessage");
			Assert.assertTrue(registerpage.retrieveDuplicateEmailWarning().contains(dataProp.getProperty("duplicateEmailWarningMessage")));
				
		}
		
		@Test(priority = 4)
		public void veryfingRegisterWithMismatchPassword() {
			registerpage.registerPageAllDetails(dataProp.getProperty("firstName"), dataProp.getProperty("lastName"), 
					prop.getProperty("validEmail"), dataProp.getProperty("mobile"),
			prop.getProperty("validPassword"), prop.getProperty("invalidPassword"));
			
//			registerpage = new RegisterPage(driver);
//			registerpage.enterFirstName(dataProp.getProperty("firstName"));
//			registerpage.enterLastName(dataProp.getProperty("lastName"));
//			registerpage.enterEmail(prop.getProperty(prop.getProperty("validEmail")));
//			registerpage.enterTelephone(dataProp.getProperty("mobile"));
//			registerpage.enterPassword(prop.getProperty("validPassword"));
//			registerpage.enterConfirmPassword(prop.getProperty("invalidPassword"));
//			registerpage.clickOnNewsLetterYesOptionRadioButton();
//			registerpage.clickOnPrivacyPolicyCheckBox();
//			registerpage.clickOnContinueButton();driver.findElement(By.xpath("//fieldset[@id = 'account']/descendant::input[@name = 'firstname']")).sendKeys(dataProp.getProperty("firstName"));
//			driver.findElement(By.xpath("//fieldset[@id = 'account']/descendant::input[@name = 'lastname']")).sendKeys(dataProp.getProperty("lastName"));
//			driver.findElement(By.xpath("//fieldset[@id = 'account']/descendant::input[@name = 'email']")).sendKeys(Util.emailWithTheTimeStamp());
//			driver.findElement(By.xpath("//aside[@id = 'column-right']/preceding::input[@id = 'input-telephone']")).sendKeys("9876543210");
//			driver.findElement(By.xpath("//input[@name = 'telephone']/following::input[@name = 'password']")).sendKeys(prop.getProperty("validPassword"));
//			driver.findElement(By.xpath("//input[@name = 'telephone']/following::input[@name = 'confirm']")).sendKeys(prop.getProperty("invalidPassword"));
//			driver.findElement(By.xpath("//div[@class = 'pull-right']/child::a[1]/following-sibling::input[@name = 'agree']")).click();
//			driver.findElement(By.xpath("//div[@class = 'pull-right']/descendant::input[@class = 'btn btn-primary']")).click();
			//String actualPasswordMissmatchWarningMessage = driver.findElement(By.xpath("//input[@id = 'input-confirm']/following-sibling::div")).getText();
//			String actualPasswordMissmatchWarningMessage = registerpage.retrievePasswordMismatchWarning();
//			String expectedPasswordMissmatchWarningMessage = dataProp.getProperty("passwordMismatchWarningMessage");
			Assert.assertTrue(registerpage.retrievePasswordMismatchWarning().contains(dataProp.getProperty("passwordMismatchWarningMessage")));
		}
		
		@Test(priority=5)
		public void verifyingRegisterWithNoFields() {
			//registerpage = new RegisterPage(driver);
			registerpage.clickOnContinueButton();
			Assert.assertTrue(
			        registerpage.retrieveAllWarningMessageStatus(
			            dataProp.getProperty("privacyPolicyWarningMessage"),
			            dataProp.getProperty("firstNameWarningMessage"),
			            dataProp.getProperty("lastNameWarningMessage"),
			            dataProp.getProperty("emailWarningMessage"),
			            dataProp.getProperty("telephoneWarningMessage"),
			            dataProp.getProperty("passwordWarningMessage")));
			//driver.findElement(By.xpath("//div[@class = 'pull-right']/descendant::input[@class = 'btn btn-primary']")).click();
			//String actualPrivacyPolicyWarningMessage = registerpage.retrievePrivacyPolicyWarning();
			//String actualPrivacyPolicyWarningMessage = driver.findElement(By.xpath("//div[contains(@class, 'alert-dismissible')]")).getText();
			//String expectedPrivacyPolicyWarningMessage = "Warning: You must agree to the Privacy Policy!";
//			Assert.assertTrue(registerpage.retrievePrivacyPolicyWarning().contains(dataProp.getProperty("privacyPolicyWarningMessage")));
////			String actualFirstNameWarningMessage = registerpage.retrieveFirstNameWarning();
////			//String actualFirstNameWarningMessage = driver.findElement(By.xpath("//input[@id = 'input-firstname']/following-sibling::div[1]")).getText();
////			String expectedFirstNameWarningMessage = "First Name must be between 1 and 32 characters!";
//			Assert.assertTrue(registerpage.retrieveFirstNameWarning().contains(dataProp.getProperty("firstNameWarningMessage")));
//			//String actualLastNameWarningMessage = registerpage.retrieveLastNameWarning();
//			//String actualLastNameWarningMessage = driver.findElement(By.xpath("//input[@id = 'input-lastname']/following-sibling::div[1]")).getText();
//			//String expectedLastNameWarningMessage = "Last Name must be between 1 and 32 characters!";
//			Assert.assertTrue(registerpage.retrieveLastNameWarning().contains(dataProp.getProperty("lastNameWarningMessage")));
//			//String actualEmailWarningMessage = registerpage.retrieveEmailWarning();
//			//String actualEmailWarningMessage = driver.findElement(By.xpath("//input[@id = 'input-email']/following-sibling::div[1]")).getText();
//			//String expectedEmailWarningMessage = "E-Mail Address does not appear to be valid!";
//			Assert.assertTrue(registerpage.retrieveEmailWarning().contains(dataProp.getProperty("emailWarningMessage")));
//			//String actualTelephoneWarningMessage = registerpage.retrieveTelephoneWarning();
//			//String actualTelephoneWarningMessage = driver.findElement(By.xpath("//input[@id = 'input-telephone']/following-sibling::div[1]")).getText();
//			//String expectedTelephoneWarningMessage = "Telephone must be between 3 and 32 characters!";
//			Assert.assertTrue(registerpage.retrieveTelephoneWarning().contains(dataProp.getProperty("telephoneWarningMessage")));
//			//String actualPasswordWarningMessage = registerpage.retrievePasswordWarning();
//			//String actualPasswordWarningMessage = driver.findElement(By.xpath("//input[@id = 'input-password']/following-sibling::div[1]")).getText();
//			//String expectedPasswordWarningMessage = "Password must be between 4 and 20 characters!";
//			Assert.assertTrue(registerpage.retrievePasswordWarning().contains(dataProp.getProperty("passwordWarningMessage")));
//			
		}
		
		@AfterMethod
		public void tearDown() {
			driver.quit();
		}
}
