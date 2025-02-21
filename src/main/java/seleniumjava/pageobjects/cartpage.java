package seleniumjava.pageobjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import seleniumjava.abstructcomponent.abstructcomponent;

public class cartpage extends abstructcomponent
{
WebDriver driver;
public cartpage(WebDriver driver)
{
	super(driver);
	this.driver=driver;
	PageFactory.initElements(driver, this);
	
}

@FindBy(css="li.totalRow button")
WebElement checkoutproduct;

@FindBy(css=".cartSection h3")
List<WebElement> cartproducts;

public Boolean verifyproductdisplay(String productName)
{
Boolean match=cartproducts.stream().anyMatch(cartproduct->cartproduct.getText().equalsIgnoreCase(productName));
return match;
}

public void gotocheckout()
{
	
	checkoutproduct.click();
}
}