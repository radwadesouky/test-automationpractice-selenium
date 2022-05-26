package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class OrderHistoryPage extends PageBase{

	public OrderHistoryPage(WebDriver driver) {
		super(driver);
	}
	//Define each element in this page
	@FindBy(id = "order-list")
	WebElement orderTable;
	
	@FindBy(xpath = "//*[@id=\"center_column\"]/p")
	WebElement orderMsgCreated;

}
