package web.test_automationpractice_selenium;
import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.LoginPage;

public class TestLoginPage extends TestBase{
	HomePage homeObj;
	LoginPage loginObj;


	//This test case for login with valid values
	@Test(dataProvider="validData",enabled=true)
	public void testLogin(String eMail,String Passwrd) throws InterruptedException
	{
		homeObj = new HomePage(driver);
		homeObj.openSignInPage();
		loginObj = new LoginPage(driver);
		loginObj.login(eMail, Passwrd);
		WebDriverWait wait = new WebDriverWait(driver, 10);
		WebElement accountMsg = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"columns\"]/div[1]/span[2]"))); 
		//Validate that login is working successfully
		assertEquals(accountMsg.getText(), "My account");
	}
	//This test case for login without entering required values for (e-mail or password or both)
	@Test(dataProvider="EmptyData",enabled = false)
	public void testLoginWithEmptyData(String eMail,String Passwrd) throws InterruptedException
	{
		homeObj = new HomePage(driver);
		homeObj.openSignInPage();
		loginObj = new LoginPage(driver);
		loginObj.login(eMail, Passwrd);

		if(Passwrd.isEmpty() & eMail !="")
		{
			WebDriverWait wait = new WebDriverWait(driver, 5);
			WebElement errorMsgPassword = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"center_column\"]/div[1]/ol/li"))); 
			//Validate that Password value is required error message will appear
			assertEquals(errorMsgPassword.getText(), "Password is required.");
		}
		else
		{
			WebDriverWait wait = new WebDriverWait(driver, 5);
			WebElement errorMsgEmail = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"center_column\"]/div[1]/ol/li"))); 
			//Validate that E-mail value is required error message will appear
			assertEquals(errorMsgEmail.getText(), "An email address required.");
		}
	}

	//This test case for login with Incorrect Data for e-mail or password or both
	@Test(dataProvider="IncorrectData",enabled = false)
	public void testLoginWithIncorrectData(String eMail,String Passwrd) throws InterruptedException

	{
		homeObj = new HomePage(driver);
		homeObj.openSignInPage();
		loginObj = new LoginPage(driver);
		loginObj.login(eMail, Passwrd);
		WebDriverWait wait = new WebDriverWait(driver, 5);
		WebElement errorMsgAuthentication = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"center_column\"]/div[1]/ol/li"))); 
		//Validate that E-mail value is required error message will appear
		assertEquals(errorMsgAuthentication.getText(), "Authentication failed.");

	}
	
	@DataProvider(name = "validData")
	public Object[][] getLoginData() 
	{
		return new Object[][] 
				{
			{ "test47@gmail.com", "123456789" }
				};
	}
	@DataProvider(name = "EmptyData")
	public Object[][] getLoginEmptyData() 
	{
		return new Object[][] 
				{
			{ "", "" },
			{ "", "123456789" },
			{ "test47@gmail.com", "" }
				};
	}
	@DataProvider(name = "IncorrectData")
	public Object[][] getLoginIncorrectData() 
	{
		return new Object[][] 
				{
			{ "Test@gma.com", "123456789" },
			{ "test47@gmail.com", "1234567899" }
				};
	}
}
