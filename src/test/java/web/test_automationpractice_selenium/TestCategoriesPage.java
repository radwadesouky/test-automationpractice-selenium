package web.test_automationpractice_selenium;

import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pages.CategoriesPage;

public class TestCategoriesPage extends TestBase{
	CategoriesPage categoryObj;
	

	//This test method to validate that user can navigate to “Women” Category page
	@Test(enabled=false)
	public void testNavigateToWomanCategory()
	{
		categoryObj = new CategoriesPage(driver);
		categoryObj.builder1 = new Actions(driver);
		categoryObj.navigateToResultedProductWomanCategory();
	}
	
	//This test method to validate that user can navigate to “Dresses” Category page
	@Test(enabled=true)
	public void testNavigateToDressesCategory()
	{
		categoryObj = new CategoriesPage(driver);
		categoryObj.builder1 = new Actions(driver);
		categoryObj.navigateToResultedProductDressesCategory();
	}
	
	@DataProvider(name = "validData")
	public Object[][] getLoginData() 
	{
		return new Object[][] 
				{
			{ "test47@gmail.com", "123456789" }
				};
	}
}
