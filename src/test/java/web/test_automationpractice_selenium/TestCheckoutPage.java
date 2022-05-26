package web.test_automationpractice_selenium;
import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import pages.CheckoutPage;
import pages.HomePage;
import pages.LoginPage;

public class TestCheckoutPage extends TestBase{
	HomePage homeObj;
	LoginPage loginObj;
	CheckoutPage chekoutObj;
	JavascriptExecutor js;


	@Test(priority=0)
	public void testNavigateToResultedProduct()
	{

		chekoutObj = new CheckoutPage(driver);
		chekoutObj.builder1 = new Actions(driver);
		chekoutObj.navigateToResultedProduct();
		js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,650)", "");
	}

	@Test(priority=1,dependsOnMethods = { "testNavigateToResultedProduct" })
	public void testCheckoutProcess()
	{
		//Navigate to resulted product viewer
		WebElement qLink = driver.findElement(By.xpath("//*[@id=\"center_column\"]/ul/li/div"));
		Actions action2 = new Actions(driver);
		action2.doubleClick(qLink).perform();
		//Click on add to card button
		chekoutObj.addCardBtn.click();

		//Navigate to resulted product details 
		WebDriverWait wait = new WebDriverWait(driver, 15);
		WebElement checkoutbtn1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"layer_cart\"]/div[1]/div[2]/div[4]/a")));  
		//Click on Proceed to checkout button
		checkoutbtn1.click();

		//Click on Proceed to checkout button , 1. summary tab
		js.executeScript("window.scrollBy(0,650)", "");
		chekoutObj.checkoutbtn2.click();

		//2. Sign in 
		js.executeScript("window.scrollBy(0,650)", "");
		loginObj = new LoginPage(driver);
		loginObj.login("radwamostafa47@gmail.com", "123456789");

		//3. Select address
		chekoutObj.checkoutbtn3.click();
		js.executeScript("window.scrollBy(0,650)", "");

		//4. Shipping
		chekoutObj.agreementCheckBox.click();
		js.executeScript("window.scrollBy(0,450)", "");
		chekoutObj.checkoutbtn4.click();

		//05. Payment
		js.executeScript("window.scrollBy(0,450)", "");
		chekoutObj.bankWireOption.click();
		chekoutObj.confirmBtn.click();

		js.executeScript("window.scrollBy(0,350)", "");
		String completedMsg = chekoutObj.confirmMsg.getText();
		//Validate that payment is done successfully
		assertEquals(completedMsg, "Your order on My Store is complete.");
		
		//navigate to orders history page
		chekoutObj.navigateToOrdersHistoryPage();
		String orderCreatedMsg = chekoutObj.orderMsgCreated.getText();
		//Validate order was placed from order history page.
		assertEquals(orderCreatedMsg, "Here are the orders you've placed since your account was created.");
		

	}


}
