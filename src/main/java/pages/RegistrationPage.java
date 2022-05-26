package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class RegistrationPage extends PageBase{

	public RegistrationPage(WebDriver driver) {
		super(driver);
	}
    //Define each element in this page
	@FindBy(id="email_create")
	WebElement emailTxt;

	@FindBy(id="SubmitCreate")
	WebElement submitBtn;

	@FindBy(id="customer_lastname")
	WebElement customerLastName;

	@FindBy(id="passwd")
	WebElement password;
	
	/*@FindBy(id="days")
	WebElement daysDropDown;
	Select days = new Select(daysDropDown);
	
	@FindBy(id="months")
	WebElement monthsDropDown;
	Select months = new Select(monthsDropDown);*/
	
	@FindBy(id="uniform-newsletter")
	WebElement uniformnewsletterCheckBox;
	
	@FindBy(id="uniform-optin")
	WebElement uniformoptinCheckBox;

	@FindBy(id="address1")
	WebElement address1;

	@FindBy(id="city")
	WebElement city;

	@FindBy(id="postcode")
	WebElement postcode;

	@FindBy(id="phone_mobile")
	WebElement mobilePhone;

	@FindBy(id="submitAccount")
	WebElement registerBtn;

	@FindBy(xpath="//*[@id=\"header\"]/div[2]/div/div/nav/div[2]/a")
	WebElement logoutBtn;

	//This method to open registration page 
	public void openRegistrationPage(String EMail)
	{
		emailTxt.sendKeys(EMail);
		submitBtn.click();
	}
	//This method to set a new user information
	public void registrationInfo(String lastname ,String pass , String address,String City,WebElement stateDropDownList,String state,
			String newsletterChecker,String uniformoptinChecker,String code,String mobile)
	{
		customerLastName.sendKeys(lastname);
		password.sendKeys(pass);
		address1.sendKeys(address);
		city.sendKeys(City);
		Select stateOptions = new Select(stateDropDownList);
		stateOptions.selectByVisibleText(state);
		if(newsletterChecker == "TRUE")
		{
			uniformnewsletterCheckBox.click();
		}
		if(uniformoptinChecker == "TRUE")
		{
			uniformoptinCheckBox.click();
		}
		postcode.sendKeys(code);
		mobilePhone.sendKeys(mobile);
		registerBtn.click();
	}
	//This method to sign out
	public void logOut()
	{
		logoutBtn.click();
	}

}
