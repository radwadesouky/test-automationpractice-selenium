package web.test_automationpractice_selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;



public class TestBase {
	String ChromePath = System.getProperty("user.dir") + "\\Drivers\\chromedriver.exe";
	String URL="http://automationpractice.com/index.php";
	WebDriver driver;

	//This method to set resolution & navigate to url of site
	@BeforeTest
	public void openSiteURL () {
		System.setProperty("webdriver.chrome.driver", ChromePath);
		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setCapability("resolution", "120x60");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("window-size=120x60");
		options.merge(caps);
		driver = new ChromeDriver(options);
		driver.navigate().to(URL);
	}
	
	//This method to close all browser windows after execution test case
	@AfterTest
	public void closeWindow () {
		driver.quit();
	}



}
