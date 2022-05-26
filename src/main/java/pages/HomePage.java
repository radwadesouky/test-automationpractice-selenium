package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class HomePage extends PageBase {


	public HomePage(WebDriver driver) {
		super(driver);
	}
	@FindBy(xpath = "//*[@id=\"header\"]/div[2]/div/div/nav/div[1]/a")
	WebElement signInLink;



	//This method to navigate to Authentication page 
	public void openSignInPage() {
		signInLink.click();
	}


}
