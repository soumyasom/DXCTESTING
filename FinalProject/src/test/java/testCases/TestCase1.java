package testCases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Browser.Browser;
import StepDefinition.Open;

public class TestCase1 extends Browser{
	@BeforeMethod
	public void browserTest() throws Exception 
	{
                
				Browser.getUrl();
	}
	
	@Test
	public void datainput() throws Exception 
	{
		
		Open obj = new Open();
		obj.OpenPage();
	} 
	
}
