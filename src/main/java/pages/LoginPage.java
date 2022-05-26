package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends PageBase{

	public LoginPage(WebDriver driver) {
		super(driver);
	}
	//define e-mail text box field
	@FindBy(id = "email")
	WebElement email;

	//define password text box field
	@FindBy(id = "passwd")
	WebElement password;

	//define sign in button
	@FindBy(id = "SubmitLogin")
	WebElement loginBtn;	


	//This method get a valid user authentication and login into site
	public void login(String Email,String pass)
	{
		email.sendKeys(Email);	
		password.sendKeys(pass);
		loginBtn.click();
	}



}
