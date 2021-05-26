package StepDefinition;

import java.io.File;
import java.io.FileInputStream;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import Browser.Browser;

public class ProductList extends Browser{
	public void products() throws Exception{
		try {
			String fileLocation=System.getProperty("user.dir")+"\\ApplicationProperty\\Configure.properties";
			File file=new File(fileLocation);
			FileInputStream fileinput=new FileInputStream(file);
			Browser.prop=new Properties();
			Browser.prop.load(fileinput); 
			String link1=Browser.prop.getProperty("mobile_name");
			List<WebElement> mobilename = driver.findElements(By.xpath(link1));
			String link2=Browser.prop.getProperty("mobile_price");
			List<WebElement> mobileprice = driver.findElements(By.xpath(link2));
			int j = mobilename.size();
			for(int i=0;i<j;i++) {
		    	Thread.sleep(3000);
		        System.out.println(mobilename.get(i).getText()); 
		        System.out.println(mobileprice.get(i).getText()); 
		        if(i==4) {
		        	break;
		        }
		        else {
		        	continue;
		        }
		    }
		}
			catch(Exception e) {
				System.out.println("logout");
			}
	}
	
}
