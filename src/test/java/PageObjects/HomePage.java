package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage{
	
	// Constructors
	public HomePage(WebDriver driver)
	{
		super(driver);
	}

	
	// Locators
	@FindBy(xpath="//span[normalize-space()='My Account']")
	WebElement myaccount;
	
	@FindBy(xpath="//a[normalize-space()='Register']")
	WebElement register;
	
	@FindBy(xpath="//a[normalize-space()='Login']")
	WebElement login;
	
	
	//Action classes
	
	public void myaccountlnk()
	{
		myaccount.click();
	}
	
	public void myregisterlnk()
	{
		register.click();
	}
	
	public void mylogin()
	{
		login.click();
	}

}
