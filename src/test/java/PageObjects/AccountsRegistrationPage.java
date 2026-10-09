package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountsRegistrationPage extends BasePage {
	
	public AccountsRegistrationPage(WebDriver driver)
	{
		super(driver);
	}
	
	
	@FindBy(xpath ="//input[@id='input-firstname']")
	WebElement txt_firstname;
	
	@FindBy(xpath="//input[@id='input-lastname']")
	WebElement txt_lastname;
	
	@FindBy(xpath="//input[@id='input-email']")
	WebElement txt_emailid;
	
	@FindBy(xpath="//input[@id='input-telephone']")
	WebElement txt_phonenum;
	
	@FindBy(xpath="//input[@id='input-password']")
	WebElement txt_password;
	
	
	@FindBy(xpath="//input[@id='input-confirm']")
	WebElement txt_cnfmpassword;
	
	@FindBy(xpath="//input[@name='agree']")
	WebElement chck_agree;
	
	@FindBy(xpath="//input[@value='Continue']")
	WebElement btn_continue;
	
	@FindBy(xpath="//h1[normalize-space()='Your Account Has Been Created!']")
	WebElement msgconfirmation;
	
	public void txtFname(String fname)
	{
		txt_firstname.sendKeys(fname);
	}
	
	public void txtLname(String lname)
	{
		txt_lastname.sendKeys(lname);
	}
	
	public void txtemail(String email)
	{
		txt_emailid.sendKeys(email);
	}
	
	public void txtphn(String phnm)
	{
		txt_phonenum.sendKeys(phnm);
	}

	public void txtpwd(String pwd)
	{
		txt_password.sendKeys(pwd);
	}
	
	public void txtcnfmpwd(String cnfmpwd)
	{
		txt_cnfmpassword.sendKeys(cnfmpwd);
	}
	
	public void chkbxagree()
	{
		chck_agree.click();
	}
	
	public void btncontinue()
	{
		btn_continue.click();
	}
	
	public String getconfrimationmsg()
	{
		try
		{
			return (msgconfirmation.getText());
		}
		catch(Exception e)
		{
			return (e.getMessage());
		}
	}
}
