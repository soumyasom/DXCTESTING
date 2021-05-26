package StepDefinition;

import static org.testng.Assert.assertEquals;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

import Browser.Browser;

public class Validate extends Browser{
	public void check_title() {
		try {
		String fileLocation=System.getProperty("user.dir")+"\\ApplicationProperty\\Configure.properties";
		File file=new File(fileLocation);
		FileInputStream fileinput=new FileInputStream(file);
		Browser.prop=new Properties();
		Browser.prop.load(fileinput);
		String link=Browser.prop.getProperty("expectedResult");
		  String er =link;
		  //System.out.println(driver.getTitle());
		  String actualResult = (driver.getTitle());
		  assertEquals(er,actualResult);
		  System.out.println("title verified");
		}catch(Exception e) {
			System.out.println("Validate Error");
		}
	}
}
