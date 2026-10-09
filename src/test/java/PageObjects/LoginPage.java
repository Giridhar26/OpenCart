package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BasePage {
	
	
	
	//Constructor
	
	public LoginPage(WebDriver driver)
	{
		
		super(driver);
	}
	
	
	//Locators
	
	
	
	
	@FindBy (xpath="//input[@id='input-email']")
	WebElement email_txt;
	
	@FindBy (xpath="//input[@id='input-password']")
	WebElement password_txt;
	
	@FindBy(xpath ="//input[@value='Login']")
	WebElement login_btn;
	
	
	

	
	//Action Method
	
	
	
	public void setEmailAddress(String mail)
	{
		email_txt.sendKeys(mail);
	}
	
	public void setPassword(String pwd)
	{
		password_txt.sendKeys(pwd);
	}
	
	public void clickLoginBtn()
	{
		login_btn.click();
	}
	
	
	
	
	

}
