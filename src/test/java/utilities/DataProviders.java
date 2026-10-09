package utilities;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class DataProviders {

	@DataProvider(name="LoginData")
	public String[][] getData() throws IOException
	{
	    String path = ".\\testData\\LoginData.xlsx"; // taking xl file from testData

	    ExcelUtility xlutil = new ExcelUtility(path); // creating an object for XLUtility

	    int totalrows = xlutil.getRowCount("Sheet1");
	    int totalcols = xlutil.getCellCount("Sheet1", 1);

	    String logindata[][] = new String[totalrows][totalcols]; // created for two dimension array

	    for(int i = 1; i <= totalrows; i++)   // read the data from xl storing in two dimensional array
	    {
	        for(int j = 0; j < totalcols; j++)   // i is rows, j is col
	        {
	            logindata[i-1][j] = xlutil.getCellData("Sheet1", i, j);
	        }
	    }

	    return logindata; // returning two dimension array
	}
	
	@DataProvider(name="RegisterData")
	public String[][] getRegData() throws IOException
	{
	    String path = ".\\testData\\Registerdata.xlsx"; // taking xl file from testData

	    ExcelUtility xlutil = new ExcelUtility(path); // creating an object for XLUtility

	    int totalrows = xlutil.getRowCount("Sheet1");
	    int totalcols = xlutil.getCellCount("Sheet1", 1);

	    String Registerdata[][] = new String[totalrows][totalcols]; // created for two dimension array

	    for(int i = 1; i <= totalrows; i++)   // read the data from xl storing in two dimensional array
	    {
	        for(int j = 0; j < totalcols; j++)   // i is rows, j is col
	        {
	            Registerdata[i - 1][j] = xlutil.getCellData("Sheet1", i, j);
	        }
	    }

	    return Registerdata; // returning two dimension array
	}// Data provider 2
	
	//Data Provider 3 
}
