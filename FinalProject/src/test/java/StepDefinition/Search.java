package StepDefinition;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import org.openqa.selenium.By;
//import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import Browser.Browser;


public class Search extends Browser{
	
	public static String fileLocation=System.getProperty("user.dir")+ "\\ApplicationProperty\\Configure.properties";
	public static File file=new File(fileLocation);
	
	public void inputTextBox(String searchData) throws IOException {
		try {
		
			FileInputStream fileinput=new FileInputStream(file);
			Browser.prop=new Properties();
			Browser.prop.load(fileinput);
			String link1=Browser.prop.getProperty("inputbox");
			WebElement input = Browser.driver.findElement(By.xpath(link1));
			
			input.sendKeys(searchData);
			String link2=Browser.prop.getProperty("searchButton");
			driver.findElement(By.xpath(link2)).click();
			Thread.sleep(3000);
			
		}catch(Exception e)
		{
			System.out.println("Input Search Box exception");
		}
	} 
	
	public void clickRetry() throws IOException {
		try {
			
			FileInputStream fileinput=new FileInputStream(file);
			Browser.prop=new Properties();
			Browser.prop.load(fileinput);
			String link3=Browser.prop.getProperty("retryButton");
			WebElement btn = driver.findElement(By.xpath(link3));
			btn.click();
			Thread.sleep(3000);
			
		}catch(Exception e)
		{
			System.out.println("retry exception");
		}
	} 
	
	public void dropdown1() throws IOException {
		
		FileInputStream fileinput=new FileInputStream(file);
		Browser.prop=new Properties();
		Browser.prop.load(fileinput);
		String link4=Browser.prop.getProperty("sortprice");
		 WebElement t=driver.findElement(By.xpath(link4));
		 Select s = new Select(t);
		 s.selectByValue("30000");
	}
	
	public void filters() throws IOException {
		try {
			
			FileInputStream fileinput=new FileInputStream(file);
			Browser.prop=new Properties();
			Browser.prop.load(fileinput);
			String link5=Browser.prop.getProperty("newestFirst");
			WebElement btn = driver.findElement(By.xpath(link5));
			btn.click();
			Thread.sleep(3000);
			
		}catch(Exception e)
		{
			System.out.println(e);
		}
	} 
	
	public void displayLatest() throws IOException {
		try {
			
			FileInputStream fileinput=new FileInputStream(file);
			Browser.prop=new Properties();
			Browser.prop.load(fileinput);
			String link6=Browser.prop.getProperty("displaynewest");
			WebElement btn = driver.findElement(By.xpath(link6));
			System.out.println(btn.getText());
			Thread.sleep(3000);
			String link7=Browser.prop.getProperty("price");
			String p = driver.findElement(By.xpath(link7)).getText();
			String numberOnly = p.replaceAll("[^0-9]", "");
			System.out.println(numberOnly);
			
			int num = Integer.parseInt(numberOnly);
			if(num<30000) {
				System.out.println("price less than 30000 verified");
			}else {
			System.out.println("price verification failed");
			}
		}
		catch(Exception e){
			System.out.println(e);
		}
		}
	
	}
	 

