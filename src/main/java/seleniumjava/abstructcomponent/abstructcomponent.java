package seleniumjava.abstructcomponent;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import seleniumjava.pageobjects.cartpage;
import seleniumjava.pageobjects.orderpage;

public class abstructcomponent {
WebDriver driver;
	public abstructcomponent(WebDriver driver)
	{

this.driver=driver;
PageFactory.initElements(driver, this);
	}
	
	
@FindBy(css="[routerlink*='/dashboard/cart']")
WebElement cartheader;

@FindBy(css="[routerlink*='/dashboard/myorders']")
WebElement orderheader;

	public void waitelementtoappear(By findBy)
	{
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(findBy));
		
	}
	
	public void waitforWebElementtoappear(WebElement findBy)
	{
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(findBy));
	}
	
	public cartpage gotocartpage() throws InterruptedException
	{

		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(20));
		wait.until(ExpectedConditions.elementToBeClickable(cartheader));
		Thread.sleep(2000);
		cartheader.click();
		cartpage cart=new cartpage(driver);
		return cart;
		
	}
	
	public orderpage gotoorderpage() throws InterruptedException
	{
		//WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(20));
		//wait.until(ExpectedConditions.elementToBeClickable(orderheader));
		Thread.sleep(2000);	
		orderheader.click();
		orderpage order=new orderpage(driver);
		return order;
	}
	
	public void waitelementtodisappear(WebElement element)
	{
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.invisibilityOf(element));
			
	}
	
}
