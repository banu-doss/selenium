package seleniumjava.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import seleniumjava.abstructcomponent.abstructcomponent;

public class checkoutpage extends abstructcomponent
{
		WebDriver driver;
	public checkoutpage(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}

	@FindBy(css="[placeholder='Select Country']")
WebElement country;
	
	@FindBy(xpath=("(//button[contains(@class,'ta-item')])[2]"))
WebElement selectcountry;
	
	@FindBy(css=(".action__submit"))
WebElement submit;

	
	public void selectcountryname(String countryname) 
	{
		
		Actions a=new Actions(driver);
		a.sendKeys(country, "india").build().perform();
		waitelementtoappear(By.cssSelector(".ta-results"));
        selectcountry.click();
       
      
	}
	
	public confirmationpage submitorder() throws InterruptedException 
	{
	Thread.sleep(3000);
	submit.click();

		/*WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(20));
		wait.until(ExpectedConditions.elementToBeClickable(submit));*/

		return new confirmationpage(driver);
	}
}
