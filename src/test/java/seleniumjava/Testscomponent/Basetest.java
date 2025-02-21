package seleniumjava.Testscomponent;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import io.github.bonigarcia.wdm.WebDriverManager;
import seleniumjava.pageobjects.landingpage;

public class Basetest {

	public WebDriver driver;
	public landingpage landing;
	public WebDriver intializeDriver() throws IOException
	{
		Properties prop=new Properties();
		FileInputStream fis=new FileInputStream (System.getProperty("user.dir")+ "\\src\\main\\java\\seleniumjava\\Testresources\\global.properties");
		prop.load(fis);
		String browserName=prop.getProperty("browser");
		
		if(browserName.contains("chrome"))
		{
		WebDriverManager.chromedriver().setup();
		ChromeOptions options=new ChromeOptions();
		if(browserName.contains("headless"))
		{
		options.addArguments("headless");
		}
		driver=new ChromeDriver(options);
		
	}
		else if(browserName.equalsIgnoreCase("Firefox"))
		{
			//firefox
		}
		
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	driver.manage().window().setSize(new Dimension(1440,900));
	driver.manage().window().maximize();
	return driver;
}
	@BeforeMethod
	
	public landingpage launchApplication() throws IOException
	{
		driver=intializeDriver();
	 landing=new landingpage(driver);
		landing.goTo();
		return landing;
	}
	
	@AfterMethod
	public void close()
	{
		//driver.close();
		driver.quit();		
	}
}
