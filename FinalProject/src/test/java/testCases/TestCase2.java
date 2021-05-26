package testCases;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import Browser.Browser;
import Excel.Excel;
import StepDefinition.Search;


public class TestCase2 extends Browser{
	
	@Test(priority=1,dataProvider = "searchdata")
	public void data1(String searchText) throws Exception 
	{
		Search obj = new Search();
		obj.inputTextBox(searchText);
		Thread.sleep(3000);
		obj.clickRetry();
		obj.dropdown1();
		obj.filters();
		Thread.sleep(3000);
		obj.displayLatest();
	}
	
	@DataProvider (name = "searchdata")
	public Object[][] searchData() throws Exception 
	{
	    Object[][] testData = new Object[1][1];
	    testData[0][0] = Excel.readExcel(0, 0);
	    return testData;
	 }
	
}
