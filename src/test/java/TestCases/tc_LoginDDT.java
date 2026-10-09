package TestCases;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import PageObjects.HomePage;
import PageObjects.LoginPage;
import PageObjects.myAccountPage;
import testBase.BaseClass;
import utilities.DataProviders;

/*
 * Data is valid - Login success - test pass - logout
 * Data is valid - Login failed - test fail 
 * 
 * Data is invalid - Login success - test fail - logout
 * Data is invalid - Login failed - test pass
 */

public class tc_LoginDDT extends BaseClass{
	
	
	@Test(dataProvider="LoginData", dataProviderClass=DataProviders.class)
	public void verify_LoginDDT(String email, String password, String expectedResult) throws InterruptedException
	{
		logger.info("Starting of the Login Test cases execution");
		
		//Home Page
		HomePage hp = new HomePage(driver);
		hp.myaccountlnk();
		logger.info("Clicked on My Account link");
		hp.mylogin();
		logger.info("clicked on Login link");
		
		// Login page
		LoginPage lp= new LoginPage(driver);	
		logger.info("Entered email address");
		lp.setEmailAddress(email);
		logger.info("Entered password");
		lp.setPassword(password);
		logger.info("clicked on Login button");
		lp.clickLoginBtn();
		
		
		
		myAccountPage mp = new myAccountPage(driver);
		
		boolean myaccnt_status=mp.isMyAccountPageExists();
		
		
		if(expectedResult.equalsIgnoreCase("Valid"))
		{
			if(myaccnt_status==true)
			{
				System.out.println("The status is valid expected result is"+myaccnt_status);
				System.out.println(" IN IF statement this is for valid scenario Email: [" + email + "] Password: [" + password + "] Expected: [" + expectedResult + "]");
				mp.clickLogoutBtn();
				Assert.assertTrue(true);
			}
			
			else
			{
				Assert.assertTrue(false);
				System.out.println(" IN else statement this is for valid scenario Email: [" + email + "] Password: [" + password + "] Expected: [" + expectedResult + "]");
			}
		}
		
		if(expectedResult.equalsIgnoreCase("Invalid"))
		{
			if(myaccnt_status==true)
			{
				System.out.println("The status is Invalid expected result is"+myaccnt_status);
				System.out.println(" this is for IF invalid scenario Email: [" + email + "] Password: [" + password + "] Expected: [" + expectedResult + "]");
				mp.clickLogoutBtn();
				Assert.assertTrue(false);
			}
			
			else
			{
				Assert.assertTrue(true);
				System.out.println(" this is else block for invalid scenario Email: [" + email + "] Password: [" + password + "] Expected: [" + expectedResult + "]");
			}
		}
		
		
	}

}
