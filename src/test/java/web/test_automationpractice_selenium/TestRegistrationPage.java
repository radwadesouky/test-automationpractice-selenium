package web.test_automationpractice_selenium;
import static org.testng.Assert.assertEquals;

import java.io.IOException;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import pages.RegistrationPage;
import testdata.ExcelReader;

public class TestRegistrationPage extends TestBase {

	HomePage homeObj;
	RegistrationPage registerObj;
	LoginPage loginObj;

	//This Test case to create a new user with valid values
	@Test(dataProvider="ValidData",enabled=false)
	public void testCreateUser(String EMail,String customerFirstName,String customerLastName,String pass,String Address,String City,String state,
			String newsletterChecker,String uniformoptinChecker,String code,String mobile)
	{
		homeObj = new HomePage(driver);
		homeObj.openSignInPage();
		registerObj = new RegistrationPage(driver);
		//Generate random e-mail for creating new users
		Random randomGenerator = new Random();  
		int randomInt = randomGenerator.nextInt(10000);  
		EMail = EMail+randomInt +"@gmail.com"; 
		//Navigate to registration page & set e-mail
		registerObj.openRegistrationPage(EMail);
		//Wait until registration page finishing loads
		WebDriverWait wait = new WebDriverWait(driver, 10);
		WebElement customerFirstNametxt = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("customer_firstname")));
		customerFirstNametxt.sendKeys(customerFirstName);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		//Scroll down 
		js.executeScript("window.scrollBy(0,450)", "");
		WebElement stateDropDownList = driver.findElement(By.id("id_state"));
		//Set information to create a new user using data from external file
		registerObj.registrationInfo(customerLastName, pass, Address, City,stateDropDownList,state,newsletterChecker,uniformoptinChecker,
				"12345","123456789");
		registerObj.logOut();
		loginObj = new LoginPage(driver);
		loginObj.login(EMail, pass);
	}

	//This Test case to create a new user with invalid values for zip code
	@Test(dataProvider="IncorrectZipCode",enabled=false)
	public void testRegisterWithInvalidData(String EMail,String customerFirstName,String customerLastName,String pass,String Address,String City,String state,
			String newsletterChecker,String uniformoptinChecker,String code,String mobile)
	{
		homeObj = new HomePage(driver);
		homeObj.openSignInPage();
		registerObj = new RegistrationPage(driver);
		//Generate random e-mail for creating new users
		Random randomGenerator = new Random();  
		int randomInt = randomGenerator.nextInt(1000);  
		EMail = EMail+randomInt +"@gmail.com"; 
		//Navigate to registration page & set e-mail
		registerObj.openRegistrationPage(EMail);
		//Wait until registration page finishing loads
		WebDriverWait wait = new WebDriverWait(driver, 10);
		WebElement customerFirstNametxt = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("customer_firstname")));
		customerFirstNametxt.sendKeys(customerFirstName);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		//Scroll down 
		js.executeScript("window.scrollBy(0,450)", "");
		WebElement stateDropDownList = driver.findElement(By.id("id_state"));
		//Set information to create a new user using data from external file
		registerObj.registrationInfo(customerLastName, pass, Address, City,stateDropDownList,state,newsletterChecker,uniformoptinChecker,"1","123456789");
		wait = new WebDriverWait(driver, 5);
		WebElement ErrorMsg = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"center_column\"]/div/ol/li"))); 
		//Validate that zip code error message appear
		assertEquals(ErrorMsg.getText(), "The Zip/Postal code you've entered is invalid. It must follow this format: 00000");
	}
	//This Test case to try to enter invalid e-mail format for create a new user
	@Test(dataProvider="IncorrectE-mail",enabled=false)
	public void testCreateUserWithInvalidEmail(String EMail)
	{
		homeObj = new HomePage(driver);
		homeObj.openSignInPage();
		registerObj = new RegistrationPage(driver);
		//Navigate to registration page & set e-mail
		registerObj.openRegistrationPage(EMail);
		WebDriverWait wait = new WebDriverWait(driver, 5);
		WebElement errorMsgInvalidEmail = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"create_account_error\"]/ol/li"))); 
		//Validate that the site will appear error message when entering invalid e-mail
		assertEquals(errorMsgInvalidEmail.getText(), "Invalid email address.");
	}

	//This Test case to try to register with email already exist before
	@Test(dataProvider="ExsistingE-mail",enabled=false)
	public void testCreateUserWithRegisteredEmail(String EMail)
	{
		homeObj = new HomePage(driver);
		homeObj.openSignInPage();
		registerObj = new RegistrationPage(driver);
		//Navigate to registration page & set e-mail
		registerObj.openRegistrationPage(EMail);
		WebDriverWait wait = new WebDriverWait(driver, 5);
		WebElement errorMsgRegisteredEmail = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"create_account_error\"]/ol/li"))); 
		//Validate that the site will appear error message when entering invalid e-mail
		assertEquals(errorMsgRegisteredEmail.getText(), "An account using this email address has already been registered. Please enter a valid password or request a new one. ");
	}

	@DataProvider(name = "IncorrectZipCode")
	public Object[][] createWithIncorrectZipCode() throws IOException
	{
		return new Object[][] 
				{
			{ "TestEmail","testname" ,"lastname","123456789","address","City","Alaska","True","False","1","12345678"},
			{ "TestEmail.com","testname" ,"lastname","123456789","address","City","Alaska","True","False","2354561","12345678"},
				};
	}
	@DataProvider(name = "IncorrectE-mail")
	public Object[][] createWithIncorrect() throws IOException
	{
		return new Object[][] 
				{
			{ "Test@gmail."},
			{ ""},
			{"Test@.com"}
				};
	}
	@DataProvider(name = "ExsistingE-mail")
	public Object[][] createWithExsistingEmail() throws IOException
	{
		return new Object[][] 
				{
			{ "test47@gmail.com"}
				};
	}
	@DataProvider(name = "ValidData")
	public Object[][] getRegistrationData() throws IOException
	{
		// Get data from excel reader
		ExcelReader data=new ExcelReader();
		return data.getExcelData();
	}

}
