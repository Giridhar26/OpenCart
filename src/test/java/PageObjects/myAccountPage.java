package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class myAccountPage extends BasePage{
	
	//Constructor
	public myAccountPage(WebDriver driver)
	{
		super(driver);
	}
	
	//Locators
	
	@FindBy(xpath="//h2[normalize-space()='My Account']")
	WebElement myaccount_heading;
	
	@FindBy(xpath="//a[@class='list-group-item'][text()='Logout']")
	WebElement logout_btn;
	
	
	//Action Methods
	
	public boolean isMyAccountPageExists()
	{
		try {
			return (myaccount_heading.isDisplayed());
		}
		catch(Exception e)
		{
			return false;
		}
	}

	public void clickLogoutBtn()
	{
		logout_btn.click();
		
	}
}
