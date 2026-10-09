package TestCases;

import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import PageObjects.HomePage;
import PageObjects.LoginPage;
import PageObjects.myAccountPage;
import testBase.BaseClass;

public class tc_LoginTest extends BaseClass{
	
	
	
	@Test
	public void verify_Login() throws InterruptedException, IOException
	{
		
		
		logger.info("Starting of the Login Test cases execution");
		
		HomePage hp = new HomePage(driver);
		hp.myaccountlnk();
		logger.info("Clicked on My Account link");
		hp.mylogin();
		logger.info("clicked on Login link");
		
		LoginPage lp= new LoginPage(driver);	
		
		lp.setEmailAddress(p.getProperty("email"));
		logger.info("Entered email address");
		lp.setPassword(p.getProperty("password"));
		logger.info("Entered password");
		logger.info("Entered it successfully");
		lp.clickLoginBtn();
		logger.info("clicked on Login button");
		
		
		myAccountPage mp = new myAccountPage(driver);
		
		boolean myaccnt_status=mp.isMyAccountPageExists();
		
		Assert.assertEquals(myaccnt_status, true,"Login Test case is failed");
		
		Thread.sleep(3000);
		
		mp.clickLogoutBtn();
		logger.info("clicked on Logout button");
		
		logger.info("Login Test case is completed");
		
		
		
	}
	
}
