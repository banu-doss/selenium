package seleniumjava.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import seleniumjava.abstructcomponent.abstructcomponent;

public class landingpage extends abstructcomponent{
	WebDriver driver;
	public landingpage(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
@FindBy(id="userEmail")
WebElement Email;

@FindBy(id="userPassword")
WebElement Password;

@FindBy(id="login")
WebElement submit;

@FindBy(css="[class*='flyInOut']")
WebElement errormessage;

public String geterrormessage()
{
	waitforWebElementtoappear(errormessage);
	return errormessage.getText();
}

public productcatalogue loginApplication(String email,String pw)
{
	Email.sendKeys(email);
	Password.sendKeys(pw);
	submit.click();
	productcatalogue catalogue=new productcatalogue(driver);
	return catalogue;
	
}
public void goTo()
{
	driver.get("http://rahulshettyacademy.com/client");
}
}
