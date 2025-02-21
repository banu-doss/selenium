package seleniumjava.Tests;



import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import seleniumjava.Testscomponent.Basetest;
import seleniumjava.pageobjects.cartpage;
import seleniumjava.pageobjects.checkoutpage;
import seleniumjava.pageobjects.confirmationpage;
import seleniumjava.pageobjects.orderpage;
import seleniumjava.pageobjects.productcatalogue;



public class submitordertest extends Basetest{
	String productName="IPHONE 13 PRO";
	
	@Test
	public  void submitorder() throws InterruptedException, IOException {
	
productcatalogue catalogue=landing.loginApplication("sundu123@gmail.com", "!01Sundu");
List<WebElement>products=catalogue.getproductlist();
catalogue.addproducttocart(productName);
Thread.sleep(3000);
cartpage cart=catalogue.gotocartpage();	

Boolean match=cart.verifyproductdisplay(productName);
//Assert.isTrue(match, productName, null);
Thread.sleep(2000);
cart.gotocheckout();
checkoutpage checkout=new checkoutpage(driver);
checkout.selectcountryname("india");
Thread.sleep(3000);
checkout.submitorder();
confirmationpage confirmation=new confirmationpage(driver);
String confirmmessage=confirmation.getconfirmation();
Thread.sleep(2000);
//Assert.isTrue(confirmmessage.equalsIgnoreCase("THANK YOU FOR THE ORDER."), confirmmessage, true); 
//Assert.assertTrue(confirmmessage.equalsIgnoreCase("THANK YOU FOR THE ORDER."));
}

@Test(dependsOnMethods= {"submitorder"})	


	public void orderhistory() throws InterruptedException
	{
	productcatalogue catalogue=landing.loginApplication("sundu123@gmail.com", "!01Sundu");
	orderpage order=catalogue.gotoorderpage();
	order.verifyordertodisplay(productName);
	}

}
