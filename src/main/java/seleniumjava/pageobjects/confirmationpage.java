package seleniumjava.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import seleniumjava.abstructcomponent.abstructcomponent;

public class confirmationpage extends abstructcomponent {
	WebDriver driver;
	
	public confirmationpage(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}

	@FindBy(css=".hero-primary")
	WebElement confirmmessage;
	
	public String getconfirmation() throws InterruptedException 
	{
Thread.sleep(2000);
		
		return confirmmessage.getText(); 
		
	}
}
