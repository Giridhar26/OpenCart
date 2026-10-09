package testBase;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class BaseClass {
	
	 public WebDriver driver;
	
	 public Logger logger;
	 
	 public Properties p;
	 
	@BeforeClass
	@Parameters({"OS","browser"})
	public void setup(String os, String br) throws IOException
	
	{
		logger= LogManager.getLogger(this.getClass());
		
		
		FileReader fr = new FileReader("./src/test/resources/config.properties");
		p= new Properties();
		p.load(fr);
		
		
		if(p.getProperty("execution_environment").equalsIgnoreCase("remote"))
		{
			logger.info("Executing on remote machine");
			
			
			DesiredCapabilities capabilities= new DesiredCapabilities();
			
			//Operating 
			if(os.equalsIgnoreCase("windows"))
			{
				capabilities.setPlatform(Platform.WIN11);
			}
			else if(os.equalsIgnoreCase("mac"))
			{
				capabilities.setPlatform(Platform.MAC);
			}
			else if(os.equalsIgnoreCase("linux"))
			{
				capabilities.setPlatform(Platform.LINUX);
			}
			else
			{
				System.out.println("Platform is not available");
				logger.info("No Platform is provided");
				return;
			}
			
			//Browser setup
			switch(br.toLowerCase())
			{
			case "chrome":
				capabilities.setBrowserName("chrome");
				break;
			case "edge":
				capabilities.setBrowserName("MicrosoftEdge");
				break;
			case "firefox":
				capabilities.setBrowserName("firefox");
				break;
				
				default:
					System.out.println("No matching browser found");	
					logger.info("No matching browser found");
					return;		
					}
			driver= new RemoteWebDriver(new URL(p.getProperty("http://192.168.29.76:4444/wd/hub")), capabilities);
		}
		
		if(p.getProperty("execution_environment").equalsIgnoreCase("local"))
		{
			switch(br.toLowerCase())
			{
			case "chrome":
				driver= new ChromeDriver();
				break;
			case "edge":
				driver= new EdgeDriver();
				break;
			case "firefox":
				driver= new FirefoxDriver();
				break;
				
				default:
					logger.info("Please provide valid browser name");
					return;		
					}
		}
			
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(p.getProperty("url")); // reading the url from config.properties file
	}
	
	@AfterClass
	public void teardown()
	{
		driver.quit();
	}
	
	
	public String randomString()
	{
		String generatedString= RandomStringUtils.randomAlphanumeric(10);
		return generatedString;
	}
	
	public String randomNumeric()
	{
		String generatedString2= RandomStringUtils.randomNumeric(10);
		return generatedString2;
	}
	
	public String randomAlphaNumeric()
	{
		String str= RandomStringUtils.randomAlphanumeric(4);
		String num= RandomStringUtils.randomNumeric(4);
		
		return str+num;
		
	}
	
	public String captureScreen(String tname) throws IOException {

	    String timeStamp = new SimpleDateFormat("yyyyMMddhhmmss")
	            .format(new Date());

	    TakesScreenshot takesScreenshot = (TakesScreenshot) driver;

	    File sourceFile = takesScreenshot.getScreenshotAs(OutputType.FILE);

	    String targetFilePath = System.getProperty("user.dir")+ "\\screenshots\\"+ tname + "_" + timeStamp + ".png";

	    File targetFile = new File(targetFilePath);

	    sourceFile.renameTo(targetFile);

	    return targetFilePath;
	}

}
