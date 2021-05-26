package testCases;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import Browser.Browser;
import Excel.Excel;
import StepDefinition.Validate;

public class TestCase3 extends Browser{
	
	@Test(priority=1,dataProvider = "searchdata")
	public void data1(String searchText) throws Exception 
	{
		Validate obj1 = new Validate();
		obj1.check_title();
	}
	@DataProvider (name = "searchdata")
	public Object[][] searchData() throws Exception 
	{
	    Object[][] testData = new Object[1][1];
	    testData[0][0] = Excel.readExcel(0, 0);
	    return testData;
	 }
	
}
