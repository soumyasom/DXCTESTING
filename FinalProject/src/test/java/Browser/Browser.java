package Browser;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class Browser {
	public static WebDriver driver;
	public static Actions act;
	public static Properties prop;
	public static String fileLocation=System.getProperty("user.dir")+ "\\ApplicationProperty\\Configure.properties";
	public static File file=new File(fileLocation);
	// WebDriver Setup Selection Method
	@BeforeSuite
	public static WebDriver setDriver() throws Exception{
		
		System.out.println("Choosing from the following 3\n1.Chrome\n2.Edge\n3.Explorer");
		
		FileInputStream fileinput=new FileInputStream(file);
		prop=new Properties();
		prop.load(fileinput);
		String name=prop.getProperty("browserName");
		if(name.equalsIgnoreCase("chrome"))
			driver=setChromeDriver();
		else if(name.equalsIgnoreCase("IE"))
			driver=setEdgeDriver();
		else  if(name.equalsIgnoreCase("edge"))
			driver=setIEDriver();
		else
			System.out.println("Invalid browser name");
		System.out.println(driver);
		return driver;
		
	}
    
	
	
	// ChromeDriver Setup Method
	public static WebDriver setChromeDriver() {
		
		try
		{
		FileInputStream fileinput=new FileInputStream(file);
		prop=new Properties();
		prop.load(fileinput);
		String driverPathChrome1=(System.getProperty("user.dir")+prop.getProperty("chromeDriver"));
		System.setProperty("webdriver.chrome.driver", driverPathChrome1);
		driver=new ChromeDriver();
		
		}
		catch(Exception e)
		{
			System.out.println("Browser open exception");
		}
		return driver;
	}

	// Internet Explorer Driver Setup Method
	public static WebDriver setIEDriver() {
		
		try
		{
		 FileInputStream fileinput=new FileInputStream(file);
	     prop=new Properties();
	     prop.load(fileinput);
		 String driverPathIE=(System.getProperty("user.dir")+prop.getProperty("InternetExpolrerDriver"));
		 System.setProperty("webdriver.ie.driver", driverPathIE);
		 driver=new EdgeDriver();
	
		return driver;
		}
		catch(Exception e)
		{
			
			System.out.println("Browser open exception");
		}
		return driver;
	}

	// Microsoft Edge Driver Setup Method
	public static WebDriver setEdgeDriver() {
		
		try
		{
		FileInputStream fileinput=new FileInputStream(file);
		prop=new Properties();
		prop.load(fileinput);
		String driverPathEdge=(System.getProperty("user.dir")+prop.getProperty("msedgeDriver"));
		System.setProperty("webdriver.edge.driver", driverPathEdge);
		driver=new EdgeDriver();
		
		return driver;
		}
		catch(Exception e)
		{
			
			System.out.println("Browser open exception");
		}
		return driver;
	}

	// Url Setup Method
	public static void getUrl() throws Exception {
		
		FileInputStream fileinput=new FileInputStream(file);
		prop=new Properties();
		prop.load(fileinput);
				
		driver.get(prop.getProperty("url"));
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		
	}

	//Driver Close Method
	@AfterSuite
	public static void closeBrowser() {
		driver.quit();
	}
}
