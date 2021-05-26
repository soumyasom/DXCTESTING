package StepDefinition;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import Browser.Browser;

public class Open extends Browser{

	public void OpenPage() throws IOException {
		
		String fileLocation=System.getProperty("user.dir")+"\\ApplicationProperty\\Configure.properties";
		File file=new File(fileLocation);
		FileInputStream fileinput=new FileInputStream(file);
		Browser.prop=new Properties();
		Browser.prop.load(fileinput);
		String link=Browser.prop.getProperty("home");
	    WebElement home = Browser.driver.findElement(By.xpath(link));
		home.click();

	}
	
}
