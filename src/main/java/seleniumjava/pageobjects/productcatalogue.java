package seleniumjava.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import seleniumjava.abstructcomponent.abstructcomponent;

public class productcatalogue extends abstructcomponent {
	WebDriver driver;
	public productcatalogue(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
@FindBy(css=".mb-3")
List<WebElement>products;

@FindBy(css=".ng-animating")
WebElement spinner;

By productsBy=By.cssSelector(".mb-3");
By addtocart=By.cssSelector(".card-body button:last-of-type");
By toastmessage=By.cssSelector("#toast-container");

public List<WebElement> getproductlist()
{
	 waitelementtoappear(productsBy);
	 return products;
}

public WebElement getprodctname(String productName)
{
	WebElement prod=getproductlist().stream().filter(product->product.findElement(By.cssSelector("b")).getText().equals(productName)).findFirst().orElse(null);
	return prod;
}

public void addproducttocart(String productName)
{
	WebElement prod=getprodctname(productName);
	prod.findElement(addtocart).click();
	waitelementtoappear(toastmessage);
	waitelementtodisappear(spinner);
	
}
}

