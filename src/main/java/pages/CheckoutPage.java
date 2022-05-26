package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class CheckoutPage extends PageBase{

	public CheckoutPage(WebDriver driver) {
		super(driver);
	}
	//Define each element in this page
	@FindBy(xpath = "//*[@id=\"block_top_menu\"]/ul/li[1]/a")
	WebElement womanCategoryLink;

	@FindBy(xpath = "//*[@id=\"block_top_menu\"]/ul/li[1]/ul/li[1]/ul/li[2]/a")
	WebElement subCategoryLink;

	public @FindBy(xpath="//*[@id=\"center_column\"]/ul/li/div/div[2]/div[2]/a[1]")
	WebElement addCardBtn;

	public @FindBy(xpath="//*[@id=\"center_column\"]/p[2]/a[1]")
	WebElement checkoutbtn2;

	public @FindBy(xpath="//*[@id=\"center_column\"]/form/p/button")
	WebElement checkoutbtn3;

	public @FindBy(id="cgv")
	WebElement agreementCheckBox;

	public @FindBy(xpath="//*[@id=\"form\"]/p/button")
	WebElement checkoutbtn4;

	public @FindBy(xpath="//*[@id=\"HOOK_PAYMENT\"]/div[1]/div/p/a")
	WebElement bankWireOption;

	public @FindBy(xpath="//*[@id=\"cart_navigation\"]/button")
	WebElement confirmBtn;

	public @FindBy(xpath="//*[@id=\"center_column\"]/div/p/strong")
	WebElement confirmMsg;
	
	@FindBy(xpath = "//*[@id=\"center_column\"]/p/a")
	WebElement backOrdersBtn;
	

	public @FindBy(xpath = "//*[@id=\"center_column\"]/p")
	WebElement orderMsgCreated;
	

    
	//This method to select “Blouses” Subcategory in “Women” Category 
	public Actions builder1 ;
	public void navigateToResultedProduct() 
	{
		builder1.moveToElement(womanCategoryLink).perform();
		subCategoryLink.click();
	}
    
	//This method to navigate to orders history page
	public void navigateToOrdersHistoryPage() 
	{
		backOrdersBtn.click();
	}


}
