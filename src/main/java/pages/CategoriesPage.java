package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class CategoriesPage extends PageBase{

	public CategoriesPage(WebDriver driver) {
		super(driver);
	}
	//Define each element in this page
	@FindBy(xpath = "//*[@id=\"block_top_menu\"]/ul/li[1]/a")
	WebElement womanCategoryLink;

	@FindBy(xpath = "//*[@id=\"block_top_menu\"]/ul/li[2]/a")
	WebElement dressesCategoryLink;

	@FindBy(xpath = "//*[@id=\"block_top_menu\"]/ul/li[3]/a")
	WebElement tshirtsCategoryLink;


	//This method to navigate to “Women” Category 
	public Actions builder1 ;
	public void navigateToResultedProductWomanCategory() 
	{
		builder1.doubleClick(womanCategoryLink).perform();		
	}

	//This method to navigate to “Dresses” Category 
	public Actions builder2 ;
	public void navigateToResultedProductDressesCategory() 
	{
		builder1.doubleClick(dressesCategoryLink).perform();		
	}

	//This method to navigate to “T-shirts” Category 
	public Actions builder3 ;
	public void navigateToResultedProductTshirtsCategory() 
	{
		builder1.doubleClick(tshirtsCategoryLink).perform();		
	}


}
