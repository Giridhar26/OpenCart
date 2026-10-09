package TestCases;

import java.time.Duration;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


import PageObjects.AccountsRegistrationPage;
import PageObjects.HomePage;
import testBase.BaseClass;

public class tc_AccounRegistration extends BaseClass{
	
	
	
	@Test
	public void verify_Reg_Account()
	{
		try {
		logger.info("Starting of the Test cases execution");
	
		HomePage hp = new HomePage(driver);
		
		hp.myaccountlnk();
		logger.info("Clicked on My Account link");
		hp.myregisterlnk();
		logger.info("clicked on Register link");
		
		AccountsRegistrationPage arp = new AccountsRegistrationPage(driver);
		
		arp.txtFname(randomString().toUpperCase());
		arp.txtLname(randomString().toUpperCase());
		arp.txtemail(randomString()+"@gmail.com");
		arp.txtphn(randomNumeric());
		
		String pwd = randomAlphaNumeric();
		arp.txtpwd(pwd);
		arp.txtcnfmpwd(pwd);
		
		arp.chkbxagree();
		arp.btncontinue();
		
		logger.info("Entered all the details and clicked on continue button");
		
		String confmsge = arp.getconfrimationmsg();
		
		logger.info("Validating expected message with actual message");
		
		Assert.assertEquals(confmsge, "Your Account Has Been Created!");
		
		logger.info("Account Registration Test case is passed");
		
		}
		
		catch(Exception e)
		{
			logger.error("Account Registration Test case is failed");
			logger.debug("Exception occured", e);
			Assert.fail();
		}
		
		logger.info("Ending of the Test cases execution");
	}
	
}
